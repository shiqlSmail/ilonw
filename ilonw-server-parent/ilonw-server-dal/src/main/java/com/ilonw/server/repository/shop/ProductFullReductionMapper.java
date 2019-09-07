package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductFullReduction;
import com.ilonw.server.bto.shop.ProductFullReductionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductFullReductionMapper {
    long countByExample(ProductFullReductionExample example);

    int deleteByExample(ProductFullReductionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductFullReduction record);

    int insertSelective(ProductFullReduction record);

    List<ProductFullReduction> selectByExample(ProductFullReductionExample example);

    ProductFullReduction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductFullReduction record, @Param("example") ProductFullReductionExample example);

    int updateByExample(@Param("record") ProductFullReduction record, @Param("example") ProductFullReductionExample example);

    int updateByPrimaryKeySelective(ProductFullReduction record);

    int updateByPrimaryKey(ProductFullReduction record);
}