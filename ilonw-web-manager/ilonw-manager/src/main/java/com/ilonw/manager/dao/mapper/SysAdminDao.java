package com.ilonw.manager.dao.mapper;

import com.ilonw.manager.domain.SysAdminBO;
import com.ilonw.manager.vo.SysAdminRequest;

import java.util.List;

public interface SysAdminDao {
    SysAdminBO login(SysAdminRequest record);

    int deleteByPrimaryKey(Integer adminId);

    int insertSelective(SysAdminBO record);

    SysAdminBO selectByPrimaryKey(Integer adminId);

    List<SysAdminBO> selectAll();

    int updateByPrimaryKeySelective(SysAdminBO record);
}