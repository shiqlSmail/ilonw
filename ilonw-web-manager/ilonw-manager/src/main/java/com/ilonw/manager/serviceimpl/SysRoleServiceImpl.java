package com.ilonw.manager.serviceimpl;

import com.ilonw.manager.dao.mapper.SysMenuDao;
import com.ilonw.manager.dao.mapper.SysRoleDao;
import com.ilonw.manager.domain.SysMenuBO;
import com.ilonw.manager.domain.SysRoleBO;
import com.ilonw.manager.service.SysMenuService;
import com.ilonw.manager.service.SysRoleService;
import com.server.tools.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return sysRoleDao.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insertSelective(SysRoleBO record) {
        record.setRoleCreatetime(DateUtil.getDateTime(new Date()));
        record.setRoleUpdatetime(DateUtil.getDateTime(new Date()));
        return sysRoleDao.insertSelective(record);
    }

    @Override
    public SysRoleBO selectByPrimaryKey(Integer roleId) {
        return sysRoleDao.selectByPrimaryKey(roleId);
    }

    @Override
    public List<SysRoleBO> selectAll() {
        return sysRoleDao.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleBO record) {
        record.setRoleUpdatetime(DateUtil.getDateTime(new Date()));
        return sysRoleDao.updateByPrimaryKeySelective(record);
    }
}
