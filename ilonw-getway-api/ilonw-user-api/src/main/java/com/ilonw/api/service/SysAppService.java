package com.ilonw.api.service;

import com.ilonw.api.vo.SysAppParam;
import com.ilonw.api.vo.SysAppResponse;
import com.ilonw.api.vo.SysAppSignResponse;

import java.util.Map;

public interface SysAppService {

    /**
     * 保存app信息
     * @param record
     * @return
     */
    SysAppSignResponse sign(SysAppParam record) throws Exception;

    public Map<String,Object> getAppInfo(SysAppResponse record);
}
