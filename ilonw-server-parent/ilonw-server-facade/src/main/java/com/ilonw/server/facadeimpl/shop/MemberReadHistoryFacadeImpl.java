package com.ilonw.server.facadeimpl.shop;


import com.ilonw.server.biz.shop.MemberReadHistoryService;
import com.ilonw.server.bo.shop.MemberReadHistory;
import com.ilonw.server.facade.shop.MemberReadHistoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员浏览记录管理Service
 */
@Service("memberReadHistoryFacade")
public class MemberReadHistoryFacadeImpl implements MemberReadHistoryFacade {
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        return memberReadHistoryService.create(memberReadHistory);
    }

    @Override
    public int delete(List<String> ids) {
        return memberReadHistoryService.delete(ids);
    }

    @Override
    public List<MemberReadHistory> list(String memberId) {
        return memberReadHistoryService.list(memberId);
    }
}
