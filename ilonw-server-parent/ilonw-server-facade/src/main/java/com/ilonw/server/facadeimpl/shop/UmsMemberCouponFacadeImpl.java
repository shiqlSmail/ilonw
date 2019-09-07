package com.ilonw.server.facadeimpl.shop;

import com.ilonw.server.biz.shop.UmsMemberCouponService;
import com.ilonw.server.bo.shop.SmsCouponHistory;
import com.ilonw.server.bo.shop.SmsCouponHistoryDetail;
import com.ilonw.server.bto.shop.CartPromotionItem;
import com.ilonw.server.facade.shop.UmsMemberCouponFacade;
import com.server.tools.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户优惠券管理Service
 */
@Service("umsMemberCouponFacade")
public class UmsMemberCouponFacadeImpl implements UmsMemberCouponFacade {

    @Autowired
    private UmsMemberCouponService umsMemberCouponService;

    @Override
    public CommonResult add(Long couponId) {
        return umsMemberCouponService.add(couponId);
    }

    @Override
    public List<SmsCouponHistory> list(Integer useStatus) {
        return umsMemberCouponService.list(useStatus);
    }

    @Override
    public List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type) {
        return umsMemberCouponService.listCart(cartItemList,type);
    }
}
