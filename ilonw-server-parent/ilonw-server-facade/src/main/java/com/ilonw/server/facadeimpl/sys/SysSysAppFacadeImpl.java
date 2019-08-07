package com.ilonw.server.facadeimpl.sys;

import com.ilonw.server.biz.sys.SysSysAppService;
import com.ilonw.server.bo.SysAppBO;
import com.ilonw.server.facade.sys.SysSysAppFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysSysAppFacade")
public class SysSysAppFacadeImpl implements SysSysAppFacade {

    @Autowired
    private SysSysAppService sysSysAppService;

    /**
     * 根据渠道名字查询，判断信息是否存在
     * @param record
     * @return
     */
    @Override
    public Integer querySysAppByAppChannelName(SysAppBO record){
        return sysSysAppService.querySysAppByAppChannelName(record);
    }

    /**
     * 根据appid和appkey获取渠道信息
     * @param record
     * @return
     */
    @Override
    public String querySysApp(SysAppBO record){
        return sysSysAppService.querySysApp(record);
    }

    /**
     * 保存客户的appid和appkey信息
     * @param record
     * @return
     */
    @Override
    public boolean saveSysApp(SysAppBO record){
        return sysSysAppService.saveSysApp(record);
    }
}
