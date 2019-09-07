package com.ilonw.api.service;


import com.ilonw.server.bo.shop.UmsMemberReceiveAddress;

import java.util.List;
import java.util.Map;

/**
 * 用户地址管理Service
 */
public interface UmsMemberReceiveAddressService {
    /**
     * 添加收货地址
     */
    Map<String, Object> add(UmsMemberReceiveAddress address);

    /**
     * 删除收货地址
     * @param id 地址表的id
     */
    Map<String, Object> delete(Long id);

    /**
     * 修改收货地址
     * @param id 地址表的id
     * @param address 修改的收货地址信息
     */
    Map<String, Object> update(Long id, UmsMemberReceiveAddress address);

    /**
     * 返回当前用户的收货地址
     */
    Map<String, Object> list();

    /**
     * 获取地址详情
     * @param id 地址id
     */
    Map<String, Object> getItem(Long id);
}
