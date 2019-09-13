package com.ilonw.server.biz.shop;

import com.ilonw.server.bo.shop.ProductCategory;
import com.ilonw.server.bto.shop.ProductCategoryParam;
import com.ilonw.server.bo.shop.ProductCategoryWithChildrenItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品分类Service
 */
public interface ProductCategoryService {
    @Transactional
    int create(ProductCategoryParam pmsProductCategoryParam);

    @Transactional
    int update(Long id, ProductCategoryParam pmsProductCategoryParam);

    List<ProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    int delete(Long id);

    ProductCategory getItem(Long id);

    int updateNavStatus(List<Long> ids, Integer navStatus);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    List<ProductCategoryWithChildrenItem> listWithChildren();
}
