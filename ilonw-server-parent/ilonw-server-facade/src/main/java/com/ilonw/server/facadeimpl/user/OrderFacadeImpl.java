package com.ilonw.server.facadeimpl.user;

import com.ilonw.server.facade.user.OrderFacade;
import com.ilonw.server.biz.user.OrderService;
import com.ilonw.server.bo.OrderinfoBO;
import com.ilonw.server.bto.OrderinfoBTO;
import com.ilonw.server.convert.OrderinfoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单处理器实现
 * shiqilong
 */
@Service("orderFacade")
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderService orderService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Throwable.class})
    public void add(OrderinfoBTO orderinfoBTO) {
        orderService.add(OrderinfoConvert.convertBTO(orderinfoBTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false,rollbackFor = {Throwable.class})
    public void update(OrderinfoBTO orderinfoBTO) {
        orderService.update(OrderinfoConvert.convertBTO(orderinfoBTO));
    }

    @Override
    public OrderinfoBTO queryById(String orderId) {
        OrderinfoBO bo = orderService.queryById(orderId);
        return OrderinfoConvert.convertBO(bo);
    }
}

