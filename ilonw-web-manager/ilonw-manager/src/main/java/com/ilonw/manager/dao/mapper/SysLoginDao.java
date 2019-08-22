package com.ilonw.manager.dao.mapper;


import com.ilonw.manager.domain.SysLoginBO;

import java.util.List;

public interface SysLoginDao {
    int insertSelective(SysLoginBO record);

    List<SysLoginBO> selectAll(SysLoginBO record);
}