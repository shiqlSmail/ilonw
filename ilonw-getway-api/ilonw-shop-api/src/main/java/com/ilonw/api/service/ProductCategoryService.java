package com.ilonw.api.service;

import com.ilonw.server.bto.shop.ProductCategoryParam;

import java.util.List;
import java.util.Map;

/**
 * 产品分类Service
 */
public interface ProductCategoryService {
    Map<String, Object> create(ProductCategoryParam pmsProductCategoryParam);

    Map<String, Object> update(Long id, ProductCategoryParam pmsProductCategoryParam);

    Map<String, Object> getList(Long parentId, Integer pageSize, Integer pageNum);

    Map<String, Object> delete(Long id);

    Map<String, Object> getItem(Long id);

    Map<String, Object> updateNavStatus(List<Long> ids, Integer navStatus);

    Map<String, Object> updateShowStatus(List<Long> ids, Integer showStatus);

    Map<String, Object> listWithChildren();
}
