package com.ilonw.api.service;


import com.ilonw.server.bo.shop.MemberReadHistory;

import java.util.List;
import java.util.Map;

/**
 * 会员浏览记录管理Service
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     */
    Map<String, Object> create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    Map<String, Object> delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    Map<String, Object> list(String memberId);
}
