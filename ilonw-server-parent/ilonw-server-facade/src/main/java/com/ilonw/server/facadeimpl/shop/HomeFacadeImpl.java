package com.ilonw.server.facadeimpl.shop;


import com.ilonw.server.biz.shop.HomeService;
import com.ilonw.server.bo.shop.CmsSubject;
import com.ilonw.server.bo.shop.HomeContentResult;
import com.ilonw.server.bo.shop.Product;
import com.ilonw.server.bo.shop.ProductCategory;
import com.ilonw.server.facade.shop.HomeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页内容管理Service
 */
@Service("homeFacade")
public class HomeFacadeImpl implements HomeFacade {
    @Autowired
    private HomeService homeService;

    /**
     * 获取首页内容
     */
    public HomeContentResult content() {
        return homeService.content();
    }

    /**
     * 首页商品推荐
     */
    public List<Product> recommendProductList(Integer pageSize, Integer pageNum) {
        return homeService.recommendProductList(pageSize,pageNum);
    }

    /**
     * 获取商品分类
     *
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    public List<ProductCategory> getProductCateList(Long parentId) {
        return homeService.getProductCateList(parentId);
    }

    /**
     * 根据专题分类分页获取专题
     *
     * @param cateId 专题分类id
     */
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        return homeService.getSubjectList(cateId,pageSize,pageNum);
    }
}
