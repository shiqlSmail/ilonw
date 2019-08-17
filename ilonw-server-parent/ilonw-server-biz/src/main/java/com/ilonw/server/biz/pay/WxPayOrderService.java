package com.ilonw.server.biz.pay;


import com.ilonw.server.bo.pay.WxpayOrderBO;

/**
 * 微信支付订单处理器
 */
public interface WxPayOrderService {
    /**
     * 保存微信订单信息
     * @param wxpayOrderBO
     * @return
     */
    public void add(WxpayOrderBO wxpayOrderBO);

    /**
     * 更新微信订单信息
     * @param wxpayOrderBO
     * @return
     */
    public void update(WxpayOrderBO wxpayOrderBO);

    /**
     * 查看微信订单信息
     * @param outtradeno
     * @return
     */
    public WxpayOrderBO queryByOuttradeno(String outtradeno);
}
