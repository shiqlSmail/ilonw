package com.ilonw.manager.serviceimpl;

import com.ilonw.manager.dao.mapper.SysMenuDao;
import com.ilonw.manager.domain.SysMenuBO;
import com.ilonw.manager.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenuBO> selectSysMenu() {
        return sysMenuDao.selectSysMenu();
    }
}
