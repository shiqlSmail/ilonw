package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.OmsPortalOrderService;
import com.ilonw.server.bto.shop.ConfirmOrderResult;
import com.ilonw.server.bto.shop.OrderParam;
import com.ilonw.server.facade.shop.OmsPortalOrderFacade;
import com.server.tools.result.CommonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 前台订单管理Service
 */
@Service("omsPortalOrderService")
public class OmsPortalOrderServiceImpl  extends BaseService implements OmsPortalOrderService {
    @Resource
    private OmsPortalOrderFacade omsPortalOrderFacade;

    @Override
    public Map<String, Object> generateConfirmOrder() {
        ConfirmOrderResult confirmOrderResult = omsPortalOrderFacade.generateConfirmOrder();
        if (null == confirmOrderResult) {
            return getFailMap();
        } else {
            return getSuccessMapObject(confirmOrderResult);
        }
    }

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        return omsPortalOrderFacade.generateOrder(orderParam);
    }

    @Override
    public CommonResult paySuccess(Long orderId) {
        return omsPortalOrderFacade.paySuccess(orderId);
    }

    @Override
    public CommonResult cancelTimeOutOrder() {
        return omsPortalOrderFacade.cancelTimeOutOrder();
    }

    //todo
    @Override
    public Map<String, Object> cancelOrder(Long orderId) {
        omsPortalOrderFacade.cancelOrder(orderId);
        return null;
    }

    //todo
    @Override
    public Map<String, Object> sendDelayMessageCancelOrder(Long orderId) {
        omsPortalOrderFacade.sendDelayMessageCancelOrder(orderId);
        return null;
    }
}
