package com.ilonw.server.facadeimpl.shop;

import com.ilonw.server.biz.shop.OmsPortalOrderService;
import com.ilonw.server.bto.shop.ConfirmOrderResult;
import com.ilonw.server.bto.shop.OrderParam;
import com.ilonw.server.facade.shop.OmsPortalOrderFacade;
import com.server.tools.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 */
@Service("omsPortalOrderFacade")
public class OmsPortalOrderFacadeImpl implements OmsPortalOrderFacade {
    @Autowired
    private OmsPortalOrderService omsPortalOrderService;

    @Override
    public ConfirmOrderResult generateConfirmOrder() {
        return omsPortalOrderService.generateConfirmOrder();
    }

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        return omsPortalOrderService.generateOrder(orderParam);
    }

    @Override
    public CommonResult paySuccess(Long orderId) {
        return omsPortalOrderService.paySuccess(orderId);
    }

    @Override
    public CommonResult cancelTimeOutOrder() {
        return omsPortalOrderService.cancelTimeOutOrder();
    }

    @Override
    public void cancelOrder(Long orderId) {
        omsPortalOrderService.cancelOrder(orderId);
    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {
        omsPortalOrderService.sendDelayMessageCancelOrder(orderId);
    }
}
