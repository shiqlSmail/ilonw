package com.ilonw.server.facadeimpl.shop;


import com.ilonw.server.biz.shop.MemberCollectionService;
import com.ilonw.server.bo.shop.MemberProductCollection;
import com.ilonw.server.facade.shop.MemberCollectionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员收藏Service
 */
@Service("memberCollectionFacade")
public class MemberCollectionFacadeImpl implements MemberCollectionFacade {
    @Autowired
    private MemberCollectionService memberCollectionService;

    @Override
    public int addProduct(MemberProductCollection productCollection) {
        return memberCollectionService.addProduct(productCollection);
    }

    @Override
    public int deleteProduct(String memberId, Long productId) {
        return memberCollectionService.deleteProduct(memberId,productId);
    }

    @Override
    public List<MemberProductCollection> listProduct(String memberId) {
        return memberCollectionService.listProduct(memberId);
    }
}
