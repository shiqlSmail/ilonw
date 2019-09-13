package com.ilonw.server.biz.shop;


import com.ilonw.server.bo.shop.OmsCartItem;
import com.ilonw.server.bto.shop.CartPromotionItem;

import java.util.List;

/**
 * 促销管理Service
 */
public interface OmsPromotionService {
    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
