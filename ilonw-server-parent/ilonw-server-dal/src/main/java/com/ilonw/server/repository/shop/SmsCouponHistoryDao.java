package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.SmsCouponHistoryDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员优惠券领取历史自定义Dao
 */
@Mapper
@Repository
public interface SmsCouponHistoryDao {
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") String memberId);
}
