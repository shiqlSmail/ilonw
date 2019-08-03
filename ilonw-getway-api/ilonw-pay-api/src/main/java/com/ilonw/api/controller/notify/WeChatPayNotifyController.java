package com.ilonw.api.controller.notify;

import com.github.binarywang.wxpay.bean.result.WxPayOrderCloseResult;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.ilonw.api.base.BaseController;
import com.ilonw.api.enums.PayStateEnum;
import com.ilonw.api.service.OrderService;
import com.ilonw.api.service.WxPayOrderService;
import com.ilonw.api.util.WecahtCallBack;
import com.ilonw.server.bto.OrderinfoBTO;
import com.ilonw.server.bto.WxpayOrderBTO;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 微信支付 controller
 * shiqilong
 */
@RestController
@RequestMapping("/wechatpay")
public class WeChatPayNotifyController extends BaseController {

    @Resource
    protected WxPayOrderService wxPayOrderFacade;

    @Resource
    protected OrderService orderFacade;

    @Resource(name = "wxPayService")
    protected WxPayService wxPayService;

    @RequestMapping(value = "/notify", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    WecahtCallBack webwechat(HttpServletRequest request) {
        WecahtCallBack result = new WecahtCallBack();
        SortedMap<String, String> reqMap = null;
        try {
            ServletInputStream instream = request.getInputStream();
            StringBuffer sb = new StringBuffer();
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = instream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, len));
            }
            instream.close();
            reqMap = doXMLParseWithSorted(sb.toString());// 接受微信的通知参数
            log.info("SUCCESS：" + reqMap);
            result.setReturn_code("SUCCESS");
            result.setReturn_msg("OK");
            // }
        } catch (Exception e) {
            result.setReturn_code("FAIL");
            result.setReturn_msg(e.getMessage());
        }
        // TODO 签名验证
        String out_trade_no = reqMap.get("out_trade_no").toString();
        // 1 根据out_trade_no搜索订单，查看是否存在该订单，如果不存在，直接返回failure
        WxpayOrderBTO wxpayOrderBO = wxPayOrderFacade.queryByOuttradeno(out_trade_no);
        if (wxpayOrderBO == null) {
            result.setReturn_code("FAIL");
            result.setReturn_msg("订单不存在");
        }
        if (result.getReturn_code().equals("SUCCESS")) {
            OrderinfoBTO order = orderFacade.queryById(wxpayOrderBO.getWxpayOrderId());
            order.setPayState(PayStateEnum.SUCCESS.getCode());
            orderFacade.update(order);
            //充值成功，所作操作
            //  TODO
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    public static SortedMap<String, String> doXMLParseWithSorted(String strxml) throws Exception {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
        if (null == strxml || "".equals(strxml)) {
            return null;
        }
        SortedMap<String, String> m = new TreeMap<String, String>();
        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if (children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = getChildrenText(children);
            }

            m.put(k, v);
        }

        // 关闭流
        in.close();
        return m;
    }

    @SuppressWarnings("rawtypes")
    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if (!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }
        return sb.toString();
    }

    /**
     * <pre>
     * 查询订单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2)
     * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
     * 需要调用查询接口的情况：
     * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
     * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
     * ◆ 调用被扫支付API，返回USERPAYING的状态；
     * ◆ 调用关单或撤销接口API之前，需确认支付状态；
     * 接口地址：https://api.mch.weixin.qq.com/pay/orderquery
     * </pre>
     *
     * @param wxpayOrderBO 微信订单号
     * @param wxpayOrderBO 商户系统内部的订单号，当没提供transactionId时需要传这个。
     * @RequestParam(required = false) String transactionId,
     */
    @RequestMapping(value = "/queryOrder", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public WxPayOrderQueryResult queryOrder(@RequestBody WxpayOrderBTO wxpayOrderBO) throws WxPayException {
        return this.wxPayService.queryOrder(null, wxpayOrderBO.getOutTradeNo());
    }

    /**
     * <pre>
     * 关闭订单
     * 应用场景
     * 以下情况需要调用关单接口：
     * 1. 商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；
     * 2. 系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
     * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
     * 接口地址：https://api.mch.weixin.qq.com/pay/closeorder
     * 是否需要证书：   不需要。
     * </pre>
     *
     * @param wxpayOrderBO 商户系统内部的订单号
     */
    @RequestMapping(value = "/closeOrder", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public WxPayOrderCloseResult closeOrder(@RequestBody WxpayOrderBTO wxpayOrderBO) {
        try {
            WxPayOrderCloseResult orderCloseResult = this.wxPayService.closeOrder(wxpayOrderBO.getOutTradeNo());
            return orderCloseResult;
        } catch (WxPayException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
