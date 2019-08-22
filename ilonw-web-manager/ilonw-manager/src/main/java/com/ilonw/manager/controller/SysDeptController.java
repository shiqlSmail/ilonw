package com.ilonw.manager.controller;

import com.ilonw.manager.base.BaseController;
import com.ilonw.manager.domain.SysAdminBO;
import com.ilonw.manager.domain.SysDeptBO;
import com.ilonw.manager.service.SysAdminService;
import com.ilonw.manager.service.SysDeptService;
import com.server.tools.cache.Cache;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/dept")
public class SysDeptController extends BaseController {
    @Autowired
    private SysDeptService sysDeptService;


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/selectAll", produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject selectAll() {
        Map<String,Object> map = new HashMap<>();
        List<SysDeptBO> list = sysDeptService.selectAll();
        map.put("depts",JSONArray.fromObject(list));
        return JSONObject.fromObject(map);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/update", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestBody SysDeptBO sysDeptBO) {
        int returnCount = 0;
        int resultCount = sysDeptService.updateByPrimaryKeySelective(sysDeptBO);
        if(resultCount > 0){
            returnCount = resultCount;
        }
        return returnCount;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/add", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestBody SysDeptBO sysDeptBO) {
        int returnCount = 0;
        int resultCount = sysDeptService.insertSelective(sysDeptBO);
        if(resultCount > 0){
            returnCount = resultCount;
        }
        return returnCount;
    }
}
