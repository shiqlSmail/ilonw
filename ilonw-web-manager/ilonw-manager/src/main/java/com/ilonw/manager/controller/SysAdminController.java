package com.ilonw.manager.controller;

import com.ilonw.manager.base.BaseController;
import com.ilonw.manager.domain.SysAdminBO;
import com.ilonw.manager.domain.SysMenuBO;
import com.ilonw.manager.service.SysAdminService;
import com.ilonw.manager.service.SysMenuService;
import com.server.tools.cache.Cache;
import com.server.tools.result.APIBaseResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
}
