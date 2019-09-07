package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.UmsMemberCouponService;
import com.ilonw.server.bo.shop.SmsCouponHistory;
import com.ilonw.server.bo.shop.SmsCouponHistoryDetail;
import com.ilonw.server.bto.shop.CartPromotionItem;
import com.ilonw.server.facade.shop.UmsMemberCouponFacade;
import com.server.tools.result.CommonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户优惠券管理Service
 */
@Service("umsMemberCouponService")
public class UmsMemberCouponServiceImpl extends BaseService implements UmsMemberCouponService {
    @Resource
    private UmsMemberCouponFacade umsMemberCouponFacade;

    @Override
    public CommonResult add(Long couponId) {
        return umsMemberCouponFacade.add(couponId);
    }

    @Override
    public Map<String, Object> list(Integer useStatus) {
        List<SmsCouponHistory> smsCouponHistoryList =  umsMemberCouponFacade.list(useStatus);
        if (null == smsCouponHistoryList || smsCouponHistoryList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(smsCouponHistoryList);
        }
    }

    @Override
    public Map<String, Object> listCart(List<CartPromotionItem> cartItemList, Integer type) {
        List<SmsCouponHistoryDetail> smsCouponHistoryDetails = umsMemberCouponFacade.listCart(cartItemList,type);
        if (null == smsCouponHistoryDetails || smsCouponHistoryDetails.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(smsCouponHistoryDetails);
        }
    }
}
