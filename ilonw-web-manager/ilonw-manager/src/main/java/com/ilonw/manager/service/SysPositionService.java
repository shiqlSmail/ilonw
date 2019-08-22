package com.ilonw.manager.service;


import com.ilonw.manager.domain.SysPositionBO;

import java.util.List;

public interface SysPositionService {
    int deleteByPrimaryKey(Integer positionId);

    int insertSelective(SysPositionBO record);

    SysPositionBO selectByPrimaryKey(Integer positionId);

    List<SysPositionBO> selectAll();

    int updateByPrimaryKeySelective(SysPositionBO record);
}