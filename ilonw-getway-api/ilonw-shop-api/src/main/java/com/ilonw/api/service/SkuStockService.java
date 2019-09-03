package com.ilonw.api.service;

import com.ilonw.server.bo.shop.SkuStock;

import java.util.List;
import java.util.Map;

/**
 * sku商品库存管理Service
 */
public interface SkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索
     */
    Map<String, Object> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    Map<String, Object> update(Long pid, List<SkuStock> skuStockList);
}
