package com.ilonw.server;

import com.ilonw.server.bo.SysIlonwLogsEntity;

public interface SysIlonwLogsFacade {
    public boolean insertLogsByRequest(SysIlonwLogsEntity record);
}
