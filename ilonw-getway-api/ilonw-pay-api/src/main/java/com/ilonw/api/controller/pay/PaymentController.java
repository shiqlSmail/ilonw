package com.ilonw.api.controller.pay;

import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.ilonw.api.base.BaseController;
import com.ilonw.api.enums.PayTypeEnum;
import com.ilonw.api.manager.PaymentManager;
import com.ilonw.api.service.OrderService;
import com.ilonw.api.vo.PaymentVO;
import com.ilonw.server.bto.OrderinfoBTO;
import com.server.tools.result.APIBaseResult;
import com.server.tools.util.IpUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController extends BaseController {

	@Resource
	protected OrderService orderFacade;

	@Resource
	protected PaymentManager wxPayManager;

	/**
	 * 订单支付
	 * 需判断是微信支付还是支付宝支付
	 * @param paymentVO
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pay", produces = "application/json", method = { RequestMethod.POST })
	public APIBaseResult pay(@RequestBody PaymentVO paymentVO, HttpServletRequest request){
		long now = System.currentTimeMillis();
		APIBaseResult result = new APIBaseResult();
		Map<String, Object> map = new HashMap<>();
		try {
			String spbillCreateIp = IpUtils.getIpAddr(request);
			OrderinfoBTO orderinfoBO = orderFacade.queryById(paymentVO.getOrderNumber());
			if (null == orderinfoBO) {
				result.setMessage("订单编号不存在");
				result.setErrorCode("ORDER_ERROR_1001");
				map.put("appMessage", "订单号错误");
				result.setData(map);
				return getAPIResult(result);
			}
			orderinfoBO.setPayType(paymentVO.getPayType());
			orderFacade.update(orderinfoBO);
			if (!paymentVO.getPayType().equals(PayTypeEnum.WECHAT.getCode())) {
				map.put("data", wxPayManager.alipayUnifiedOrder(orderinfoBO.getMoney(), orderinfoBO.getOrderId(), "shiqilong",orderinfoBO.getUserId()));
			}else{
				map.put("data", wxPayManager.unifiedOrder(spbillCreateIp, orderinfoBO.getMoney().multiply(new BigDecimal("100")).intValue(), orderinfoBO.getOrderId(), "shiqilong"));
			}
		} catch (WxPayException e) {
			e.printStackTrace();
		}
		return getIntefaceData(request,map, "/payment", "/pay",now,"param:"+paymentVO,"订单支付");
	}


	@RequestMapping(value = "/pay1", produces = "application/json", method = { RequestMethod.POST })
	public Object pay1(@RequestBody PaymentVO paymentVO, HttpServletRequest request){
		OrderinfoBTO orderinfoBO = orderFacade.queryById(paymentVO.getOrderNumber());
		return JSONObject.toJSON(orderinfoBO);
	}
}
