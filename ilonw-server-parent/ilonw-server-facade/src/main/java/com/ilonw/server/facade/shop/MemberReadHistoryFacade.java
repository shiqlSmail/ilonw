package com.ilonw.server.facade.shop;


import com.ilonw.server.bo.shop.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览记录管理Service
 */
public interface MemberReadHistoryFacade {
    /**
     * 生成浏览记录
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    List<MemberReadHistory> list(String memberId);
}
