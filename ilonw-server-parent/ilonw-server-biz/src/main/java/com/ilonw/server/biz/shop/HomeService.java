package com.ilonw.server.biz.shop;


import com.ilonw.server.bo.shop.CmsSubject;
import com.ilonw.server.bo.shop.HomeContentResult;
import com.ilonw.server.bo.shop.Product;
import com.ilonw.server.bo.shop.ProductCategory;

import java.util.List;

/**
 * 首页内容管理Service
 */
public interface HomeService {

    /**
     * 获取首页内容
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     */
    List<Product> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    List<ProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);
}
