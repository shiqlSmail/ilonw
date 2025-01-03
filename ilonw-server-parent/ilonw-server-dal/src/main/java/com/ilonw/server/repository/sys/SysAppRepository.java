package com.ilonw.server.repository.sys;

import com.ilonw.server.bo.sys.SysAppBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysAppRepository {

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
