package com.ilonw.api.manager;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.util.SignUtils;
import com.ilonw.api.service.AlipayOrderService;
import com.ilonw.api.service.WxPayOrderService;
import com.ilonw.api.util.PaymentProperties;
import com.ilonw.server.bto.AlipayOrderBTO;
import com.ilonw.server.bto.WxpayOrderBTO;
import com.server.tools.exceptions.BizException;
import com.shiqilong.common.tools.util.DozerMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Component
public class PaymentManager extends PaymentProperties {
	protected static final Logger log = LoggerFactory.getLogger(PaymentManager.class);

	@Resource(name = "wxPayService")
	private WxPayService wxPayService;

	@Autowired
	private WxPayOrderService wxPayOrderService;

	@Autowired
	private AlipayOrderService alipayOrderService;

	/**
	 * 统一下单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
	 * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
	 * 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
	 *
	 ** @param spbillCreateIp
	 * 	 * @param moneyYuan
	 * 	 * @param orderId
	 * 	 * @param body
	 * 	 * @return
	 * 	 * @throws WxPayException* @param request
	 *
	 *    请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
	 */
	public Map<String, Object> unifiedOrder(String spbillCreateIp, Integer moneyYuan, String orderId, String body)
			throws WxPayException {
		WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();

		Random rand = new Random();
		String randStr = String.valueOf(rand.nextInt(1000));
		String outtradeno = orderId + "-" + randStr;
		String nonceStr = UUID.randomUUID().toString().replace("-", "");

		request.setNonceStr(nonceStr);
		request.setBody(body);
		request.setOutTradeNo(outtradeno);
		request.setTotalFee(moneyYuan);
		request.setSpbillCreateIp(spbillCreateIp);
		request.setNotifyURL(wecharpayNotifyUrl);
		request.setTradeType("APP");
		request.setLimitPay("no_credit");

		WxpayOrderBTO wxpayOrder = new WxpayOrderBTO();
		DozerMapperUtil.beanCopy(request, wxpayOrder);
		wxpayOrder.setWxpayOrderId(orderId);
		wxPayOrderService.add(wxpayOrder);

		WxPayUnifiedOrderResult wxPayUnifiedOrderResult = this.wxPayService.unifiedOrder(request);

		wxpayOrder = wxPayOrderService.queryByOuttradeno(outtradeno);

		String return_code = wxPayUnifiedOrderResult.getReturnCode();
		String return_msg = wxPayUnifiedOrderResult.getReturnMsg();
		wxpayOrder.setReturnCode(return_code);
		wxpayOrder.setReturnMsg(return_msg);
		boolean success = false;
		Map retParams = new HashMap<>();
		String result_code = wxPayUnifiedOrderResult.getResultCode();
		wxpayOrder.setResultCode(result_code);
		if (result_code.equals("SUCCESS")) {
			String prepay_id = wxPayUnifiedOrderResult.getPrepayId();
			wxpayOrder.setPrepayId(prepay_id);
			retParams.put("appid", wxPayService.getConfig().getAppId());
			retParams.put("partnerid", wxPayService.getConfig().getMchId());
			retParams.put("prepayid", prepay_id);
			retParams.put("package", "Sign=WXPay");
			retParams.put("noncestr", UUID.randomUUID().toString().replace("-", ""));
			retParams.put("timestamp",  String.valueOf(System.currentTimeMillis() / 1000L));
			String sign = SignUtils.createSign(retParams, (String)null, wxPayService.getConfig().getMchKey(), false);
			retParams.put("sign", sign);
			success = true;
		}
		wxPayOrderService.update(wxpayOrder);
		if (success) {
			return retParams;
		}
		throw new BizException(return_msg);
	}

   /**
    * 支付宝支付
    * @param
    * @param moneyYuan
    * @param orderId
    * @param body
    * @return
    * @throws WxPayException
    */
   public Map<String, Object> alipayUnifiedOrder(BigDecimal moneyYuan, String orderId, String body,String userId) throws WxPayException {
	   Random rand = new Random();
		String randStr = String.valueOf(rand.nextInt(1000));
		String outtradeno = orderId + "-" + randStr;

		AlipayOrderBTO alipayOrder = new AlipayOrderBTO();
		alipayOrder.setOrderId(orderId);
		alipayOrder.setOutTradeNo(outtradeno);
		alipayOrder.setTotalAmount(moneyYuan);
		alipayOrder.setUserId(userId);
	   alipayOrderService.add(alipayOrder);

		AlipayClient alipayClient = new DefaultAlipayClient(alipayGateway, alipayAppid,alipayAppprivatekey, "json", alipayCharset, alipayPublickey, "RSA2");
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody(body);
		model.setSubject(body);
		model.setOutTradeNo(alipayOrder.getOutTradeNo());
		model.setTimeoutExpress("600m");
		model.setTotalAmount(alipayOrder.getTotalAmount().toString());
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl(alipayNotifyurl);
		try {
			//这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			alipayOrder.setReturnBody(body);
			alipayOrderService.update(alipayOrder);

			Map retParams = new HashMap<>();
			retParams.put("app_id", alipayAppid);
			retParams.put("app_private_key", alipayAppprivatekey);
			retParams.put("notify_url", alipayNotifyurl);
			retParams.put("out_trade_no", outtradeno);
			retParams.put("subject",  body);
			retParams.put("total_fee", moneyYuan);
			return retParams;
		} catch (AlipayApiException e) {
			e.printStackTrace();
			throw new BizException("失败");
		}
	}
}
