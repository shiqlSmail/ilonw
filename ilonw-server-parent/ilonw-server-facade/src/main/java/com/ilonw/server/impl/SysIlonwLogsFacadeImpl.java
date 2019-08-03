package com.ilonw.server.impl;

import com.ilonw.server.SysIlonwLogsFacade;
import com.ilonw.server.SysIlonwLogsService;
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
