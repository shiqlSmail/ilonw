package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.CmsPrefrenceAreaProductRelation;
import com.ilonw.server.bo.shop.CmsPrefrenceAreaProductRelationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CmsPrefrenceAreaProductRelationMapper {
    long countByExample(CmsPrefrenceAreaProductRelationExample example);

    int deleteByExample(CmsPrefrenceAreaProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsPrefrenceAreaProductRelation record);

    int insertSelective(CmsPrefrenceAreaProductRelation record);

    List<CmsPrefrenceAreaProductRelation> selectByExample(CmsPrefrenceAreaProductRelationExample example);

    CmsPrefrenceAreaProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsPrefrenceAreaProductRelation record, @Param("example") CmsPrefrenceAreaProductRelationExample example);

    int updateByExample(@Param("record") CmsPrefrenceAreaProductRelation record, @Param("example") CmsPrefrenceAreaProductRelationExample example);

    int updateByPrimaryKeySelective(CmsPrefrenceAreaProductRelation record);

    int updateByPrimaryKey(CmsPrefrenceAreaProductRelation record);
}