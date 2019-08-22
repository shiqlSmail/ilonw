package com.ilonw.manager.serviceimpl;

import com.ilonw.manager.dao.mapper.SysDeptDao;
import com.ilonw.manager.domain.SysDeptBO;
import com.ilonw.manager.service.SysDeptService;
import com.server.tools.date.DateUtil;
import com.server.tools.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("sysDeptService")
public class SysDeptServiceImpl implements SysDeptService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysDeptDao sysDeptDao;

    @Override
    public List<SysDeptBO> selectAll() {
        return sysDeptDao.selectAll();
    }

    @Override
    public SysDeptBO selectByPrimaryKey(Integer deptId) {
        return sysDeptDao.selectByPrimaryKey(deptId);
    }

    @Override
    public int deleteByPrimaryKey(Integer deptId) {
        return sysDeptDao.deleteByPrimaryKey(deptId);
    }

    @Override
    public int insertSelective(SysDeptBO record) {
        record.setDeptCreatetime(DateUtil.getDateTime(new Date()));
        record.setDeptUpdatetime(DateUtil.getDateTime(new Date()));
        return sysDeptDao.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDeptBO record) {
        record.setDeptUpdatetime(DateUtil.getDateTime(new Date()));
        return sysDeptDao.updateByPrimaryKeySelective(record);
    }
}
