package com.ilonw.server.bizimpl.sys;

import com.ilonw.server.biz.sys.SysIlonwLogsService;
import com.ilonw.server.bo.sys.SysIlonwLogsEntity;
import com.ilonw.server.repository.sys.SysIlonwLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysIlonwLogsServiceImpl implements SysIlonwLogsService {

    @Autowired
    private SysIlonwLogsRepository sysIlonwLogsRepository;

    /**
     * 保存日志信息
     * @param record
     * @return
     */
    @Override
    public boolean insertLogsByRequest(SysIlonwLogsEntity record){
        return sysIlonwLogsRepository.insertLogsByRequest(record);
    }
}
