package com.ilonw.server.scheduled;

import com.ilonw.server.SysSmsFacade;
import com.server.tools.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledServer {
    private Logger logger = LoggerFactory.getLogger(ScheduledServer.class);

    @Autowired
    private SysSmsFacade sysSmsFacade;

    /**
     * 定时更新短信验证码
     * 验证码一分钟后更新为已使用
     */
    @Scheduled(cron="0 */1 * * * ? ")   //每隔1分钟执行一次
    public void updateSmsCode() {
        Integer updateNumber = sysSmsFacade.updateSms();
        logger.info("【定时任务更新1分钟前的短信验证码】："+DateUtil.getDateTime(new Date())+"更新成功数据为："+updateNumber+"条！");
    }

    /**
     * 定时更新邮箱验证码
     * 验证码五分钟后更新为已使用
     */
    @Scheduled(cron="0 */5 * * * ? ")   //每隔5分钟执行一次
    public void updateEmailCode() {
        Integer updateNumber = sysSmsFacade.updateEmailCode();
        logger.info("【定时任务更新5分钟前的邮箱验证码】："+DateUtil.getDateTime(new Date())+"更新成功数据为："+updateNumber+"条！");
    }

}
