package com.ilonw.manager.serviceimpl;

import com.ilonw.manager.dao.mapper.SysAdminDao;
import com.ilonw.manager.domain.SysAdminBO;
import com.ilonw.manager.service.SysAdminService;
import com.ilonw.manager.vo.SysAdminRequest;
import com.server.tools.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysAdminService")
public class SysAdminServiceImpl implements SysAdminService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysAdminDao sysAdminDao;

    @Override
    public Map<String ,Object> login(SysAdminRequest record){
        Map<String ,Object> map = new HashMap<>();
        SysAdminBO sysAdminBO = sysAdminDao.login(record);
        if(null == sysAdminBO){
            map.put("data","");
        }else{
            map.put("data",sysAdminBO);
        }
        return map;
    }

    @Override
    public int deleteByPrimaryKey(Integer adminId) {
        return sysAdminDao.deleteByPrimaryKey(adminId);
    }

    @Override
    public int insertSelective(SysAdminBO record) {
        record.setAdminCreatetime(DateUtil.getDateTime(new Date()));
        record.setAdminUpdatetime(DateUtil.getDateTime(new Date()));
        return sysAdminDao.insertSelective(record);
    }

    @Override
    public SysAdminBO selectByPrimaryKey(Integer adminId) {
        return sysAdminDao.selectByPrimaryKey(adminId);
    }

    @Override
    public List<SysAdminBO> selectAll() {
        return sysAdminDao.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(SysAdminBO record) {
        record.setAdminUpdatetime(DateUtil.getDateTime(new Date()));
        return sysAdminDao.updateByPrimaryKeySelective(record);
    }
}
