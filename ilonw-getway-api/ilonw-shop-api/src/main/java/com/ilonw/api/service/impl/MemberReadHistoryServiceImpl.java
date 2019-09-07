package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.MemberReadHistoryService;
import com.ilonw.server.bo.shop.MemberReadHistory;
import com.ilonw.server.facade.shop.MemberReadHistoryFacade;
import com.ilonw.server.repository.shop.MemberReadHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 会员浏览记录管理Service实现类
 */
@Service("memberReadHistoryService")
public class MemberReadHistoryServiceImpl extends BaseService implements MemberReadHistoryService {
    @Autowired(required=false)
    private MemberReadHistoryFacade memberReadHistoryFacade;
    @Override
    public  Map<String, Object> create(MemberReadHistory memberReadHistory) {
        int count =  memberReadHistoryFacade.create(memberReadHistory);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public  Map<String, Object> delete(List<String> ids) {
        int count =  memberReadHistoryFacade.delete(ids);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> list(String memberId) {
        List<MemberReadHistory>  memberReadHistoryList =  memberReadHistoryFacade.list(memberId);
        if (null == memberReadHistoryList || memberReadHistoryList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(memberReadHistoryList);
        }
    }
}
