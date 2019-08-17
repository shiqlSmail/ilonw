package com.ilonw.server.facade.sys;

import com.ilonw.server.bo.sys.SysAppBO;

public interface SysSysAppFacade {
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
