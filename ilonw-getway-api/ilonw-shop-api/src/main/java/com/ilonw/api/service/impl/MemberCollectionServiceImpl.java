package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.MemberCollectionService;
import com.ilonw.server.bo.shop.MemberProductCollection;
import com.ilonw.server.facade.shop.MemberCollectionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 会员收藏Service实现类
 */
@Service("memberCollectionService")
public class MemberCollectionServiceImpl extends BaseService implements MemberCollectionService {
    @Autowired(required=false)
    private MemberCollectionFacade memberCollectionFacade;

    @Override
    public Map<String, Object> addProduct(MemberProductCollection productCollection) {
        int count =  memberCollectionFacade.addProduct(productCollection);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object>  deleteProduct(String memberId, Long productId) {
        int count =  memberCollectionFacade.deleteProduct(memberId, productId);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object>  listProduct(String memberId) {
        List<MemberProductCollection> productList = memberCollectionFacade.listProduct(memberId);
        if (null == productList || productList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productList);
        }
    }
}
