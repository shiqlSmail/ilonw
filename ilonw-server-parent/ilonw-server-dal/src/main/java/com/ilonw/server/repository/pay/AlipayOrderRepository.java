package com.ilonw.server.repository.pay;


import com.ilonw.server.bo.AlipayOrderBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AlipayOrderRepository {

    /**
     * 保存支付宝订单信息
     * @param alipayOrderBO
     * @return
     */
    int insertSelective(AlipayOrderBO alipayOrderBO);

    /**
     * 更新支付宝订单信息
     * @param alipayOrderBO
     * @return
     */
    int updateByPrimaryKeySelective(AlipayOrderBO alipayOrderBO);


    /**
     * 根据订单号查询支付宝订单信息
     * @param alipayOrderBO
     * @return
     */
    AlipayOrderBO selectByExample(AlipayOrderBO alipayOrderBO);
}