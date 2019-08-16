package com.ilonw.api.service.impl;

import com.ilonw.api.service.SysAppService;
import com.ilonw.api.vo.SysAppParam;
import com.ilonw.api.vo.SysAppResponse;
import com.ilonw.api.vo.SysAppSignResponse;
import com.ilonw.server.bo.SysAppBO;
import com.ilonw.server.facade.sys.SysSysAppFacade;
import com.server.tools.date.DateUtil;
import com.server.tools.encryption.RSAUtil;
import com.server.tools.util.UUIDUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SysAppServiceImpl implements SysAppService {

    @Resource
    public SysSysAppFacade sysSysAppFacade;

    @Override
    public SysAppSignResponse sign(SysAppParam record) throws Exception {
        SysAppBO sysAppBO = new SysAppBO();
        sysAppBO.setAppChannel(UUIDUtil.primaryKeyUUID());
        sysAppBO.setAppCreatetime(DateUtil.getDateTime(new Date()));
        sysAppBO.setAppStatus(1);
        sysAppBO.setIlonwUserId(record.getAppUserId());
        sysAppBO.setAppChannelName(record.getAppChannelName());

        //开始生成appid和appkey
        RSAUtil rsa = new RSAUtil();
        String appId = UUIDUtil.userCode(9);
        //加密采用私钥加密  顺序不可变
        KeyPair keyPair = rsa.getKeyPair();
        String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
        String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
        //要加密的数据
        String appKey = rsa.encrypt(appId+record.getAppChannelName()+record.getAppUserId(), rsa.getPublicKey(publicKey));

        //把数据放到数据库
        sysAppBO.setAppId(Integer.parseInt(appId));
        sysAppBO.setAppKey(appKey);
        sysAppBO.setAppPrivatekey(privateKey);
        sysAppBO.setAppPublicKey(publicKey);

        //根据渠道名字查询，判断信息是否存在
        SysAppSignResponse res = new SysAppSignResponse();
        Integer count = sysSysAppFacade.querySysAppByAppChannelName(sysAppBO);
        if(count == 0){
            sysSysAppFacade.saveSysApp(sysAppBO);
            res.setMessage("返回信息属隐私信息，请妥善保管，不要泄露给他人，如有泄露，请重新生成！");
            //将加密过后的appid和appkay返回给客户
            res.setApp_id(Integer.parseInt(appId));
            res.setApp_key(appKey);
            res.setApp_private_key(privateKey);
            res.setApp_public_key(publicKey);
        }else{
            res.setMessage("该客户已经注册过，不能重复注册。");
            res.setApp_id(0);
            res.setApp_key("ilonw-oss");
            res.setApp_private_key("ilonw-oss");
            res.setApp_public_key("ilonw-oss");
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
        Map<String,Object> map = new HashMap<>();

        if(StringUtils.isEmpty(record.getApp_public_key())){
            map.put("data", "公钥未传");
        }
        if(StringUtils.isEmpty(record.getApp_private_key())){
            map.put("data", "私钥未传");
        }

        SysAppBO sysAppBO = new SysAppBO();
        sysAppBO.setAppId(record.getApp_id());
        sysAppBO.setAppKey(record.getApp_key());
        sysAppBO.setAppPublicKey(record.getApp_public_key());
        sysAppBO.setAppPrivatekey(record.getApp_private_key());
        String appChannel = sysSysAppFacade.querySysApp(sysAppBO);


        if(StringUtils.isEmpty(appChannel)){
            map.put("data", "您还未获取appid和appkey信息");
        }else{
            map.put("data", appChannel);
        }
        return map;
    }
}
