package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.enums.ShopLoopStatusEunms;
import com.ilonw.api.service.ShopLoopService;
import com.ilonw.api.vo.request.ShopLoopAddParam;
import com.ilonw.api.vo.response.ShopLoopAdminResponse;
import com.ilonw.api.vo.request.ShopLoopEditParam;
import com.ilonw.api.vo.response.ShopLoopUserResponse;
import com.ilonw.api.vo.convert.ShopLoopConvert;
import com.ilonw.server.bo.shop.ShopLoopBO;
import com.ilonw.server.facade.shop.ShopLoopFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopLoopServiceImpl extends BaseService implements ShopLoopService {
    @Resource
    private ShopLoopFacade shopLoopFacade;

    /**
     * 首页显示商品轮播信息
     *
     * @return
     */
    public Map<String, Object> findLoopShop() {
        Map<String, Object> map = new HashMap<String, Object>();

        List<ShopLoopBO> listBO = shopLoopFacade.findLoopShop();
        map = getSuccessMap();
        if (null == listBO || listBO.size() == 0) {
            map.put("data", "暂无数据");
        } else {
            List<ShopLoopUserResponse> listShopLoopUserResponse = new ArrayList<>();
            for (ShopLoopBO shopLoopBO : listBO) {
                listShopLoopUserResponse.add(ShopLoopConvert.convertUser(shopLoopBO));
            }
            map.put("data", listShopLoopUserResponse);
        }
        return map;
    }

    /**
     * 后台管理显示商品轮播信息
     *
     * @return
     */
    public Map<String, Object> findAllLoopShop() {
        Map<String, Object> map = new HashMap<String, Object>();

        List<ShopLoopBO> listBO = shopLoopFacade.findAllLoopShop();
        map = getSuccessMap();
        if (null == listBO || listBO.size() == 0) {
            map.put("data", "暂无数据");
        } else {
            List<ShopLoopAdminResponse> listShopLoopAdminResponse = new ArrayList<>();
            for (ShopLoopBO shopLoopBO : listBO) {
                listShopLoopAdminResponse.add(ShopLoopConvert.convertAdmin(shopLoopBO));
            }
            map.put("data", listShopLoopAdminResponse);
        }
        return map;
    }

    /**
     * 新增首页轮播商品
     *
     * @param shopLoopAddParam
     * @return
     */
    public Map<String, Object> saveLoopShop(ShopLoopAddParam shopLoopAddParam){
        shopLoopAddParam.setLoopStatus(ShopLoopStatusEunms.NORMAL.getResCode());
        boolean flag = shopLoopFacade.saveLoopShop(ShopLoopConvert.convertSave(shopLoopAddParam));
        if (flag) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }


    /**
     * 后台修改轮播图信息
     *
     * @param shopLoopEditParam
     * @return
     */
    public Map<String, Object> updateLoopShop(ShopLoopEditParam shopLoopEditParam) {
        boolean flag = shopLoopFacade.updateLoopShop(ShopLoopConvert.convertUpdate(shopLoopEditParam));
        if (flag) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> deleteLoop(ShopLoopEditParam shopLoopEditParam) {
        boolean flag = shopLoopFacade.deleteLoop(ShopLoopConvert.convertUpdate(shopLoopEditParam));
        if (flag) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }
}
