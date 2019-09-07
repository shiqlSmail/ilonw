package com.ilonw.api.service;


import com.ilonw.server.bo.shop.MemberProductCollection;

import java.util.List;
import java.util.Map;

/**
 * 会员收藏Service
 */
public interface MemberCollectionService {
    Map<String, Object> addProduct(MemberProductCollection productCollection);

    Map<String, Object> deleteProduct(String memberId, Long productId);

    Map<String, Object> listProduct(String memberId);
}
