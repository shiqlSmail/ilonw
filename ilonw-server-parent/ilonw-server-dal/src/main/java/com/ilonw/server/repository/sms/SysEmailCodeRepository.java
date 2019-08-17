package com.ilonw.server.repository.sms;

import com.ilonw.server.bo.sms.SysEmailCodeBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysEmailCodeRepository {

    /**
     * 保存邮件验证码信息
     * @param record
     * @return
     */
    boolean saveEmailCode(SysEmailCodeBO record);

    /**
     * 根据邮箱账号查询验证码信息
     * @param record
     * @return
     */
    List<SysEmailCodeBO> findEmailCodeByEmailName(SysEmailCodeBO record);

    /**
     * 更新邮箱验证码信息
     * @return
     */
    Integer updateEmailCode();

    /**
     * 根据邮箱账号更新验证码信息
     * @param record
     * @return
     */
    boolean updateEmailCodeByEmailName(SysEmailCodeBO record);
}
