package com.ilonw.server.biz.shop;

import com.ilonw.server.bo.shop.SmsCouponHistory;
import com.ilonw.server.bo.shop.SmsCouponHistoryDetail;
import com.ilonw.server.bto.shop.CartPromotionItem;
import com.server.tools.result.CommonResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户优惠券管理Service
 */
public interface UmsMemberCouponService {
    /**
     * 会员添加优惠券
     */
    @Transactional
    CommonResult add(Long couponId);

    /**
     * 获取优惠券列表
     * @param useStatus 优惠券的使用状态
     */
    List<SmsCouponHistory> list(Integer useStatus);

    /**
     * 根据购物车信息获取可用优惠券
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);
}
