package com.ilonw.server.biz.user;


import com.ilonw.server.bo.OrderinfoBO;
import com.ilonw.server.bto.OrderinfoBTO;

/**
 * 订单处理器
 */
public interface OrderService {
    /**
     * 保存订单信息
     * @param orderinfoBO
     * @return
     */
    public void add(OrderinfoBO orderinfoBO);

    /**
     * 更新订单信息
     * @param orderinfoBO
     * @return
     */
    public void update(OrderinfoBO orderinfoBO);

    /**
     * 查看订单信息
     * @param orderId
     * @return
     */
    public OrderinfoBO queryById(String orderId);

}

