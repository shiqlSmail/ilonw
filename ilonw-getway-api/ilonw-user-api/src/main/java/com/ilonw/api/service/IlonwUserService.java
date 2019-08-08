package com.ilonw.api.service;

import com.ilonw.api.vo.IlonwLoginParam;
import com.ilonw.api.vo.SysIlonwSaveUserParam;
import com.ilonw.server.bto.IlonwUserBTO;
import com.ilonw.server.page.PageData;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface IlonwUserService {

    /**
     * 用户登录：可使用手机/邮箱/用户号进行登录
     * @param param
     * @return
     */
    public Map<String,Object> loginIlonwUserByPhoneAndEmailAndCode(IlonwLoginParam param,String ip);


    /**
     * 查询所有用户接口
     * @param pageData
     * @return
     */
    public Map<String,Object> queryAllUser(@RequestBody PageData pageData);

    /**
     * 用户忘记密码，使用手机号码修改密码接口
     * @param param
     * @return
     */
    public Map<String,Object> ilonwUserUpdatePassword(@RequestBody IlonwUserBTO param);

    /**
     * 用户注册判断手机号码是否存在接口
     * @param param
     * @return
     */
    public Map<String,Object> registerIlonwUserCheckPhoneisExtis(@RequestBody IlonwUserBTO param);

    /**
     * 用户注册判断邮箱是存在接口
     * @param param
     * @return
     */
    public Map<String,Object> registerIlonwUserCheckEmailisExtis(@RequestBody IlonwUserBTO param);

    /**
     * 用户注册判断验证码是否正确接口
     * @param param
     * @return
     */
    public Map<String,Object> registerIlonwUserCheckSmsCode(@RequestBody SysIlonwSaveUserParam param);

    /**
     * 用户注册接口
     * @param param
     * @return
     */
    public Map<String,Object> registerIlonwUserInfo(@RequestBody IlonwUserBTO param);
}
