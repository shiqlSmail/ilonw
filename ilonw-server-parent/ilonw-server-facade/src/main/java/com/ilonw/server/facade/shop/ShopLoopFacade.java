package com.ilonw.server.facade.shop;

import com.ilonw.server.bo.shop.ShopLoopBO;

import java.util.List;

public interface ShopLoopFacade {

    /**
     * 首页显示商品轮播信息
     * @return
     */
    List<ShopLoopBO> findLoopShop();

    /**
     * 后台管理显示商品轮播信息
     * @return
     */
    List<ShopLoopBO> findAllLoopShop();

    /**
     * 新增首页轮播商品
     * @param BO
     * @return
     */
    boolean saveLoopShop(ShopLoopBO BO);

    /**
     * 后台修改轮播图信息
     * @param BO
     * @return
     */
    boolean updateLoopShop(ShopLoopBO BO);
}
