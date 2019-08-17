package com.ilonw.api.vo.convert;

import com.ilonw.api.vo.ShopLoopAddParam;
import com.ilonw.api.vo.ShopLoopAdminResponse;
import com.ilonw.api.vo.ShopLoopEditParam;
import com.ilonw.api.vo.ShopLoopUserResponse;
import com.ilonw.server.bo.shop.ShopLoopBO;

public class ShopLoopConvert {

    public static ShopLoopAdminResponse convertAdmin(ShopLoopBO shopLoopBO){
        if(null == shopLoopBO){
            return null;
        }
        ShopLoopAdminResponse shopLoopAdminResponse = new ShopLoopAdminResponse();
        shopLoopAdminResponse.setLoopCreatetime(shopLoopBO.getLoopCreatetime());
        shopLoopAdminResponse.setLoopId(shopLoopBO.getLoopId());
        shopLoopAdminResponse.setLoopIndex(shopLoopBO.getLoopIndex());
        shopLoopAdminResponse.setLoopName(shopLoopBO.getLoopName());
        shopLoopAdminResponse.setLoopPic(shopLoopBO.getLoopPic());
        shopLoopAdminResponse.setLoopStatus(shopLoopBO.getLoopStatus());
        shopLoopAdminResponse.setLoopUpdatetime(shopLoopBO.getLoopUpdatetime());
        return shopLoopAdminResponse;
    }

    public static ShopLoopUserResponse convertUser(ShopLoopBO shopLoopBO){
        if(null == shopLoopBO){
            return null;
        }
        ShopLoopUserResponse shopLoopUserResponse = new ShopLoopUserResponse();
        shopLoopUserResponse.setLoopId(shopLoopBO.getLoopId());
        shopLoopUserResponse.setLoopIndex(shopLoopBO.getLoopIndex());
        shopLoopUserResponse.setLoopName(shopLoopBO.getLoopName());
        shopLoopUserResponse.setLoopPic(shopLoopBO.getLoopPic());
        return shopLoopUserResponse;
    }

    public static ShopLoopBO convertSave(ShopLoopAddParam shopLoopAddParam){
        if(null == shopLoopAddParam){
            return null;
        }
        ShopLoopBO shopLoopBO = new ShopLoopBO();
        shopLoopBO.setLoopIndex(shopLoopAddParam.getLoopIndex());
        shopLoopBO.setLoopName(shopLoopAddParam.getLoopName());
        shopLoopBO.setLoopPic(shopLoopAddParam.getLoopPic());
        shopLoopBO.setLoopStatus(shopLoopAddParam.getLoopStatus());
        return shopLoopBO;
    }

    public static ShopLoopBO convertUpdate(ShopLoopEditParam shopLoopEditParam){
        if(null == shopLoopEditParam){
            return null;
        }
        ShopLoopBO shopLoopBO = new ShopLoopBO();
        shopLoopBO.setLoopId(shopLoopEditParam.getLoopId());
        shopLoopBO.setLoopIndex(shopLoopEditParam.getLoopIndex());
        shopLoopBO.setLoopName(shopLoopEditParam.getLoopName());
        shopLoopBO.setLoopPic(shopLoopEditParam.getLoopPic());
        shopLoopBO.setLoopStatus(shopLoopEditParam.getLoopStatus());
        return shopLoopBO;
    }
}
