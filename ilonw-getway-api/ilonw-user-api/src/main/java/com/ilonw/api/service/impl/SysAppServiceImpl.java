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
import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class SysAppServiceImpl
        implements SysAppService
{
    @Resource
    public SysSysAppFacade sysSysAppFacade;

    public SysAppSignResponse sign(SysAppParam record) throws Exception {
        SysAppBO sysAppBO = new SysAppBO();
        sysAppBO.setAppChannel(UUIDUtil.primaryKeyUUID());
        sysAppBO.setAppCreatetime(DateUtil.getDateTime(new Date()));
        sysAppBO.setAppStatus(Integer.valueOf(1));
        sysAppBO.setIlonwUserId(record.getAppUserId());
        sysAppBO.setAppChannelName(record.getAppChannelName());


        RSAUtil rsa = new RSAUtil();
        String appId = UUIDUtil.userCode(9);

        KeyPair keyPair = rsa.getKeyPair();
        String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
        String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));

        String appKey = rsa.encrypt(appId + record.getAppChannelName() + record.getAppUserId(), rsa.getPublicKey(publicKey));


        sysAppBO.setAppId(Integer.valueOf(Integer.parseInt(appId)));
        sysAppBO.setAppKey(appKey);
        sysAppBO.setAppPrivatekey(privateKey);
        sysAppBO.setAppPublicKey(publicKey);


        SysAppSignResponse res = new SysAppSignResponse();
        Integer count = this.sysSysAppFacade.querySysAppByAppChannelName(sysAppBO);
        if (count.intValue() == 0) {
            this.sysSysAppFacade.saveSysApp(sysAppBO);

            res.setMessage("返回信息属隐私信息，请妥善保管，不要泄露给他人；如有泄露，请重新生成！");

            res.setApp_id(Integer.valueOf(Integer.parseInt(appId)));
            res.setApp_key(appKey);
            res.setApp_private_key(privateKey);
            res.setApp_public_key(publicKey);
        } else {
            res.setMessage("该客户已注册过，不能重复注册！");
            res.setApp_id(Integer.valueOf(0));
            res.setApp_key("ilonw-oss");
            res.setApp_private_key("ilonw-oss");
            res.setApp_public_key("ilonw-oss");
        }
        return res;
    }







    public Map<String, Object> getAppInfo(SysAppResponse record) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (StringUtils.isEmpty(record.getApp_public_key())) {
            map.put("data", "公钥未传");
        }
        if (StringUtils.isEmpty(record.getApp_private_key())) {
            map.put("data", "私钥未传");
        }

        SysAppBO sysAppBO = new SysAppBO();
        sysAppBO.setAppId(record.getApp_id());
        sysAppBO.setAppKey(record.getApp_key());
        sysAppBO.setAppPublicKey(record.getApp_public_key());
        sysAppBO.setAppPrivatekey(record.getApp_private_key());
        String appChannel = this.sysSysAppFacade.querySysApp(sysAppBO);


        if (StringUtils.isEmpty(appChannel)) {
            map.put("data", "你还未获取appid和appkey信息");
        } else {
            map.put("data", appChannel);
        }
        return map;
    }
}
