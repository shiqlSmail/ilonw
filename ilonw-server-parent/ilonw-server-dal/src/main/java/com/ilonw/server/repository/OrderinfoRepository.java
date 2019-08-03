package com.ilonw.server.repository;

import com.ilonw.server.bo.OrderinfoBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderinfoRepository {
    /**
     * 保存订单信息
     * @param orderinfoBO
     * @return
     */
    int insertSelective(OrderinfoBO orderinfoBO);

    /**
     * 更新订单信息
     * @param orderinfoBO
     * @return
     */
    int updateByPrimaryKeySelective(OrderinfoBO orderinfoBO);

    /**
     * 查看订单信息
     * @param orderId
     * @return
     */
    OrderinfoBO selectByPrimaryKey(String orderId);
}
