package com.ilonw.api.service.impl;


import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.OmsPromotionService;
import com.ilonw.server.bo.shop.OmsCartItem;
import com.ilonw.server.bto.shop.CartPromotionItem;
import com.ilonw.server.facade.shop.OmsPromotionFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 促销管理Service
 */
@Service("omsPromotionService")
public class OmsPromotionServiceImpl extends BaseService implements OmsPromotionService {
    @Resource
    private OmsPromotionFacade omsPromotionFacade;


    @Override
    public Map<String, Object> calcCartPromotion(List<OmsCartItem> cartItemList) {
        List<CartPromotionItem> cartPromotionItemList = omsPromotionFacade.calcCartPromotion(cartItemList);
        if (null == cartPromotionItemList || cartPromotionItemList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(cartPromotionItemList);
        }
    }
}
