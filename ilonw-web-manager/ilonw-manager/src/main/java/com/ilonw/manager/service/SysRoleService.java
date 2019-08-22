package com.ilonw.manager.service;


import com.ilonw.manager.domain.SysRoleBO;

import java.util.List;

public interface SysRoleService {
    int deleteByPrimaryKey(Integer roleId);

    int insertSelective(SysRoleBO record);

    SysRoleBO selectByPrimaryKey(Integer roleId);

    List<SysRoleBO> selectAll();

    int updateByPrimaryKeySelective(SysRoleBO record);

}