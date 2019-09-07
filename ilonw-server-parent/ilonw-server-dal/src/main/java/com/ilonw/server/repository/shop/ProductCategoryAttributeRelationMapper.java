package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductCategoryAttributeRelation;
import com.ilonw.server.bto.shop.ProductCategoryAttributeRelationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductCategoryAttributeRelationMapper {
    long countByExample(ProductCategoryAttributeRelationExample example);

    int deleteByExample(ProductCategoryAttributeRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductCategoryAttributeRelation record);

    int insertSelective(ProductCategoryAttributeRelation record);

    List<ProductCategoryAttributeRelation> selectByExample(ProductCategoryAttributeRelationExample example);

    ProductCategoryAttributeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductCategoryAttributeRelation record, @Param("example") ProductCategoryAttributeRelationExample example);

    int updateByExample(@Param("record") ProductCategoryAttributeRelation record, @Param("example") ProductCategoryAttributeRelationExample example);

    int updateByPrimaryKeySelective(ProductCategoryAttributeRelation record);

    int updateByPrimaryKey(ProductCategoryAttributeRelation record);
}