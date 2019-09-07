package com.ilonw.server.facadeimpl.shop;

import com.ilonw.server.biz.shop.ProductCategoryService;
import com.ilonw.server.bo.shop.ProductCategory;
import com.ilonw.server.bto.shop.ProductCategoryParam;
import com.ilonw.server.bo.shop.ProductCategoryWithChildrenItem;
import com.ilonw.server.facade.shop.ProductCategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductCategoryService实现类
 */
@Service("productCategoryFacade")
public class ProductCategoryFacadeImpl implements ProductCategoryFacade {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public int create(ProductCategoryParam ProductCategoryParam) {
        return productCategoryService.create(ProductCategoryParam);
    }

    @Override
    public int update(Long id, ProductCategoryParam productCategoryParam) {
        return productCategoryService.update(id,productCategoryParam);
    }

    @Override
    public List<ProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        return productCategoryService.getList(parentId,pageSize,pageNum);
    }

    @Override
    public int delete(Long id) {
        return productCategoryService.delete(id);
    }

    @Override
    public ProductCategory getItem(Long id) {
        return productCategoryService.getItem(id);
    }

    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        return productCategoryService.updateNavStatus(ids, navStatus);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        return productCategoryService.updateShowStatus(ids, showStatus);
    }

    @Override
    public List<ProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryService.listWithChildren();
    }
}
