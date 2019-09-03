package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.SkuStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义商品sku库存Dao
 */

@Mapper
@Repository
public interface SkuStockDao {
    /**
     * 批量插入操作
     */
    int insertList(@Param("list") List<SkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(@Param("list") List<SkuStock> skuStockList);
}
