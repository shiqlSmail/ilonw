package com.ilonw.server.impl;

import com.ilonw.server.SysSmsService;
import com.ilonw.server.bo.SysEmailCodeBO;
import com.ilonw.server.bo.SysEmailUrlBO;
import com.ilonw.server.bo.SysSmsBO;
import com.ilonw.server.repository.SysEmailCodeRepository;
import com.ilonw.server.repository.SysEmailUrlRepository;
import com.ilonw.server.repository.SysSmsRepository;
import com.server.tools.date.DateUtil;
import com.server.tools.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("sysSmsService")
public class SysSmsServiceImpl implements SysSmsService{

    @Autowired
    private SysSmsRepository sysSmsRepository;

    @Autowired
    private SysEmailCodeRepository sysEmailCodeRepository;

    @Autowired
    private SysEmailUrlRepository sysEmailUrlRepository;

    /**
     * 保存验证码信息
     * @param record
     * @return
     */
    @Override
    public boolean saveSms(SysSmsBO record) {
        record.setSmsCreatetime(DateUtil.getDateTime(new Date()));
        record.setSmsId(UUIDUtil.primaryKeyUUID());
        record.setSmsStatus(1);
        return sysSmsRepository.saveSms(record);
    }

    /**
     * 根据手机号码查看验证码信息
     * @param record
     * @return
     */
    @Override
    public List<SysSmsBO> findSmsByPhone(SysSmsBO record) {
        return sysSmsRepository.findSmsByPhone(record);
    }


    /**
     * 保存邮件验证码信息
     * @param record
     * @return
     */
    @Override
    public boolean saveEmailCode(SysEmailCodeBO record) {
        record.setEmailCreatetime(DateUtil.getDateTime(new Date()));
        record.setEmailId(UUIDUtil.primaryKeyUUID());
        record.setEmailStatus(1);
        return sysEmailCodeRepository.saveEmailCode(record);
    }

    /**
     * 根据邮箱账号查询验证码信息
     * @param record
     * @return
     */
    @Override
    public List<SysEmailCodeBO> findEmailCodeByEmailName(SysEmailCodeBO record) {
        return sysEmailCodeRepository.findEmailCodeByEmailName(record);
    }

    /**
     * 保存邮件发送的URL信息
     * @param record
     * @return
     */
    @Override
    public boolean saveEmailUrl(SysEmailUrlBO record) {
        record.setEmailCreatetime(DateUtil.getDateTime(new Date()));
        record.setEmailId(UUIDUtil.primaryKeyUUID());
        record.setEmailStatus(1);
        return sysEmailUrlRepository.saveEmailUrl(record);
    }

    /**
     * 根据邮箱账号查询URL信息
     * @param record
     * @return
     */
    @Override
    public List<SysEmailUrlBO> findEmailByEmailUrl(SysEmailUrlBO record) {
        return sysEmailUrlRepository.findEmailByEmailUrl(record);
    }

    /**
     * 更新验证码信息
     * @return
     */
    @Override
    public Integer updateSms() {
        return sysSmsRepository.updateSms();
    }

    /**
     * 更新邮箱验证码信息
     * @return
     */
    @Override
    public Integer updateEmailCode() {
        return sysEmailCodeRepository.updateEmailCode();
    }
}
