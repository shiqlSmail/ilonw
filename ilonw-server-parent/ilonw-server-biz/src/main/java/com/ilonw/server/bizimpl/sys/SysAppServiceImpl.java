package com.ilonw.server.bizimpl.sys;

import com.ilonw.server.biz.sys.SysSysAppService;
import com.ilonw.server.bo.sys.SysAppBO;
import com.ilonw.server.repository.sys.SysAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysAppServiceImpl implements SysSysAppService {

    @Autowired
    private SysAppRepository sysAppRepository;


    /**
     * 根据渠道名字查询，判断信息是否存在
     * @param record
     * @return
     */
    @Override
    public Integer querySysAppByAppChannelName(SysAppBO record){
        return sysAppRepository.querySysAppByAppChannelName(record);
    }

    /**
     * 根据appid和appkey获取渠道信息
     * @param record
     * @return
     */
    @Override
    public String querySysApp(SysAppBO record){
        return sysAppRepository.querySysApp(record);
    }

    /**
     * 保存客户的appid和appkey信息
     * @param record
     * @return
     */
    @Override
    public boolean saveSysApp(SysAppBO record){
        return sysAppRepository.saveSysApp(record);
    }
}
