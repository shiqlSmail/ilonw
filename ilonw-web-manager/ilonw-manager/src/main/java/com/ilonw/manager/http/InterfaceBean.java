package com.ilonw.manager.http;

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
            httpRespons = request.sendPost(url,map);
            log.info("post返回结果为："+httpRespons.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpRespons.getContent();
    }

    /**
     * 发送get请求  无参
     * @param url
     * @return
     */
    public static String toSendGet(String url){
        HttpRespons  httpRespons = new HttpRespons();
        try {
            HttpRequester request = new HttpRequester();
            httpRespons = request.sendGet(url);
            log.info("GET返回结果为："+httpRespons.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpRespons.getContent();
    }

    /**
     * 发送get请求  有参
     * @param url
     * @return
     */
    public static String toSendGet(String url,Map<String,String> map){
        HttpRespons  httpRespons = new HttpRespons();
        try {
            HttpRequester request = new HttpRequester();
            httpRespons = request.sendGet(url,map);
            log.info("GET返回结果为："+httpRespons.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpRespons.getContent();
    }
}