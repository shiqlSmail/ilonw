package com.ilonw.manager.dao.mapper;


import com.ilonw.manager.domain.SysDeptBO;

import java.util.List;

public interface SysDeptDao {

    List<SysDeptBO> selectAll();

    SysDeptBO selectByPrimaryKey(Integer deptId);

    int deleteByPrimaryKey(Integer deptId);

    int insertSelective(SysDeptBO record);

    int updateByPrimaryKeySelective(SysDeptBO record);
}