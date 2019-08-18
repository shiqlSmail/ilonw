package com.ilonw.api.manager.system;

import com.ilonw.api.manager.config.SystemConfig;
import com.server.tools.encryption.DESUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 接口bean，用于统一接口调用
 */
public class InterfaceBean {

    protected static final Logger log = LoggerFactory.getLogger(InterfaceBean.class);

    /**
     * 发送post请求
     * @param url
     * @param map
     * @return
     */
    public static String toSendPost(String url,Map<String,String> map){
        HttpRespons  httpRespons = new HttpRespons();
        try {
            HttpRequester request = new HttpRequester();

            //获取url，需解密
            String desUrl = SystemConfig.getProperties(url);
            log.info("获取加密的url信息："+desUrl+",解密过后的url："+DESUtil.decipherVal(desUrl));

            String[] strUrls = desUrl.split(";");
            System.out.println(strUrls[1]);

            if("0".equals(strUrls[1]) || "0" == strUrls[1]){
                httpRespons = request.sendPost(DESUtil.decipherVal(desUrl),map);
            }else{
                return "接口已停用";
            }
            log.info("post返回结果为："+httpRespons.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpRespons.getContent();
    }
}