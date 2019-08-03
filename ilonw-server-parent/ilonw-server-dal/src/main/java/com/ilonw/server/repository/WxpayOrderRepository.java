package com.ilonw.server.repository;

import com.ilonw.server.bo.WxpayOrderBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WxpayOrderRepository {

    /**
     * 保存微信订单信息
     * @param wxpayOrderBO
     * @return
     */
    int insertSelective(WxpayOrderBO wxpayOrderBO);

    /**
     * 更新微信订单信息
     * @param wxpayOrderBO
     * @return
     */
    int updateByPrimaryKeySelective(WxpayOrderBO wxpayOrderBO);

    /**
     * 查看微信订单信息
     * @param wxpayOrderBO
     * @return
     */
    WxpayOrderBO selectByExample(WxpayOrderBO wxpayOrderBO);
}
