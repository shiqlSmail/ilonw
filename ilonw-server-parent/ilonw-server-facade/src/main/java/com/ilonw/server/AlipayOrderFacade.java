package com.ilonw.server;

import com.ilonw.server.bto.AlipayOrderBTO;

/**
 * 支付宝支付订单处理器
 */
public interface AlipayOrderFacade {

    public void add(AlipayOrderBTO alipayOrderBTO);

    public void update(AlipayOrderBTO alipayOrderBTO);

    public AlipayOrderBTO queryByOuttradeno(String outtradeno);

}
