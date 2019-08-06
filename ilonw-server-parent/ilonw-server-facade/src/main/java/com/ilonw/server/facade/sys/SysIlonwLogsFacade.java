package com.ilonw.server.facade.sys;

import com.ilonw.server.bo.SysIlonwLogsEntity;

public interface SysIlonwLogsFacade {
    public boolean insertLogsByRequest(SysIlonwLogsEntity record);
}
