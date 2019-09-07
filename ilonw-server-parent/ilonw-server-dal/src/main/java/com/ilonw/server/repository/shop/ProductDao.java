package com.ilonw.server.repository.shop;

import com.ilonw.server.bto.shop.ProductResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 商品自定义Dao
 */
@Mapper
@Repository
public interface ProductDao {
    /**
     * 获取商品编辑信息
     */
    ProductResult getUpdateInfo(@Param("id") Long id);
}
