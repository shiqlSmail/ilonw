package com.ilonw.manager.controller;

import com.ilonw.manager.base.BaseController;
import com.ilonw.manager.service.SysAdminService;
import com.ilonw.manager.vo.SysAdminRequest;
import com.server.tools.cache.Cache;
import com.server.tools.result.APIBaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/sys")
public class SysLoginController extends BaseController {
    @Autowired
    private SysAdminService sysAdminService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/login", produces = "application/json",method = RequestMethod.POST)
    public APIBaseResult selectMenu(@RequestBody SysAdminRequest request) {
        long now = System.currentTimeMillis();
        Map<String,Object> map = sysAdminService.login(request);
        Cache.put("sysAdminLoginInfo",map.get("data"));
        return getIntefaceData(map, "/sys", "/login",now,request);
    }
}
