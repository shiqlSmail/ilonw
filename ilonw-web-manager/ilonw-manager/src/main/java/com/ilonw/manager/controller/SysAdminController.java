package com.ilonw.manager.controller;

import com.ilonw.manager.base.BaseController;
import com.ilonw.manager.domain.SysAdminBO;
import com.ilonw.manager.domain.SysLoginBO;
import com.ilonw.manager.service.SysAdminService;
import com.server.tools.cache.Cache;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class SysAdminController  extends BaseController {
    @Autowired
    private SysAdminService sysAdminService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/find", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectAdmin() {
        Map<String,Object> map = new HashMap<>();
        SysAdminBO sysAdminBO = (SysAdminBO)Cache.get("sysAdminLoginInfo");
        map.put("data",JSONObject.fromObject(sysAdminBO));
        return JSONObject.fromObject(map);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/loginHistory", produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject loginHistory() {
        Map<String,Object> map = new HashMap<>();
        List<SysLoginBO> sysLoginBOList = sysAdminService.selectAllLoginInfo("10000");
        map.put("loginHistory",JSONArray.fromObject(sysLoginBOList));
        return JSONObject.fromObject(map);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/selectAll", produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject selectAll() {
        Map<String,Object> map = new HashMap<>();
        List<SysAdminBO> list = sysAdminService.selectAll();
        map.put("administrator",JSONArray.fromObject(list));
        return JSONObject.fromObject(map);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/update", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestBody SysAdminBO sysAdminBO) {
        int returnCount = 0;
        int resultCount = sysAdminService.updateByPrimaryKeySelective(sysAdminBO);
        if(resultCount > 0){
            returnCount = resultCount;
        }
        return returnCount;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/add", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestBody SysAdminBO sysAdminBO) {
        int returnCount = 0;
        int resultCount = sysAdminService.insertSelective(sysAdminBO);
        if(resultCount > 0){
            returnCount = resultCount;
        }
        return returnCount;
    }
}
