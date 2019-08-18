package com.ilonw.manager.dao.mapper;

import com.ilonw.manager.domain.SysMenuBO;

import java.util.List;

public interface SysMenuDao {
    List<SysMenuBO> selectSysMenu();
}