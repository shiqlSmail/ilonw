package com.ilonw.api.service.impl;

import com.ilonw.api.service.WxPayOrderService;
import com.ilonw.server.bto.WxpayOrderBTO;
import com.ilonw.server.facade.pay.WxPayOrderFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 微信支付处理器实现
 */
@Service
public class WxPayOrderServiceImpl implements WxPayOrderService {
	@Resource
    private WxPayOrderFacade wxPayOrderFacade;

	@Override
	public void add(WxpayOrderBTO wxpayOrderBTO) {
		 wxPayOrderFacade.add(wxpayOrderBTO);
	}

    @Override
	public void update(WxpayOrderBTO wxpayOrderBTO) {
		 wxPayOrderFacade.update(wxpayOrderBTO);
	}

    @Override
	public WxpayOrderBTO queryByOuttradeno(String outtradeno) {
		return wxPayOrderFacade.queryByOuttradeno(outtradeno);
	}
}
