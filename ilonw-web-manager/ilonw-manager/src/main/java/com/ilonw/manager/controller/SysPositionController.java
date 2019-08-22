package com.ilonw.manager.controller;

import com.ilonw.manager.base.BaseController;
import com.ilonw.manager.domain.SysPositionBO;
import com.ilonw.manager.domain.SysRoleBO;
import com.ilonw.manager.service.SysPositionService;
import com.ilonw.manager.service.SysRoleService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/position")
public class SysPositionController extends BaseController {
    @Autowired
    private SysPositionService sysPositionService;


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/selectAll", produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject selectAll() {
        Map<String,Object> map = new HashMap<>();
        List<SysPositionBO> list = sysPositionService.selectAll();
        map.put("positions",JSONArray.fromObject(list));
        return JSONObject.fromObject(map);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/update", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestBody SysPositionBO sysPositionBO) {
        int returnCount = 0;
        int resultCount = sysPositionService.updateByPrimaryKeySelective(sysPositionBO);
        if(resultCount > 0){
            returnCount = resultCount;
        }
        return returnCount;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/add", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestBody SysPositionBO sysPositionBO) {
        int returnCount = 0;
        int resultCount = sysPositionService.insertSelective(sysPositionBO);
        if(resultCount > 0){
            returnCount = resultCount;
        }
        return returnCount;
    }
}
