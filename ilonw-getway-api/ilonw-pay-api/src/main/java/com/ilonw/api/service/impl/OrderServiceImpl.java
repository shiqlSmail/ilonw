package com.ilonw.api.service.impl;

import com.ilonw.api.service.OrderService;
import com.ilonw.server.facade.user.OrderFacade;
import com.ilonw.server.bto.OrderinfoBTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单处理器实现
 * shiqilong
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    private OrderFacade orderFacade;

    @Override
    public void add(OrderinfoBTO orderinfoBTO) {
        orderFacade.add(orderinfoBTO);
    }

    @Override
    public void update(OrderinfoBTO orderinfoBTO) {
        orderFacade.update(orderinfoBTO);
    }

    @Override
    public OrderinfoBTO queryById(String orderId) {
        return orderFacade.queryById(orderId);
    }
}

