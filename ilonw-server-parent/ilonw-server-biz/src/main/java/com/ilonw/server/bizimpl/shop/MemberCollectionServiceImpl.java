package com.ilonw.server.bizimpl.shop;

import com.ilonw.server.biz.shop.MemberCollectionService;
import com.ilonw.server.bo.shop.MemberProductCollection;
import com.ilonw.server.repository.shop.MemberProductCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员收藏Service实现类
 */
@Service("memberCollectionService")
public class MemberCollectionServiceImpl implements MemberCollectionService {
    @Autowired
    private MemberProductCollectionRepository memberProductCollectionRepository;

    @Override
    public int addProduct(MemberProductCollection productCollection) {
        int count = 0;
        MemberProductCollection findCollection = memberProductCollectionRepository.findByMemberIdAndProductId(productCollection.getMemberId(), productCollection.getProductId());
        if (findCollection == null) {
            memberProductCollectionRepository.save(productCollection);
            count = 1;
        }
        return count;
    }

    @Override
    public int deleteProduct(String memberId, Long productId) {
        return memberProductCollectionRepository.deleteByMemberIdAndProductId(memberId, productId);
    }

    @Override
    public List<MemberProductCollection> listProduct(String memberId) {
        return memberProductCollectionRepository.findByMemberId(memberId);
    }
}
