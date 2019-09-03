package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.ShopLoopService;
import com.ilonw.api.vo.request.ShopLoopAddParam;
import com.ilonw.api.vo.request.ShopLoopEditParam;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 轮播图管理
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/shopLoop")
@Api(tags = "ShopLoopController",description = "首页轮播图接口")
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
    @RequestMapping(value = "/saveLoopShop",produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="新增轮播图", notes="首页轮播图接口详细描述")
    public APIBaseResult saveLoopShop(@RequestBody  ShopLoopAddParam shopLoopAddParam, HttpServletRequest request){
        long now = System.currentTimeMillis();
        Map<String, Object> map = shopLoopService.saveLoopShop(shopLoopAddParam);
        return getIntefaceData( request,map, "/saveLoopShop", "/shopLoop", now,  shopLoopAddParam,"新增轮播图");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/updateLoopShop", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="更新轮播图显示", notes="首页轮播图接口详细描述")
    public APIBaseResult updateLoopShop(@RequestBody  ShopLoopEditParam shopLoopEditParam,HttpServletRequest request){
        long now = System.currentTimeMillis();
        Map<String, Object> map = shopLoopService.updateLoopShop(shopLoopEditParam);
        return getIntefaceData( request,map, "/updateLoopShop", "/shopLoop", now,  shopLoopEditParam,"更新轮播图显示");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/deleteLoopShop", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="删除轮播图显示", notes="首页轮播图接口详细描述")
    public APIBaseResult deleteLoopShop(@RequestBody  ShopLoopEditParam shopLoopEditParam,HttpServletRequest request){
        long now = System.currentTimeMillis();
        Map<String, Object> map = shopLoopService.deleteLoop(shopLoopEditParam);
        return getIntefaceData( request,map, "/deleteLoopShop", "/shopLoop", now,  shopLoopEditParam,"删除轮播图显示");
    }
}
