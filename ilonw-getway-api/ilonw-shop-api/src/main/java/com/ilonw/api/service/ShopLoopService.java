package com.ilonw.api.service;

import com.ilonw.api.vo.ShopLoopAddParam;
import com.ilonw.api.vo.ShopLoopEditParam;

import java.util.Map;

public interface ShopLoopService {
    /**
     * 首页显示商品轮播信息
     * @return
     */
    Map<String,Object> findLoopShop();

    /**
     * 后台管理显示商品轮播信息
     * @return
     */
    Map<String,Object> findAllLoopShop();

    /**
     * 新增首页轮播商品
     * @param param
     * @return
     */
    Map<String,Object> saveLoopShop(ShopLoopAddParam param);

    /**
     * 后台修改轮播图信息
     * @param param
     * @return
     */
    Map<String,Object> updateLoopShop(ShopLoopEditParam param);
}
