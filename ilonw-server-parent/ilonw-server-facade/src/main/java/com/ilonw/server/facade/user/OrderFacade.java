package com.ilonw.server.facade.user;

import com.ilonw.server.bto.OrderinfoBTO;

/**
 * 订单处理器
 */
public interface OrderFacade {
    public void add(OrderinfoBTO orderinfoBTO);

    public void update(OrderinfoBTO orderinfoBTO);

    public OrderinfoBTO queryById(String orderId);

}

