package com.ilonw.server.logServer;

import com.ilonw.server.biz.sys.SysIlonwLogsService;
import com.ilonw.server.bo.sys.SysIlonwLogsEntity;
import com.server.tools.util.IpUtils;
import com.server.tools.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class LogServiceResponse {
    protected final Logger log = LoggerFactory.getLogger(LogServiceResponse.class);

    @Autowired
    SysIlonwLogsService sysIlonwLogsService;

    //保存日志
    public void saveLogs(HttpServletRequest requestIp, Object param, String request, Object result, String status, long times, String type){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SysIlonwLogsEntity record = new SysIlonwLogsEntity();
        record.setLogAuthor("ilonw_shiql");
        record.setLogCreatetime(sdf.format(new Date()));
        record.setLogId(UUIDUtil.primaryKeyUUID());
        record.setLogIp(IpUtils.getIpAddr(requestIp));
        record.setLogParam(param.toString());
        record.setLogRequest(request);
        record.setLogResult(result.toString());
        record.setLogStatus(status);
        record.setLogTimes(times+"ms");
        record.setLogType(type);
        Boolean saveStatus = sysIlonwLogsService.insertLogsByRequest(record);
        if(saveStatus){
            log.info("日志【" + request+"】保存成功");
        }else{
            log.info("日志【" + request+"】保存失败" );
        }
    }
}
