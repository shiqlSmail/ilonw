package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义商品分类和属性关系Dao
 */
@Mapper
@Repository
public interface ProductCategoryAttributeRelationDao {
    int insertList(@Param("list") List<ProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
