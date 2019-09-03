package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductAttributeValue;
import com.ilonw.server.bo.shop.ProductAttributeValueExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductAttributeValueMapper {
    long countByExample(ProductAttributeValueExample example);

    int deleteByExample(ProductAttributeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductAttributeValue record);

    int insertSelective(ProductAttributeValue record);

    List<ProductAttributeValue> selectByExample(ProductAttributeValueExample example);

    ProductAttributeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductAttributeValue record, @Param("example") ProductAttributeValueExample example);

    int updateByExample(@Param("record") ProductAttributeValue record, @Param("example") ProductAttributeValueExample example);

    int updateByPrimaryKeySelective(ProductAttributeValue record);

    int updateByPrimaryKey(ProductAttributeValue record);
}