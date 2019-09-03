package com.ilonw.server.biz.shop;

import com.ilonw.server.bo.shop.SkuStock;

import java.util.List;

/**
 * sku商品库存管理service
 */
public interface SkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索
     */
    List<SkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(Long pid, List<SkuStock> skuStockList);
}
