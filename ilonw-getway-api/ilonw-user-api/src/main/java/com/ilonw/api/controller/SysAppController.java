package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.SysAppService;
import com.ilonw.api.vo.SysAppParam;
import com.ilonw.api.vo.SysAppResponse;
import com.ilonw.api.vo.SysAppSignResponse;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/sys")
@Api(description = "appkey接口")
public class SysAppController extends BaseController {
    @Resource
    public SysAppService sysAppService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    @ApiOperation(value="根据渠道申请appkey信息", notes="ilonw申请appkey")
    public APIBaseResult queryAllUser(@RequestBody SysAppParam param,HttpServletRequest requestIp) throws Exception {
        long now = System.currentTimeMillis();
        SysAppSignResponse response = sysAppService.sign(param);
        return getIntefaceData(requestIp,response, "/sys", "/sign",now,param,"appkey接口");
    }

    /**
     * 根据appid和appkey获取渠道信息
     * @param param
     * @param requestIp
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getChannel", method = RequestMethod.POST)
    @ApiOperation(value="根据appid和appkey获取渠道信息", notes="根据appid和appkey获取渠道信息")
    public APIBaseResult queryAllUser(@RequestBody SysAppResponse param,HttpServletRequest requestIp) {
        long now = System.currentTimeMillis();
        Map<String,Object> map = sysAppService.getAppInfo(param);
        return getIntefaceData(requestIp,map, "/sys", "/getChannel",now,param,"appkey接口");
    }
}
