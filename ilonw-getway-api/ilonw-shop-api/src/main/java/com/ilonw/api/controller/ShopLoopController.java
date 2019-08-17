package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.ShopLoopService;
import com.ilonw.api.vo.ShopLoopAddParam;
import com.ilonw.api.vo.ShopLoopEditParam;
import com.ilonw.api.vo.ShopLoopUserResponse;
import com.ilonw.server.bo.sms.SysSmsBO;
import com.ilonw.server.facade.sms.SysSmsFacade;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/shopLoop")
@Api(description = "首页轮播图接口")
public class ShopLoopController extends BaseController {
    @Autowired
    private ShopLoopService shopLoopService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/findLoopShop", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="首页轮播图显示", notes="首页轮播图接口详细描述")
    public APIBaseResult findLoopShop( HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map =  shopLoopService.findLoopShop();
        return getIntefaceData( request,map, "/findLoopShop", "/shopLoop", now,  "无参数","首页轮播图显示");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/findAdminLoopShop", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="后台管理轮播图显示", notes="首页轮播图接口详细描述")
    public APIBaseResult findAllLoopShop( HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = shopLoopService.findAllLoopShop();
        return getIntefaceData( request,map, "/findAdminLoopShop", "/shopLoop", now,  "无参数","后台管理轮播图显示");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/saveLoopShop", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="新增轮播图", notes="首页轮播图接口详细描述")
    public APIBaseResult saveLoopShop(@RequestBody ShopLoopAddParam param, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = shopLoopService.saveLoopShop(param);
        return getIntefaceData( request,map, "/saveLoopShop", "/shopLoop", now,  "无参数","新增轮播图");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/updateLoopShop", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="更新轮播图显示", notes="首页轮播图接口详细描述")
    public APIBaseResult updateLoopShop(@RequestBody ShopLoopEditParam param,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = shopLoopService.updateLoopShop(param);
        return getIntefaceData( request,map, "/updateLoopShop", "/shopLoop", now,  "无参数","更新轮播图显示");
    }
}
