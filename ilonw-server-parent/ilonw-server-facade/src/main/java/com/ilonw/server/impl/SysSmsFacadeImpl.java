package com.ilonw.server.impl;

import com.ilonw.server.SysSmsFacade;
import com.ilonw.server.SysSmsService;
import com.ilonw.server.bo.SysEmailCodeBO;
import com.ilonw.server.bo.SysEmailUrlBO;
import com.ilonw.server.bo.SysSmsBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysSmsFacade")
public class SysSmsFacadeImpl implements SysSmsFacade {

    @Autowired
    private SysSmsService sysSmsService;

    @Override
    public boolean saveSms(SysSmsBO record) {
        return sysSmsService.saveSms(record);
    }

    @Override
    public List<SysSmsBO> findSmsByPhone(SysSmsBO record) {
        return sysSmsService.findSmsByPhone(record);
    }

    @Override
    public boolean saveEmailCode(SysEmailCodeBO record) {
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
