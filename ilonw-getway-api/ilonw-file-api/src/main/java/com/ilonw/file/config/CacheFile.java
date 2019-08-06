package com.ilonw.file.config;

import com.server.tools.cache.Cache;

/**
 * 文件上传缓存类
 */
public class CacheFile {
    public static void setCacheIdentification(String userKey,String value){
        //设置10秒过期时间，如果10秒内没有执行完，也会清除缓存
        Cache.put(userKey,value,1000*10);
    }

    public static Object getCacheIdentification(String userKey){
        //设置10秒过期时间，如果10秒内没有执行完，也会清除缓存
        return Cache.get(userKey);
    }
}
