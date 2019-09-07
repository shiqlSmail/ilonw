package com.ilonw.api.service;

import com.ilonw.server.bo.shop.SmsCouponHistory;
import com.ilonw.server.bo.shop.SmsCouponHistoryDetail;
import com.ilonw.server.bto.shop.CartPromotionItem;
import com.server.tools.result.CommonResult;

import java.util.List;
import java.util.Map;

/**
 * 用户优惠券管理Service
 */
public interface UmsMemberCouponService {
    /**
     * 会员添加优惠券
     */
    CommonResult add(Long couponId);

    /**
     * 获取优惠券列表
     * @param useStatus 优惠券的使用状态
     */
    Map<String, Object> list(Integer useStatus);

    /**
     * 根据购物车信息获取可用优惠券
     */
    Map<String, Object> listCart(List<CartPromotionItem> cartItemList, Integer type);
}
