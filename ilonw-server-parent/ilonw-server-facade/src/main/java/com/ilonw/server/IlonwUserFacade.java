package com.ilonw.server;

import com.ilonw.server.bto.IlonwUserBTO;
import com.ilonw.server.page.PageBean;
import com.ilonw.server.page.PageData;

import java.util.Map;

public interface IlonwUserFacade {

    public PageBean<IlonwUserBTO> findAllIlonwUserInfo(PageData pageData);

    public Map<String,Object> loginIlonwUserByPhoneAndEmailAndCode(IlonwUserBTO record);

    //用户登录  根据手机号验证码
    public Map<String,Object> loginIlonwUserByPhone(IlonwUserBTO record,String ip);

    //检查注册手机号码是否存在
    public Map<String,Object> checkIlonwUserByPhoneExits(IlonwUserBTO param);

    //检查注册邮箱是否存在
    public Map<String,Object> checkIlonwUserByEmailExits(IlonwUserBTO param);

    //用户注册
    public boolean saveIlonwUserInfo(IlonwUserBTO param);

    //忘记密码，根据手机号码进行修改
    public Map<String,Object> updateIlonwUserPassword(IlonwUserBTO param);

}
