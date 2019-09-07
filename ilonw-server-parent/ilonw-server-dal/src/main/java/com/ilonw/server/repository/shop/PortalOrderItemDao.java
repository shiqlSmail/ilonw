package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.OmsOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单商品信息自定义Dao
 */
@Mapper
@Repository
public interface PortalOrderItemDao {
    int insertList(@Param("list") List<OmsOrderItem> list);
}
