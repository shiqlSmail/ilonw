package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.SkuStock;
import com.ilonw.server.bto.shop.SkuStockExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SkuStockMapper {
    long countByExample(SkuStockExample example);

    int deleteByExample(SkuStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkuStock record);

    int insertSelective(SkuStock record);

    List<SkuStock> selectByExample(SkuStockExample example);

    SkuStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkuStock record, @Param("example") SkuStockExample example);

    int updateByExample(@Param("record") SkuStock record, @Param("example") SkuStockExample example);

    int updateByPrimaryKeySelective(SkuStock record);

    int updateByPrimaryKey(SkuStock record);
}