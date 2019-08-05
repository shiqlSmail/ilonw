package com.ilonw.api.config;

import com.ilonw.api.vo.LoginParam;

/**
 * 登录用户校验，用户配死，不入数据库
 */
public class LoginUserConfig {

    public static boolean isLoginUserFlag(LoginParam loginParam){
        if(loginParam.getUsername().equals(UserProperties.ADMIN.getUsername()) || loginParam.getPassword().equals(UserProperties.ADMIN.getPassword()) || "1".equals(UserProperties.ADMIN.getStatus())){
            return true;
        }else if(loginParam.getUsername().equals(UserProperties.SHIQILONG.getUsername()) || loginParam.getPassword().equals(UserProperties.SHIQILONG.getPassword()) || "1".equals(UserProperties.SHIQILONG.getStatus())){
            return true;
        }else{
            return false;
        }
    }
}
