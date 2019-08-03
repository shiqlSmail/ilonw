package com.ilonw.server;

import com.ilonw.server.bo.SysEmailCodeBO;
import com.ilonw.server.bo.SysEmailUrlBO;
import com.ilonw.server.bo.SysSmsBO;

import java.util.List;

public interface SysSmsFacade {
    /**
     * 保存验证码信息
     * @param record
     * @return
     */
    boolean saveSms(SysSmsBO record);

    /**
     * 根据手机号码查看验证码信息
     * @param record
     * @return
     */
    List<SysSmsBO> findSmsByPhone(SysSmsBO record);

    /**
     * 更新验证码信息
     * @return
     */
    Integer updateSms();

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
