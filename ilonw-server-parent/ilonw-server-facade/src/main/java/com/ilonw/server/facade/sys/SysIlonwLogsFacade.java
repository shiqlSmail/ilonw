package com.ilonw.server.facade.sys;

import com.ilonw.server.bo.sys.SysIlonwLogsEntity;

public interface SysIlonwLogsFacade {
    public boolean insertLogsByRequest(SysIlonwLogsEntity record);
}
