package com.ilonw.server.biz.shop;


import com.ilonw.server.bo.shop.MemberProductCollection;

import java.util.List;

/**
 * 会员收藏Service
 */
public interface MemberCollectionService {
    int addProduct(MemberProductCollection productCollection);

    int deleteProduct(String memberId, Long productId);

    List<MemberProductCollection> listProduct(String memberId);
}
