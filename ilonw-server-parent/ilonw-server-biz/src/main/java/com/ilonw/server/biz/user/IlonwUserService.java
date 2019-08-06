package com.ilonw.server.biz.user;

import com.ilonw.server.bo.IlonwUserBO;
import com.ilonw.server.page.PageBean;
import com.ilonw.server.page.PageData;

import java.util.List;
import java.util.Map;

public interface IlonwUserService {

    public PageBean<IlonwUserBO> findAllIlonwUserInfo(PageData pageData);

    /**
     * 用户登录  根据账号密码
     * @param record
     * @return
     */
    public Map<String, Object> loginIlonwUserByPhoneAndEmailAndCode(IlonwUserBO record);

    /**
     * 用户登录  根据手机号验证码
     * @param record
     * @param ip
     * @return
     */
    public Map<String, Object> loginIlonwUserByPhone(IlonwUserBO record,String ip);

    /**
     * 检查注册手机号码是否存在
     * @param param
     * @return
     */
    public Map<String, Object> checkIlonwUserByPhoneExits(IlonwUserBO param);

    /**
     * 检查注册邮箱是否存在
     * @param param
     * @return
     */
    public Map<String, Object> checkIlonwUserByEmailExits(IlonwUserBO param);

    /**
     * 用户注册
     * @param param
     * @return
     */
    public boolean saveIlonwUserInfo(IlonwUserBO param);

    /**
     * 忘记密码，根据手机号码进行修改
     * @param param
     * @return
     */
    public Map<String, Object> updateIlonwUserPassword(IlonwUserBO param);

}
