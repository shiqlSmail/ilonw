package com.ilonw.server.impl;

import com.ilonw.server.OrderService;
import com.ilonw.server.bo.OrderinfoBO;
import com.ilonw.server.repository.OrderinfoRepository;
import com.server.tools.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单处理器实现
 * shiqilong
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderinfoRepository orderMapper;

    /**
     * 保存订单信息
     * @param orderinfoBO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Throwable.class})
    public void add(OrderinfoBO orderinfoBO) {
        orderinfoBO.setOrderId(UUIDUtil.getOrderIdByUUId());
        orderMapper.insertSelective(orderinfoBO);
    }

    /**
     * 更新订单信息
     * @param orderinfoBO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false,rollbackFor = {Throwable.class})
    public void update(OrderinfoBO orderinfoBO) {
        orderMapper.updateByPrimaryKeySelective(orderinfoBO);
    }

    /**
     * 查看订单信息
     * @param orderId
     * @return
     */
    @Override
    public OrderinfoBO queryById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}

