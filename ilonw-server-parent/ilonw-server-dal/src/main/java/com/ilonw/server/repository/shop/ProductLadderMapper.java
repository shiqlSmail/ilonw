package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductLadder;
import com.ilonw.server.bo.shop.ProductLadderExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductLadderMapper {
    long countByExample(ProductLadderExample example);

    int deleteByExample(ProductLadderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductLadder record);

    int insertSelective(ProductLadder record);

    List<ProductLadder> selectByExample(ProductLadderExample example);

    ProductLadder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductLadder record, @Param("example") ProductLadderExample example);

    int updateByExample(@Param("record") ProductLadder record, @Param("example") ProductLadderExample example);

    int updateByPrimaryKeySelective(ProductLadder record);

    int updateByPrimaryKey(ProductLadder record);
}