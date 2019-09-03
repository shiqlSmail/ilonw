package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductAttributeValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品参数，商品自定义规格属性Dao
 */
@Mapper
@Repository
public interface ProductAttributeValueDao {
    int insertList(@Param("list") List<ProductAttributeValue> productAttributeValueList);
}
