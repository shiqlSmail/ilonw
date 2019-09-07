package com.ilonw.api.service;

import com.ilonw.server.bo.shop.OmsCartItem;

import java.util.List;
import java.util.Map;

/**
 * 购物车管理Service
 */
public interface OmsCartItemService {
    /**
     * 查询购物车中是否包含该商品，有增加数量，无添加到购物车
     */
    Map<String, Object> add(OmsCartItem cartItem);

    /**
     * 根据会员编号获取购物车列表
     */
    Map<String, Object>  list(String memberId);

    /**
     * 获取包含促销活动信息的购物车列表
     */
    Map<String, Object> listPromotion(String memberId);

    /**
     * 修改某个购物车商品的数量
     */
    Map<String, Object> updateQuantity(Long id, String memberId, Integer quantity);

    /**
     * 批量删除购物车中的商品
     */
    Map<String, Object>  delete(String memberId, List<Long> ids);

    /**
     *获取购物车中用于选择商品规格的商品信息
     */
    Map<String, Object>  getCartProduct(Long productId);

    /**
     * 修改购物车中商品的规格
     */
    Map<String, Object>  updateAttr(OmsCartItem cartItem);

    /**
     * 清空购物车
     */
    Map<String, Object>  clear(String memberId);
}
