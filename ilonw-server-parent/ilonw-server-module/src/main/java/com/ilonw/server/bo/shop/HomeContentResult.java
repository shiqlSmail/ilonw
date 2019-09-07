package com.ilonw.server.bo.shop;

import java.io.Serializable;
import java.util.List;

/**
 * 首页内容返回信息封装
 */
public class HomeContentResult implements Serializable {
    private static final long serialVersionUID = 1L;

    //轮播广告
    private List<SmsHomeAdvertise> advertiseList;
    //推荐品牌
    private List<Brand> brandList;
    //当前秒杀场次
    private HomeFlashPromotion homeFlashPromotion;
    //新品推荐
    private List<Product> newProductList;
    //人气推荐
    private List<Product> hotProductList;
    //推荐专题
    private List<CmsSubject> subjectList;

    public List<SmsHomeAdvertise> getAdvertiseList() {
        return advertiseList;
    }

    public void setAdvertiseList(List<SmsHomeAdvertise> advertiseList) {
        this.advertiseList = advertiseList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public HomeFlashPromotion getHomeFlashPromotion() {
        return homeFlashPromotion;
    }

    public void setHomeFlashPromotion(HomeFlashPromotion homeFlashPromotion) {
        this.homeFlashPromotion = homeFlashPromotion;
    }

    public List<Product> getNewProductList() {
        return newProductList;
    }

    public void setNewProductList(List<Product> newProductList) {
        this.newProductList = newProductList;
    }

    public List<Product> getHotProductList() {
        return hotProductList;
    }

    public void setHotProductList(List<Product> hotProductList) {
        this.hotProductList = hotProductList;
    }

    public List<CmsSubject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<CmsSubject> subjectList) {
        this.subjectList = subjectList;
    }
}
