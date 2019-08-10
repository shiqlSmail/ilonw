package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.IlonwUserService;
import com.ilonw.api.vo.CheckEmailParam;
import com.ilonw.api.vo.CheckPhoneParam;
import com.ilonw.api.vo.CheckPhoneSmsParam;
import com.ilonw.api.vo.SysIlonwSaveUserParam;
import com.ilonw.server.Eunms.UserEunms;
import com.ilonw.server.facade.user.IlonwUserFacade;
import com.ilonw.server.bto.IlonwUserBTO;
import com.server.tools.cache.Cache;
import com.server.tools.result.APIBaseResult;
import com.server.tools.util.IpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    public IlonwUserService ilonwUserService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/check_phone", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户注册判断手机号码是否存在接口", notes="用户注册")
    public APIBaseResult registerIlonwUserCheckPhoneisExtis(@RequestBody CheckPhoneParam param, HttpServletRequest requestIp) {
        long now = System.currentTimeMillis();
        Map<String,Object> map  = ilonwUserService.registerIlonwUserCheckPhoneisExtis(param);
        return getIntefaceData(requestIp,map,"/user", "/check_phone",now,param,"用户注册判断手机号码是否存在接口");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/check_email", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户注册判断邮箱是存在接口", notes="用户注册")
    public APIBaseResult registerIlonwUserCheckEmailisExtis(@RequestBody CheckEmailParam param, HttpServletRequest requestIp) {
        long now = System.currentTimeMillis();
        Map<String,Object> map = ilonwUserService.registerIlonwUserCheckEmailisExtis(param);
        return getIntefaceData(requestIp,map, "/user", "/check_email",now,param,"用户注册判断邮箱是存在接口");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/check_smscode", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户注册判断验证码是否正确接口", notes="用户注册")
    public APIBaseResult registerIlonwUserCheckSmsCode(@RequestBody CheckPhoneSmsParam param, HttpServletRequest requestIp) {
        long now = System.currentTimeMillis();
        Map<String,Object> map = ilonwUserService.registerIlonwUserCheckSmsCode(param);
        return getIntefaceData(requestIp,map, "/user", "/check_smscode",now,param,"用户注册判断验证码是否正确接口");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/register", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户注册接口", notes="用户注册")
    public APIBaseResult registerIlonwUserInfo(@RequestBody SysIlonwSaveUserParam param, HttpServletRequest requestIp, BindingResult bindingResult) {
        APIBaseResult api = vailForm(bindingResult);
        if(api != null){
            return getAPIResult(api);
        }
        long now = System.currentTimeMillis();
        param.setIlonwUserIp(IpUtils.getIpAddr(requestIp));

        Map<String,Object>  map = ilonwUserService.registerIlonwUserInfo(param);
        return getIntefaceData(requestIp,map, "/user", "/register",now,param,"用户注册");
    }
}
