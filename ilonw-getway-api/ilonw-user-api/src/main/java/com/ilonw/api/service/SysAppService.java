package com.ilonw.api.service;

import com.ilonw.api.vo.SysAppParam;
import com.ilonw.api.vo.SysAppResponse;

import java.util.Map;

public interface SysAppService {

    /**
     * 保存app信息
     * @param record
     * @return
     */
    SysAppResponse sign(SysAppParam record);

    public Map<String,Object> getAppInfo(SysAppResponse record);
}
