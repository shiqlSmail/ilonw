package com.ilonw.server.impl;

import com.ilonw.server.WxPayOrderFacade;
import com.ilonw.server.WxPayOrderService;
import com.ilonw.server.bo.WxpayOrderBO;
import com.ilonw.server.bto.WxpayOrderBTO;
import com.ilonw.server.convert.WxpayOrderConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信支付处理器实现
 */
@Service("wxPayOrderFacade")
public class WxPayOrderFacadeImpl implements WxPayOrderFacade {
	@Autowired
    private WxPayOrderService wxPayOrderService;

	@Override
	public void add(WxpayOrderBTO wxpayOrderBTO) {
        wxPayOrderService.add(WxpayOrderConvert.convertBTO(wxpayOrderBTO));
	}

    @Override
	public void update(WxpayOrderBTO wxpayOrderBTO) {
        wxPayOrderService.update(WxpayOrderConvert.convertBTO(wxpayOrderBTO));
	}

    @Override
	public WxpayOrderBTO queryByOuttradeno(String outtradeno) {
		WxpayOrderBO bo = wxPayOrderService.queryByOuttradeno(outtradeno);
        return WxpayOrderConvert.convertBO(bo);
	}
}
