package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.vo.SysIlonwSaveUserParam;
import com.ilonw.server.Eunms.UserEunms;
import com.ilonw.server.IlonwUserFacade;
import com.ilonw.server.bto.IlonwUserBTO;
import com.server.tools.cache.Cache;
import com.server.tools.result.APIBaseResult;
import com.server.tools.util.IpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/user")
@Api(description = "ilonw用户注册接口")
public class UserRegisterController extends BaseController {
    @Resource
    public IlonwUserFacade ilonwUserFacade;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/check_phone", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户注册判断手机号码是否存在接口", notes="用户注册")
    public APIBaseResult registerIlonwUserCheckPhoneisExtis(@RequestBody IlonwUserBTO param, HttpServletRequest requestIp) {
        long now = System.currentTimeMillis();
        Map<String,Object> map  = ilonwUserFacade.checkIlonwUserByPhoneExits(param);
        return getIntefaceData(requestIp,map,"/user", "/check_phone",now,param,"用户注册判断手机号码是否存在接口");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/check_email", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户注册判断邮箱是存在接口", notes="用户注册")
    public APIBaseResult registerIlonwUserCheckEmailisExtis(@RequestBody IlonwUserBTO param, HttpServletRequest requestIp) {
        long now = System.currentTimeMillis();
        Map<String,Object> map = ilonwUserFacade.checkIlonwUserByEmailExits(param);
        return getIntefaceData(requestIp,map, "/user", "/check_email",now,param,"用户注册判断邮箱是存在接口");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/check_smscode", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户注册判断验证码是否正确接口", notes="用户注册")
    public APIBaseResult registerIlonwUserCheckSmsCode(@RequestBody SysIlonwSaveUserParam param, HttpServletRequest requestIp) {
        Map<String,Object> map = new HashMap<String,Object>();
        long now = System.currentTimeMillis();

        //注册前先判断验证码是否有效
        String str = String.valueOf(Cache.get(param.getIlonw_user_phone()));
        if(param.getSmscode() == str || param.getSmscode().equals(str)) {
            map.put("resCode", UserEunms.SUCCESS.getResCode());
            map.put("resMsg",UserEunms.SUCCESS.getResMsg());
        }else{
            map.put("resCode",UserEunms.SMSCODE_NOTNULL.getResCode());
            map.put("resMsg",UserEunms.SMSCODE_NOTNULL.getResMsg());
        }
        return getIntefaceData(requestIp,map, "/user", "/check_smscode",now,param,"用户注册判断验证码是否正确接口");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/register", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户注册接口", notes="用户注册")
    public APIBaseResult registerIlonwUserInfo(@RequestBody IlonwUserBTO param, HttpServletRequest requestIp, BindingResult bindingResult) {
        APIBaseResult api = vailForm(bindingResult);
        if(api != null){
            return getAPIResult(api);
        }

        Map<String,Object> map = new HashMap<String,Object>();
        long now = System.currentTimeMillis();

        param.setIlonwUserIp(IpUtils.getIpAddr(requestIp));

        //注册前先判断注册的手机号码和邮箱是否存在
        Map<String,Object>  phoneExits = ilonwUserFacade.checkIlonwUserByPhoneExits(param);
        if(phoneExits.get("resCode") != "000000"){
            Map<String,Object> emailExits = ilonwUserFacade.checkIlonwUserByEmailExits(param);
            if(emailExits.get("resCode") != "000000"){
                boolean flag = ilonwUserFacade.saveIlonwUserInfo(param);
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

        return getIntefaceData(requestIp,map, "/user", "/register",now,param,"用户注册");
    }
}
