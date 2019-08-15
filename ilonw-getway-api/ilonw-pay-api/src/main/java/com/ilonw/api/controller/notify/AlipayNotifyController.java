package com.ilonw.api.controller.notify;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.ilonw.api.base.BaseController;
import com.ilonw.api.enums.PayStateEnum;
import com.ilonw.api.service.AlipayOrderService;
import com.ilonw.api.service.OrderService;
import com.ilonw.api.util.PaymentProperties;
import com.ilonw.server.bto.AlipayOrderBTO;
import com.ilonw.server.bto.OrderinfoBTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.alipay.api.AlipayConstants.APP_ID;


@RestController
@RequestMapping("/alipay")
public class AlipayNotifyController extends BaseController {
    protected final Logger log = LoggerFactory.getLogger(AlipayNotifyController.class);

    @Autowired
    private AlipayOrderService alipayOrderService;

    @Autowired
    private OrderService orderService;

	@Resource(name = "paymentProperties")
    private PaymentProperties paymentProperties;

	private ExecutorService executorService = Executors.newFixedThreadPool(20);

    /**
     * <pre>
     * 第一步:验证签名,签名通过后进行第二步
     * 第二步:按一下步骤进行验证
         * 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
         * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
         * 3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
         * 4、验证app_id是否为该商户本身。上述1、2、3、4有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。
         * 在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。
         * 在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
     * </pre>
     * 
     * @param request
     * @return
     */
    @RequestMapping("/notify")
    @ResponseBody
    public String callback(HttpServletRequest request) {
        Map<String, String> params = convertRequestParamsToMap(request); // 将异步通知中收到的待验证所有参数都存放到map中
        String paramsJson = JSON.toJSONString(params);
        log.info("支付宝回调，{}", paramsJson);
        try {
            // 调用SDK验证签名  boolean flag = AlipaySignature.rsaCheckV1(params, ConstantWechat.ALIPAY_PUBLICKEY, ConstantWechat.ALIPAY_CHARSET, "RSA2");
            boolean signVerified = AlipaySignature.rsaCheckV1(params, paymentProperties.alipayPublickey,  paymentProperties.alipayCharset, "RSA2");
            if (signVerified) {
                log.info("支付宝回调签名认证成功");
                // 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
                if (!paymentProperties.alipayAppid.equals(params.get(APP_ID)) || !params.containsKey("out_trade_no") || !"TRADE_SUCCESS".equals(params.get("trade_status"))) {
    				return "fail";
    			}
                // 另起线程处理业务
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        // 支付成功
                    	if (paymentProperties.alipayAppid.equals(params.get(APP_ID)) || params.containsKey("out_trade_no") || "TRADE_SUCCESS".equals(params.get("trade_status"))) {
                            // 处理支付成功逻辑
                            try {
                            	log.info("==============================开始支付宝回调============================================================================================================");
                                AlipayOrderBTO alipayOrder = alipayOrderService.queryByOuttradeno(params.get("out_trade_no"));
                    			OrderinfoBTO order = orderService.queryById(alipayOrder.getOrderId().toString());
                    			order.setPayState(PayStateEnum.SUCCESS.getCode());
                                orderService.update(order);

                                //充值成功，所作操作
                                //TODO
                            } catch (Exception e) {
                                log.error("支付宝回调业务处理报错,params:" + paramsJson, e);
                            }
                        } else {
                            log.error("没有处理支付宝回调业务，支付宝交易状态：{},params:{}",paramsJson);
                        }
                    }
                });
                // 如果签名验证正确，立即返回success，后续业务另起线程单独处理
                // 业务处理失败，可查看日志进行补偿，跟支付宝已经没多大关系。
                return "success";
            } else {
                log.info("支付宝回调签名认证失败，signVerified=false, paramsJson:{}", paramsJson);
                return "failure";
            }
        } catch (AlipayApiException e) {
            log.error("支付宝回调签名认证失败,paramsJson:{},errorMsg:{}", paramsJson, e.getMessage());
            return "failure";
        }
    }

    // 将request中的参数转换成Map
    private static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap<String, String>();

        Set<Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();

        for (Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;

            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.toString().substring(1));
            } else {
                retMap.put(name, "");
            }
        }
        return retMap;
    }
}
