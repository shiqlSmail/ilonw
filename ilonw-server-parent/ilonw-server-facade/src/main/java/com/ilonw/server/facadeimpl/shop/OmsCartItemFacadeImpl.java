package com.ilonw.server.facadeimpl.shop;

import com.ilonw.server.biz.shop.OmsCartItemService;
import com.ilonw.server.bo.shop.OmsCartItem;
import com.ilonw.server.bto.shop.CartProduct;
import com.ilonw.server.bto.shop.CartPromotionItem;
import com.ilonw.server.facade.shop.OmsCartItemFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车管理Service实现类
 */
@Service("omsCartItemFacade")
public class OmsCartItemFacadeImpl implements OmsCartItemFacade {
    @Autowired
    private OmsCartItemService omsCartItemService;

    @Override
    public int add(OmsCartItem cartItem) {
        return omsCartItemService.add(cartItem);
    }

    @Override
    public List<OmsCartItem> list(String memberId) {
        return omsCartItemService.list(memberId);
    }

    @Override
    public List<CartPromotionItem> listPromotion(String memberId) {
        return omsCartItemService.listPromotion(memberId);
    }

    @Override
    public int updateQuantity(Long id, String memberId, Integer quantity) {
        return omsCartItemService.updateQuantity(id,memberId,quantity);
    }

    @Override
    public int delete(String memberId, List<Long> ids) {
        return omsCartItemService.delete(memberId,ids);
    }

    @Override
    public CartProduct getCartProduct(Long productId) {
        return omsCartItemService.getCartProduct(productId);
    }

    @Override
    public int updateAttr(OmsCartItem cartItem) {
        return omsCartItemService.updateAttr(cartItem);
    }

    @Override
    public int clear(String memberId) {
        return omsCartItemService.clear(memberId);
    }
}
