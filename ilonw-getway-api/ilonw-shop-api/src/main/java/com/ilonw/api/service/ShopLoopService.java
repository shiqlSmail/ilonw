package com.ilonw.api.service;

import com.ilonw.api.vo.ShopLoopAddParam;
import com.ilonw.api.vo.ShopLoopEditParam;
import com.ilonw.server.bo.shop.ShopLoopBO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
     * @param shopLoopAddParam
     * @return
     */
    Map<String,Object> saveLoopShop(ShopLoopAddParam shopLoopAddParam);

    /**
     * 后台修改轮播图信息
     * @param shopLoopEditParam
     * @return
     */
    Map<String,Object> updateLoopShop( ShopLoopEditParam shopLoopEditParam) ;

    /**
     * 删除
     * @param shopLoopEditParam
     * @return
     */
    Map<String, Object> deleteLoop(ShopLoopEditParam shopLoopEditParam);
}
