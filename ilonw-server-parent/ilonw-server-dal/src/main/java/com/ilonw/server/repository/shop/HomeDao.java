package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.CmsSubject;
import com.ilonw.server.bo.shop.FlashPromotionProduct;
import com.ilonw.server.bo.shop.Brand;
import com.ilonw.server.bo.shop.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 首页内容管理自定义Dao
 */
@Mapper
@Repository
public interface HomeDao {

    /**
     * 获取推荐品牌
     */
    List<Brand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     */
    List<Product> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);
    /**
     * 获取人气推荐
     */
    List<Product> getHotProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取推荐专题
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
