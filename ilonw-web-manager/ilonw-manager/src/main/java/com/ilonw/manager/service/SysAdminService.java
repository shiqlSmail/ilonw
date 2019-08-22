package com.ilonw.manager.service;

import com.ilonw.manager.domain.SysAdminBO;
import com.ilonw.manager.domain.SysLoginBO;
import com.ilonw.manager.vo.SysAdminRequest;

import java.util.List;
import java.util.Map;

public interface SysAdminService {
    Map<String ,Object> login(SysAdminRequest record);

    int deleteByPrimaryKey(Integer adminId);

    int insertSelective(SysAdminBO record);

    SysAdminBO selectByPrimaryKey(Integer adminId);

    List<SysAdminBO> selectAll();

    List<SysLoginBO> selectAllLoginInfo(String loginCode);

    int updateByPrimaryKeySelective(SysAdminBO record);
}