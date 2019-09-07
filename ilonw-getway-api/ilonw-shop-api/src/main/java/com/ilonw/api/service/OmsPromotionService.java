package com.ilonw.api.service;


import com.ilonw.server.bo.shop.OmsCartItem;

import java.util.List;
import java.util.Map;

/**
 * 促销管理Service
 */
public interface OmsPromotionService {
    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    Map<String, Object> calcCartPromotion(List<OmsCartItem> cartItemList);
}
