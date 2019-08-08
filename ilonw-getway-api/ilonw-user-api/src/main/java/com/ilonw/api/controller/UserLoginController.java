package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.IlonwUserService;
import com.ilonw.api.vo.IlonwLoginParam;
import com.server.tools.result.APIBaseResult;
import com.server.tools.util.IpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/user")
@Api(description = "ilonw用户登录接口")
public class UserLoginController extends BaseController {
    @Autowired
    public IlonwUserService ilonwUserService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户登录接口", notes="用户登录：可使用手机/邮箱/用户号进行登录")
    public APIBaseResult loginIlonwUserByPhoneAndEmailAndCode(@RequestBody IlonwLoginParam param, HttpServletRequest requestIp) {
        Map<String,Object> map = new HashMap<>();
        long now = System.currentTimeMillis();
        map = ilonwUserService.loginIlonwUserByPhoneAndEmailAndCode(param, IpUtils.getIpAddr(requestIp));
        return getIntefaceData(requestIp,map, "/user", "/login",now,param,"用户登录接口");
    }
}
