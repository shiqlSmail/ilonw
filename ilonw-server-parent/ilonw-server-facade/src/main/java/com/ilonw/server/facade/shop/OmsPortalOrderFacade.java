package com.ilonw.server.facade.shop;

import com.ilonw.server.bto.shop.ConfirmOrderResult;
import com.ilonw.server.bto.shop.OrderParam;
import com.server.tools.result.CommonResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 */
public interface OmsPortalOrderFacade {
    /**
     * 根据用户购物车信息生成确认单信息
     */
    ConfirmOrderResult generateConfirmOrder();

    /**
     * 根据提交信息生成订单
     */
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     */
    CommonResult paySuccess(Long orderId);

    /**
     * 自动取消超时订单
     */
    CommonResult cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);
}
