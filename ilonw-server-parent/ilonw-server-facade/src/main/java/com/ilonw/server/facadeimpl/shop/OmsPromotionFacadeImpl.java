package com.ilonw.server.facadeimpl.shop;

import com.ilonw.server.biz.shop.OmsPromotionService;
import com.ilonw.server.bo.shop.OmsCartItem;
import com.ilonw.server.bo.shop.ProductFullReduction;
import com.ilonw.server.bo.shop.ProductLadder;
import com.ilonw.server.bo.shop.SkuStock;
import com.ilonw.server.bto.shop.CartPromotionItem;
import com.ilonw.server.bto.shop.PromotionProduct;
import com.ilonw.server.facade.shop.OmsPromotionFacade;
import com.ilonw.server.repository.shop.PortalProductDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 促销管理Service实现类
 */
@Service("omsPromotionFacade")
public class OmsPromotionFacadeImpl implements OmsPromotionFacade {
    @Autowired
    private OmsPromotionService omsPromotionService;

    @Override
    public List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList) {
        return omsPromotionService.calcCartPromotion(cartItemList);
    }
}
