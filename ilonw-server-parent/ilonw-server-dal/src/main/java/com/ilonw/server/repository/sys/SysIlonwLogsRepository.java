package com.ilonw.server.repository.sys;

import com.ilonw.server.bo.sys.SysIlonwLogsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysIlonwLogsRepository {

    /**
     * 保存日志信息
     * @param record
     * @return
     */
    boolean insertLogsByRequest(SysIlonwLogsEntity record);
}
