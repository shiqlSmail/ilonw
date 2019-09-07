package com.ilonw.server.repository.shop;

import com.ilonw.server.bto.shop.CartProduct;
import com.ilonw.server.bto.shop.PromotionProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 */

@Mapper
@Repository
public interface PortalProductDao {
    CartProduct getCartProduct(@Param("id") Long id);
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);
}
