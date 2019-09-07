package com.ilonw.api.service;


import java.util.Map;

/**
 * 首页内容管理Service
 */
public interface HomeService {

    /**
     * 获取首页内容
     */
    Map<String, Object> content();

    /**
     * 首页商品推荐
     */
    Map<String, Object> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    Map<String, Object> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     */
    Map<String, Object> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);
}
