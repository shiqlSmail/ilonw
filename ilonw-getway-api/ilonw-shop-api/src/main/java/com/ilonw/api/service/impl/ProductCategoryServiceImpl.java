package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.ProductCategoryService;
import com.ilonw.server.bo.shop.ProductCategory;
import com.ilonw.server.bo.shop.ProductCategoryParam;
import com.ilonw.server.bo.shop.ProductCategoryWithChildrenItem;
import com.ilonw.server.facade.shop.ProductCategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ProductCategoryService实现类
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl  extends BaseService  implements ProductCategoryService {
    @Autowired
    private ProductCategoryFacade productCategoryFacade;

    @Override
    public Map<String, Object> create(ProductCategoryParam ProductCategoryParam) {
        int count = productCategoryFacade.create(ProductCategoryParam);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> update(Long id, ProductCategoryParam productCategoryParam) {
        int count = productCategoryFacade.update(id,productCategoryParam);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public  Map<String, Object> getList(Long parentId, Integer pageSize, Integer pageNum) {
        List<ProductCategory> productCategories = productCategoryFacade.getList(parentId,pageSize,pageNum);
        if (null == productCategories || productCategories.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productCategories);
        }

    }

    @Override
    public Map<String, Object> delete(Long id) {
        int count = productCategoryFacade.delete(id);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> getItem(Long id) {
        ProductCategory productCategory = productCategoryFacade.getItem(id);
        if (null == productCategory) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productCategory);
        }
    }

    @Override
    public Map<String, Object> updateNavStatus(List<Long> ids, Integer navStatus) {
        int count = productCategoryFacade.updateNavStatus(ids, navStatus);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> updateShowStatus(List<Long> ids, Integer showStatus) {
        int count = productCategoryFacade.updateShowStatus(ids, showStatus);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> listWithChildren() {
        List<ProductCategoryWithChildrenItem> productCategoryWithChildrenItems = productCategoryFacade.listWithChildren();
        if (null == productCategoryWithChildrenItems || productCategoryWithChildrenItems.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productCategoryWithChildrenItems);
        }
    }
}
