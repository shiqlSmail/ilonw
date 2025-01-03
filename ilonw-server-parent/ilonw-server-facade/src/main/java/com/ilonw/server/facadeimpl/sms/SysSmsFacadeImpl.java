package com.ilonw.server.facadeimpl.sms;

import com.ilonw.server.facade.sms.SysSmsFacade;
import com.ilonw.server.biz.sms.SysSmsService;
import com.ilonw.server.bo.sms.SysEmailCodeBO;
import com.ilonw.server.bo.sms.SysEmailUrlBO;
import com.ilonw.server.bo.sms.SysSmsBO;
import com.server.tools.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysSmsFacade")
public class SysSmsFacadeImpl implements SysSmsFacade {

    @Autowired
    private SysSmsService sysSmsService;

    @Override
    public boolean saveSms(SysSmsBO record) {
        Cache.put(record.getSmsPhone(), record.getSmsCode(), 60000);
        return sysSmsService.saveSms(record);
    }

    @Override
    public List<SysSmsBO> findSmsByPhone(SysSmsBO record) {
        return sysSmsService.findSmsByPhone(record);
    }

    @Override
    public boolean saveEmailCode(SysEmailCodeBO record) {
        Cache.put(record.getEmailName(), record.getEmailCode(), 60000*5);
        return sysSmsService.saveEmailCode(record);
    }

    @Override
    public List<SysEmailCodeBO> findEmailCodeByEmailName(SysEmailCodeBO record) {
        return sysSmsService.findEmailCodeByEmailName(record);
    }

    @Override
    public boolean saveEmailUrl(SysEmailUrlBO record) {
        return sysSmsService.saveEmailUrl(record);
    }

    @Override
    public List<SysEmailUrlBO> findEmailByEmailUrl(SysEmailUrlBO record) {
        return sysSmsService.findEmailByEmailUrl(record);
    }

    @Override
    public Integer updateSms() {
        return sysSmsService.updateSms();
    }

    @Override
    public Integer updateEmailCode() {
        return sysSmsService.updateEmailCode();
    }
}
