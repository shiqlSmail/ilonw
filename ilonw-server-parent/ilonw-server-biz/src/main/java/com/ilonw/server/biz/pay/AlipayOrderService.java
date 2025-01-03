package com.ilonw.server.biz.pay;

import com.ilonw.server.bo.pay.AlipayOrderBO;

/**
 * 支付宝支付订单处理器
 */
public interface AlipayOrderService {

    /**
     * 保存支付宝订单信息
     * @param alipayOrderBO
     * @return
     */
    public void add(AlipayOrderBO alipayOrderBO);

    /**
     * 更新支付宝订单信息
     * @param alipayOrderBO
     * @return
     */
    public void update(AlipayOrderBO alipayOrderBO);

    /**
     * 根据订单号查询支付宝订单信息
     * @param outtradeno
     * @return
     */
    public AlipayOrderBO queryByOuttradeno(String outtradeno);

}
