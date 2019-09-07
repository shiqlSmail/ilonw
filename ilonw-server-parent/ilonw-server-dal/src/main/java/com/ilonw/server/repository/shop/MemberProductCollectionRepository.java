package com.ilonw.server.repository.shop;


import com.ilonw.server.bo.shop.MemberProductCollection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品收藏Repository
 */
public interface MemberProductCollectionRepository extends MongoRepository<MemberProductCollection,String> {
    MemberProductCollection findByMemberIdAndProductId(String memberId, Long productId);
    int deleteByMemberIdAndProductId(String memberId, Long productId);
    List<MemberProductCollection> findByMemberId(String memberId);
}
