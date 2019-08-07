package com.ilonw.server.biz.sys;

import com.ilonw.server.bo.SysAppBO;
import org.springframework.stereotype.Service;

@Service
public interface SysSysAppService {
    /**
     * 根据渠道名字查询，判断信息是否存在
     * @param record
     * @return
     */
    Integer querySysAppByAppChannelName(SysAppBO record);

    /**
     * 根据appid和appkey获取渠道信息
     * @param record
     * @return
     */
    String querySysApp(SysAppBO record);

    /**
     * 保存客户的appid和appkey信息
     * @param record
     * @return
     */
    boolean saveSysApp(SysAppBO record);
}
