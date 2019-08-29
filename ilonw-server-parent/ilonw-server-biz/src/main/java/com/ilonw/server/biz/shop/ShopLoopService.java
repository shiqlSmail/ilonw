package com.ilonw.server.biz.shop;

import com.ilonw.server.bo.shop.ShopLoopBO;

import java.util.List;

public interface ShopLoopService {

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

    /**
     * 删除
     * @param BO
     * @return
     */
    boolean deleteLoop(ShopLoopBO BO);
}
