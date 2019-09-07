package com.ilonw.server.facadeimpl.shop;


import com.ilonw.server.biz.shop.UmsMemberReceiveAddressService;
import com.ilonw.server.bo.shop.UmsMemberReceiveAddress;
import com.ilonw.server.facade.shop.UmsMemberReceiveAddressFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户地址管理Service
 */
@Service("umsMemberReceiveAddressFacade")
public class UmsMemberReceiveAddressFacadeImpl implements UmsMemberReceiveAddressFacade {
    @Autowired
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    @Override
    public int add(UmsMemberReceiveAddress address) {
        return umsMemberReceiveAddressService.add(address);
    }

    @Override
    public int delete(Long id) {
        return umsMemberReceiveAddressService.delete(id);
    }

    @Override
    public int update(Long id, UmsMemberReceiveAddress address) {
        return umsMemberReceiveAddressService.update(id,address);
    }

    @Override
    public List<UmsMemberReceiveAddress> list() {
        return umsMemberReceiveAddressService.list();
    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id) {
        return umsMemberReceiveAddressService.getItem(id);
    }
}
