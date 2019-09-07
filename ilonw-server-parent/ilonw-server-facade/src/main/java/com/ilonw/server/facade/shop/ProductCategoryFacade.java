package com.ilonw.server.facade.shop;

import com.ilonw.server.bo.shop.ProductCategory;
import com.ilonw.server.bto.shop.ProductCategoryParam;
import com.ilonw.server.bo.shop.ProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 产品分类facade
 */
public interface ProductCategoryFacade {
    int create(ProductCategoryParam pmsProductCategoryParam);

    int update(Long id, ProductCategoryParam pmsProductCategoryParam);

    List<ProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    int delete(Long id);

    ProductCategory getItem(Long id);

    int updateNavStatus(List<Long> ids, Integer navStatus);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    List<ProductCategoryWithChildrenItem> listWithChildren();
}
