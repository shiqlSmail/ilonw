package com.ilonw.server.bizimpl.sms;

import com.ilonw.server.biz.sms.SysSmsService;
import com.ilonw.server.bo.sms.SysEmailCodeBO;
import com.ilonw.server.bo.sms.SysEmailUrlBO;
import com.ilonw.server.bo.sms.SysSmsBO;
import com.ilonw.server.repository.sms.SysEmailCodeRepository;
import com.ilonw.server.repository.sms.SysEmailUrlRepository;
import com.ilonw.server.repository.sms.SysSmsRepository;
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
        String uuid = UUIDUtil.primaryKeyUUID();
        record.setSmsCreatetime(DateUtil.getDateTime(new Date()));
        record.setSmsId(uuid);
        record.setSmsStatus(1);
        boolean flag = sysSmsRepository.saveSms(record);
        if(flag){
            record.setSmsId(uuid);
            sysSmsRepository.updateSmsByPhone(record);
        }else{
            return false;
        }
        return true;
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
        String uuid = UUIDUtil.primaryKeyUUID();
        record.setEmailCreatetime(DateUtil.getDateTime(new Date()));
        record.setEmailId(uuid);
        record.setEmailStatus(1);
        boolean flag = sysEmailCodeRepository.saveEmailCode(record);
        if(flag){
            record.setEmailId(uuid);
            sysEmailCodeRepository.updateEmailCodeByEmailName(record);
        }else{
            return false;
        }
        return true;
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
