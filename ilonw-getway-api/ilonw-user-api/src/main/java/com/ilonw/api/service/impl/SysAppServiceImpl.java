package com.ilonw.api.service.impl;

import com.ilonw.api.service.SysAppService;
import com.ilonw.api.vo.SysAppParam;
import com.ilonw.api.vo.SysAppResponse;
import com.ilonw.server.bo.SysAppBO;
import com.ilonw.server.facade.sys.SysSysAppFacade;
import com.server.tools.date.DateUtil;
import com.server.tools.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SysAppServiceImpl implements SysAppService {

    @Resource
    public SysSysAppFacade sysSysAppFacade;

    @Override
    public SysAppResponse sign(SysAppParam record) {
        SysAppBO sysAppBO = new SysAppBO();
        sysAppBO.setAppChannel(UUIDUtil.primaryKeyUUID());
        sysAppBO.setAppCreatetime(DateUtil.getDateTime(new Date()));
        sysAppBO.setAppStatus(1);
        sysAppBO.setIlonwUserId(record.getAppUserId());
        sysAppBO.setAppChannelName(record.getAppChannelName());

        //开始生成appid和appkey
        RSAGenerator rsaGenerator = new RSAGenerator().generateKeyPair();
        String appId = UUIDUtil.userCode(9);
        //加密采用私钥加密  顺序不可变
        String appKey = rsaGenerator.encryptByPrivate(appId+record.getAppChannelName()+record.getAppUserId());
        sysAppBO.setAppId(Integer.parseInt(appId));
        sysAppBO.setAppKey(appKey);

        //根据渠道名字查询，判断信息是否存在
        SysAppResponse res = new SysAppResponse();
        Integer count = sysSysAppFacade.querySysAppByAppChannelName(sysAppBO);
        if(count == 0){
            sysSysAppFacade.saveSysApp(sysAppBO);
            //将加密过后的appid和appkay返回给客户
            res.setApp_id(Integer.parseInt(appId));
            res.setApp_key(appKey);
        }else{
            res.setApp_id(000000);
            res.setApp_key("该客户已经注册过，不能城府注册。");
        }
        return res;
    }

    /**
     * 根据appid和appkey获取渠道信息
     * @param record
     * @return
     */
    @Override
    public Map<String,Object> getAppInfo(SysAppResponse record) {
        SysAppBO sysAppBO = new SysAppBO();
        sysAppBO.setAppId(record.getApp_id());
        sysAppBO.setAppKey(record.getApp_key());
        String appChannel = sysSysAppFacade.querySysApp(sysAppBO);

        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isEmpty(appChannel)){
            map.put("data", "您还未获取appid和appkey信息");
        }else{
            map.put("data", appChannel);
        }
        return map;
    }
}
