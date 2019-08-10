package com.ilonw.api.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ilonw.api.enums.UserLoginEunms;
import com.ilonw.api.service.IlonwUserService;
import com.ilonw.api.vo.*;
import com.ilonw.server.Eunms.UserEunms;
import com.ilonw.server.bto.IlonwUserBTO;
import com.ilonw.server.facade.user.IlonwUserFacade;
import com.ilonw.server.page.PageBean;
import com.ilonw.server.page.PageData;
import com.server.tools.cache.Cache;
import com.server.tools.encryption.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class IlonwUserServiceImpl implements IlonwUserService {

    @Resource
    public IlonwUserFacade ilonwUserFacade;

    /**
     * 用户登录：可使用手机/邮箱/用户号进行登录
     * @param param
     * @return
     */
    @Override
    public Map<String,Object> loginIlonwUserByPhoneAndEmailAndCode(IlonwLoginParam param,String ip){
        Map<String,Object> map = new HashMap<>();
        IlonwUserBTO record = new IlonwUserBTO();
        Object phone = Cache.get(param.getIlonwUserPhone());
        if(UserLoginEunms.CODE.getResCode().equals(param.getLoginType())){
            //判断验证码是否为空
            if(StringUtils.isEmpty(param.getIlonwSmsCode())){
                map.put("resCode", UserEunms.SMSCODE_NULL.getResCode());
                map.put("resMsg",UserEunms.SMSCODE_NULL.getResMsg());
            }else if(null == phone){
                map.put("resCode", UserEunms.SMSCODE_EXITS.getResCode());
                map.put("resMsg",UserEunms.SMSCODE_EXITS.getResMsg());
            }else{
                record.setIlonwUserPhone(param.getIlonwUserPhone());
                map = ilonwUserFacade.loginIlonwUserByPhone(record,ip);
            }
        }else{
            //record.setIlonwUserCode(param.getIlonwUserCode());
            record.setIlonwUserPhone(param.getIlonwUserPhone());
            //record.setIlonwUserEmail(param.getIlonwUserEmail());
            record.setIlonwUserPassword(MD5Util.MD5Encode(param.getIlonwUserPassword(),"UTF-8"));
            map = ilonwUserFacade.loginIlonwUserByPhoneAndEmailAndCode(record);
        }
        return map;
    }


    /**
     * 查询所有用户接口
     * @param pageData
     * @return
     */
    @Override
    public Map<String,Object> queryAllUser(PageData pageData){
        PageBean<IlonwUserBTO> listUser = new PageBean<>();
        Map<String,Object> map = new HashMap<String,Object>();
        long now = System.currentTimeMillis();
        Object obj = Cache.get("query_user");
        if(null == obj){
            listUser = ilonwUserFacade.findAllIlonwUserInfo(pageData);
            //Cache.put("query_user",listUser,1000*60*60);
            Cache.put("query_user",listUser,1000);
        }else{
            listUser = (PageBean)obj;
        }
        map.put("userAllList",listUser);
        return map;
    }

    /**
     * 用户忘记密码，使用手机号码修改密码接口
     * @param param
     * @return
     */
    @Override
    public Map<String,Object> ilonwUserUpdatePassword(ForgetPassParam param){
        Map<String,Object> map = new HashMap<String,Object>();

        IlonwUserBTO bto = new IlonwUserBTO();
        bto.setIlonwUserPassword(param.getIlonwUserPassword());
        bto.setIlonwUserPhone(param.getIlonwUserPhone());
        map = ilonwUserFacade.updateIlonwUserPassword(bto);
        return map;
    }

    /**
     * 用户注册判断手机号码是否存在接口
     * @param param
     * @return
     */
    @Override
    public Map<String,Object> registerIlonwUserCheckPhoneisExtis(CheckPhoneParam param){
        IlonwUserBTO bto = new IlonwUserBTO();
        bto.setIlonwUserPhone(param.getIlonwUserPhone());
        Map<String,Object> map  = ilonwUserFacade.checkIlonwUserByPhoneExits(bto);
        return map;
    }

    /**
     * 用户注册判断邮箱是存在接口
     * @param param
     * @return
     */
    @Override
    public Map<String,Object> registerIlonwUserCheckEmailisExtis(CheckEmailParam param){
        IlonwUserBTO bto = new IlonwUserBTO();
        bto.setIlonwUserEmail(param.getIlonwUserEmail());
        Map<String,Object> map = ilonwUserFacade.checkIlonwUserByEmailExits(bto);
        return map;
    }

    /**
     * 用户注册判断验证码是否正确接口
     * @param param
     * @return
     */
    @Override
    public Map<String,Object> registerIlonwUserCheckSmsCode(@RequestBody CheckPhoneSmsParam param){
        Map<String,Object> map = new HashMap<String,Object>();

        //注册前先判断验证码是否有效
        String str = String.valueOf(Cache.get(param.getIlonwUserPhone()));
        if(param.getSmscode() == str || param.getSmscode().equals(str)) {
            map.put("resCode", UserEunms.SUCCESS.getResCode());
            map.put("resMsg",UserEunms.SUCCESS.getResMsg());
        }else{
            map.put("resCode",UserEunms.SMSCODE_NOTNULL.getResCode());
            map.put("resMsg",UserEunms.SMSCODE_NOTNULL.getResMsg());
        }
        return map;
    }

    /**
     * 用户注册接口
     * @param param
     * @return
     */
    @Override
    public Map<String,Object> registerIlonwUserInfo(SysIlonwSaveUserParam param){
        Map<String,Object> map = new HashMap<String,Object>();
        //注册前先判断注册的手机号码和邮箱是否存在
        IlonwUserBTO bto = new IlonwUserBTO();
        bto.setIlonwUserPhone(param.getIlonwUserPhone());
        Map<String,Object>  phoneExits = ilonwUserFacade.checkIlonwUserByPhoneExits(bto);
        if(phoneExits.get("resCode") != "000000"){
            bto.setIlonwUserEmail(param.getIlonwUserEmail());
            Map<String,Object> emailExits = ilonwUserFacade.checkIlonwUserByEmailExits(bto);
            if(emailExits.get("resCode") != "000000"){
                IlonwUserBTO saveUserBTO = getUserBTO(param);
                boolean flag = ilonwUserFacade.saveIlonwUserInfo(saveUserBTO);
                if(flag == Boolean.TRUE){
                    map.put("resCode", UserEunms.SUCCESS.getResCode());
                    map.put("resMsg",UserEunms.SUCCESS.getResMsg());
                }else{
                    map.put("resCode",UserEunms.REGISTER_FAIL.getResCode());
                    map.put("resMsg",UserEunms.REGISTER_FAIL.getResMsg());
                }
            }else{
                map.put("resCode",UserEunms.EMAIL_NOTNULL.getResCode());
                map.put("resMsg",UserEunms.EMAIL_NOTNULL.getResMsg());
            }
        }else{
            map.put("resCode",UserEunms.PHONE_NOTNULL.getResCode());
            map.put("resMsg",UserEunms.PHONE_NOTNULL.getResMsg());
        }
        return map;
    }

    /**
     * 类转换
     * @param param
     * @return
     */
    public static IlonwUserBTO getUserBTO(SysIlonwSaveUserParam param){
        IlonwUserBTO userBTO = new IlonwUserBTO();
        userBTO.setIlonwUserAddress(param.getIlonwUserAddress());
        userBTO.setIlonwUserAge(param.getIlonwUserAge());
        userBTO.setIlonwUserBrithday(param.getIlonwUserBrithday());
        userBTO.setIlonwUserEmail(param.getIlonwUserEmail());
        userBTO.setIlonwUserImage(param.getIlonwUserImage());
        userBTO.setIlonwUserIp(param.getIlonwUserIp());
        userBTO.setIlonwUserName(param.getIlonwUserName());
        userBTO.setIlonwUserNikename(param.getIlonwUserNikename());
        userBTO.setIlonwUserPassword(param.getIlonwUserPassword());
        userBTO.setIlonwUserPhone(param.getIlonwUserPhone());
        userBTO.setIlonwUserSex(param.getIlonwUserSex());
        return userBTO;
    }
}
