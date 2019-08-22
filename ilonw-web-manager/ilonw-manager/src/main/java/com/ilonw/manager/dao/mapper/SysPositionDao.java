package com.ilonw.manager.dao.mapper;


import com.ilonw.manager.domain.SysPositionBO;

import java.util.List;

public interface SysPositionDao {
    int deleteByPrimaryKey(Integer positionId);

    int insertSelective(SysPositionBO record);

    SysPositionBO selectByPrimaryKey(Integer positionId);

    List<SysPositionBO> selectAll();

    int updateByPrimaryKeySelective(SysPositionBO record);
}