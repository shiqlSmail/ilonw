package com.ilonw.server.facadeimpl.sys;

import com.ilonw.server.facade.sys.SysIlonwLogsFacade;
import com.ilonw.server.biz.sys.SysIlonwLogsService;
import com.ilonw.server.bo.SysIlonwLogsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysIlonwLogsFacade")
public class SysIlonwLogsFacadeImpl implements SysIlonwLogsFacade {

    @Autowired
    private SysIlonwLogsService sysIlonwLogsService;

    public boolean insertLogsByRequest(SysIlonwLogsEntity record){
        return sysIlonwLogsService.insertLogsByRequest(record);
    }
}
