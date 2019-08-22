package com.ilonw.manager.serviceimpl;

import com.ilonw.manager.dao.mapper.SysMenuDao;
import com.ilonw.manager.dao.mapper.SysPositionDao;
import com.ilonw.manager.domain.SysMenuBO;
import com.ilonw.manager.domain.SysPositionBO;
import com.ilonw.manager.service.SysMenuService;
import com.ilonw.manager.service.SysPositionService;
import com.server.tools.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("sysPositionService")
public class SysPositionServiceImpl implements SysPositionService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysPositionDao sysPositionDao;

    @Override
    public int deleteByPrimaryKey(Integer positionId) {
        return sysPositionDao.deleteByPrimaryKey(positionId);
    }

    @Override
    public int insertSelective(SysPositionBO record) {
        record.setPositionCreatetime(DateUtil.getDateTime(new Date()));
        record.setPositionUpdatetime(DateUtil.getDateTime(new Date()));
        return sysPositionDao.insertSelective(record);
    }

    @Override
    public SysPositionBO selectByPrimaryKey(Integer positionId) {
        return sysPositionDao.selectByPrimaryKey(positionId);
    }

    @Override
    public List<SysPositionBO> selectAll() {
        return sysPositionDao.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(SysPositionBO record) {
        record.setPositionUpdatetime(DateUtil.getDateTime(new Date()));
        return sysPositionDao.updateByPrimaryKeySelective(record);
    }
}
