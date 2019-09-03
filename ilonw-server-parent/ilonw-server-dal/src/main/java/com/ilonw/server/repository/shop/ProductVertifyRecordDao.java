package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductVertifyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品审核日志自定义dao
 */

@Mapper
@Repository
public interface ProductVertifyRecordDao {
    int insertList(@Param("list") List<ProductVertifyRecord> list);
}
