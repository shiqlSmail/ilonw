package com.ilonw.server.bizimpl.shop;

import com.ilonw.server.biz.shop.UmsMemberReceiveAddressService;
import com.ilonw.server.bo.shop.UmsMemberReceiveAddress;
import com.ilonw.server.bo.shop.UmsMemberReceiveAddressExample;
import com.ilonw.server.bto.IlonwUserBTO;
import com.ilonw.server.repository.shop.UmsMemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户地址管理Service实现类
 */
@Service("umsMemberReceiveAddressService")
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;
    @Override
    public int add(UmsMemberReceiveAddress address) {
        //UmsMember currentMember = memberService.getCurrentMember();
        //todo
        IlonwUserBTO ilonwUserBTO = null;
        address.setMemberId(ilonwUserBTO.getIlonwUserId());
        return addressMapper.insert(address);
    }

    @Override
    public int delete(Long id) {
        //UmsMember currentMember = memberService.getCurrentMember();
        //todo
        IlonwUserBTO ilonwUserBTO = null;
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(ilonwUserBTO.getIlonwUserId()).andIdEqualTo(id);
        return addressMapper.deleteByExample(example);
    }

    @Override
    public int update(Long id, UmsMemberReceiveAddress address) {
        address.setId(null);
        //UmsMember currentMember = memberService.getCurrentMember();
        //todo
        IlonwUserBTO ilonwUserBTO = null;
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(ilonwUserBTO.getIlonwUserId()).andIdEqualTo(id);
        return addressMapper.updateByExampleSelective(address,example);
    }

    @Override
    public List<UmsMemberReceiveAddress> list() {
        //UmsMember currentMember = memberService.getCurrentMember();
        //todo
        IlonwUserBTO ilonwUserBTO = null;
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(ilonwUserBTO.getIlonwUserId());
        return addressMapper.selectByExample(example);
    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id) {
        //UmsMember currentMember = memberService.getCurrentMember();
        //todo
        IlonwUserBTO ilonwUserBTO = null;
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(ilonwUserBTO.getIlonwUserId()).andIdEqualTo(id);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(addressList)){
            return addressList.get(0);
        }
        return null;
    }
}
