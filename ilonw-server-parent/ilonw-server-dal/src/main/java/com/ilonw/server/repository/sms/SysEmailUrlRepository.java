package com.ilonw.server.repository.sms;

import com.ilonw.server.bo.SysEmailUrlBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysEmailUrlRepository {

    /**
     * 保存邮件发送的URL信息
     * @param record
     * @return
     */
    boolean saveEmailUrl(SysEmailUrlBO record);

    /**
     * 根据邮箱账号查询URL信息
     * @param record
     * @return
     */
    List<SysEmailUrlBO> findEmailByEmailUrl(SysEmailUrlBO record);
}
