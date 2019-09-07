package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.HomeService;
import com.ilonw.server.bo.shop.CmsSubject;
import com.ilonw.server.bo.shop.HomeContentResult;
import com.ilonw.server.bo.shop.Product;
import com.ilonw.server.bo.shop.ProductCategory;
import com.ilonw.server.facade.shop.HomeFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 首页内容管理Service
 */
@Service("homeService")
public class HomeServiceImpl extends BaseService implements HomeService {

    @Resource
    private HomeFacade homeFacade;
    /**
     * 获取首页内容
     */
    public Map<String, Object> content(){
        HomeContentResult homeContentResult = homeFacade.content();
        if (null == homeContentResult) {
            return getFailMap();
        } else {
            return getSuccessMapObject(homeContentResult);
        }
    }

    /**
     * 首页商品推荐
     */
    public Map<String, Object> recommendProductList(Integer pageSize, Integer pageNum){
        List<Product> productList = homeFacade.recommendProductList(pageSize,pageNum);
        if (null == productList || productList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productList);
        }
    }

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    public Map<String, Object> getProductCateList(Long parentId){
        List<ProductCategory> productCategoryList = homeFacade.getProductCateList(parentId);
        if (null == productCategoryList || productCategoryList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productCategoryList);
        }
    }

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     */
    public Map<String, Object> getSubjectList(Long cateId, Integer pageSize, Integer pageNum){
        List<CmsSubject> cmsSubjectList =  homeFacade.getSubjectList(cateId,pageSize,pageNum);
        if (null == cmsSubjectList || cmsSubjectList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(cmsSubjectList);
        }
    }
}
