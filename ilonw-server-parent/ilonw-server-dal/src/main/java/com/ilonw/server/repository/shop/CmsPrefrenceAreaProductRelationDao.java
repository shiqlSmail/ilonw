package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义优选和商品关系操作
 */
@Mapper
@Repository
public interface CmsPrefrenceAreaProductRelationDao {
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
