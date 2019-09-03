package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义商品和专题关系操作
 * Created by macro on 2018/4/26.
 */
@Mapper
@Repository
public interface CmsSubjectProductRelationDao {
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
