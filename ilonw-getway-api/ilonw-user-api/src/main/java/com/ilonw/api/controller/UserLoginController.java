package com.ilonw.api.controller;

import com.alibaba.druid.util.StringUtils;
import com.ilonw.api.base.BaseController;
import com.ilonw.api.enums.UserLoginEunms;
import com.ilonw.api.vo.IlonwLoginParam;
import com.ilonw.server.Eunms.UserEunms;
import com.ilonw.server.IlonwUserFacade;
import com.ilonw.server.bto.IlonwUserBTO;
import com.server.tools.cache.Cache;
import com.server.tools.encryption.MD5Util;
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
@Api(description = "ilonw用户登录接口")
public class UserLoginController extends BaseController {
    @Resource
    public IlonwUserFacade ilonwUserFacade;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户登录接口", notes="用户登录：可使用手机/邮箱/用户号进行登录")
    public APIBaseResult loginIlonwUserByPhoneAndEmailAndCode(@RequestBody IlonwLoginParam param, HttpServletRequest requestIp) {
        Map<String,Object> map = new HashMap<>();
        long now = System.currentTimeMillis();
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

                //获取IP
                String ip = IpUtils.getIpAddr(requestIp);
                map = ilonwUserFacade.loginIlonwUserByPhone(record,ip);
            }
        }else{
            //record.setIlonwUserCode(param.getIlonwUserCode());
            record.setIlonwUserPhone(param.getIlonwUserPhone());
            //record.setIlonwUserEmail(param.getIlonwUserEmail());
            record.setIlonwUserPassword(MD5Util.MD5Encode(param.getIlonwUserPassword(),"UTF-8"));
            map = ilonwUserFacade.loginIlonwUserByPhoneAndEmailAndCode(record);
        }
        return getIntefaceData(requestIp,map, "/user", "/login",now,param,"用户登录接口");
    }
}
