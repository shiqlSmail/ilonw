package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductFullReduction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义商品满减Dao
 */

@Mapper
@Repository
public interface ProductFullReductionDao {
    int insertList(@Param("list") List<ProductFullReduction> productFullReductionList);
}
