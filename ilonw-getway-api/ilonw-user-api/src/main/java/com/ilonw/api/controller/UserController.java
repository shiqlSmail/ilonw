package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.server.IlonwUserFacade;
import com.ilonw.server.bto.IlonwUserBTO;
import com.server.tools.cache.Cache;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/user")
@Api(description = "ilonw用户接口")
public class UserController extends BaseController {
    @Resource
    public IlonwUserFacade ilonwUserFacade;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/query_user", method = RequestMethod.POST)
    @ApiOperation(value="查询所有用户接口", notes="用户接口详细描述")
    public APIBaseResult queryAllUser(HttpServletRequest requestIp) {
        List<IlonwUserBTO> listUser = new ArrayList<IlonwUserBTO>();
        Map<String,Object> map = new HashMap<String,Object>();
        long now = System.currentTimeMillis();
        Object obj = Cache.get("query_user");
        if(null == obj){
            listUser = ilonwUserFacade.findAllIlonwUserInfo();
            Cache.put("query_user",listUser,1000*60*60);
        }else{
            listUser = (List)obj;
        }
        map.put("userAllList",listUser);
        return getIntefaceData(requestIp,listUser, "/user", "/query_user",now,"无参数","用户接口详细描述");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/update_password", method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="用户忘记密码，使用手机号码修改密码接口", notes="用户修改密码")
    public APIBaseResult ilonwUserUpdatePassword(@RequestBody IlonwUserBTO param, HttpServletRequest requestIp) {
        Map<String,Object> map = new HashMap<String,Object>();
        long now = System.currentTimeMillis();
        map = ilonwUserFacade.updateIlonwUserPassword(param);
        return getIntefaceData(requestIp,map, "/user", "/update_password",now,param,"用户修改密码");
    }
}
