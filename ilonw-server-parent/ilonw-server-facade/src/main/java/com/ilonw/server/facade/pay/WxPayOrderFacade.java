package com.ilonw.server.facade.pay;

import com.ilonw.server.bto.WxpayOrderBTO;

/**
 * 微信支付订单处理器
 */
public interface WxPayOrderFacade {
    public void add(WxpayOrderBTO wxpayOrderBTO);

    public void update(WxpayOrderBTO wxpayOrderBTO);

    public WxpayOrderBTO queryByOuttradeno(String outtradeno);
}
