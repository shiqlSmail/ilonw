package com.ilonw.server;

import com.ilonw.server.bo.SysIlonwLogsEntity;
import org.springframework.stereotype.Service;

@Service
public interface SysIlonwLogsService {
    /**
     * 保存日志信息
     * @param record
     * @return
     */
    public boolean insertLogsByRequest(SysIlonwLogsEntity record);
}
