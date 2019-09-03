package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductLadder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义会员阶梯价格Dao
 */

@Mapper
@Repository
public interface ProductLadderDao {
    int insertList(@Param("list") List<ProductLadder> productLadderList);
}
