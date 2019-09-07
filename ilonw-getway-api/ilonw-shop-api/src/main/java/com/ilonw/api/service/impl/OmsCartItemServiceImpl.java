package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.OmsCartItemService;
import com.ilonw.server.bo.shop.OmsCartItem;
import com.ilonw.server.bto.shop.CartProduct;
import com.ilonw.server.bto.shop.CartPromotionItem;
import com.ilonw.server.facade.shop.OmsCartItemFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 购物车管理Service
 */
@Service("omsCartItemService")
public class OmsCartItemServiceImpl extends BaseService implements OmsCartItemService {
    @Resource
    private OmsCartItemFacade omsCartItemFacade;

    @Override
    public Map<String, Object> add(OmsCartItem cartItem) {
        int count =  omsCartItemFacade.add(cartItem);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> list(String memberId) {
        List<OmsCartItem> omsCartItemList = omsCartItemFacade.list(memberId);
        if (null == omsCartItemList || omsCartItemList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(omsCartItemList);
        }
    }

    @Override
    public Map<String, Object> listPromotion(String memberId) {
        List<CartPromotionItem> cartPromotionItemList = omsCartItemFacade.listPromotion(memberId);
        if (null == cartPromotionItemList || cartPromotionItemList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(cartPromotionItemList);
        }
    }

    @Override
    public Map<String, Object> updateQuantity(Long id, String memberId, Integer quantity) {
        int count = omsCartItemFacade.updateQuantity(id,memberId,quantity);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> delete(String memberId, List<Long> ids) {
        int count = omsCartItemFacade.delete(memberId,ids);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> getCartProduct(Long productId) {
        CartProduct cartProduct = omsCartItemFacade.getCartProduct(productId);
        if (null == cartProduct) {
            return getFailMap();
        } else {
            return getSuccessMapObject(cartProduct);
        }
    }

    @Override
    public Map<String, Object> updateAttr(OmsCartItem cartItem) {
        int count = omsCartItemFacade.updateAttr(cartItem);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> clear(String memberId) {
        int count = omsCartItemFacade.clear(memberId);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }
}
