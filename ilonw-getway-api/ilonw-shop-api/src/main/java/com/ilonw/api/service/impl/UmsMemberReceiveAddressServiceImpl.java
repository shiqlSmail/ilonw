package com.ilonw.api.service.impl;


import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.UmsMemberReceiveAddressService;
import com.ilonw.server.bo.shop.UmsMemberReceiveAddress;
import com.ilonw.server.facade.shop.UmsMemberReceiveAddressFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户地址管理Service
 */
@Service("umsMemberReceiveAddressService")
public class UmsMemberReceiveAddressServiceImpl  extends BaseService implements UmsMemberReceiveAddressService {
    @Resource
    private UmsMemberReceiveAddressFacade umsMemberReceiveAddressFacade;

    @Override
    public Map<String, Object> add(UmsMemberReceiveAddress address) {
        int count =  umsMemberReceiveAddressFacade.add(address);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> delete(Long id) {
        int count =  umsMemberReceiveAddressFacade.delete(id);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> update(Long id, UmsMemberReceiveAddress address) {
        int count =  umsMemberReceiveAddressFacade.update(id,address);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> list() {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList =  umsMemberReceiveAddressFacade.list();
        if (null == umsMemberReceiveAddressList || umsMemberReceiveAddressList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(umsMemberReceiveAddressList);
        }
    }

    @Override
    public Map<String, Object> getItem(Long id) {
        UmsMemberReceiveAddress umsMemberReceiveAddress =  umsMemberReceiveAddressFacade.getItem(id);
        if (null == umsMemberReceiveAddress) {
            return getFailMap();
        } else {
            return getSuccessMapObject(umsMemberReceiveAddress);
        }
    }
}
