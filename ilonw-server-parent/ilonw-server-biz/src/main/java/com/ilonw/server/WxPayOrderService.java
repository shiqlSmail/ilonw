package com.ilonw.server;


import com.ilonw.server.bo.WxpayOrderBO;
import com.ilonw.server.bto.WxpayOrderBTO;

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
