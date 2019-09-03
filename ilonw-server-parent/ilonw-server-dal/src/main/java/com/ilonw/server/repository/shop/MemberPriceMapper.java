package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.MemberPrice;
import com.ilonw.server.bo.shop.MemberPriceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberPriceMapper {
    long countByExample(MemberPriceExample example);

    int deleteByExample(MemberPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberPrice record);

    int insertSelective(MemberPrice record);

    List<MemberPrice> selectByExample(MemberPriceExample example);

    MemberPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberPrice record, @Param("example") MemberPriceExample example);

    int updateByExample(@Param("record") MemberPrice record, @Param("example") MemberPriceExample example);

    int updateByPrimaryKeySelective(MemberPrice record);

    int updateByPrimaryKey(MemberPrice record);
}