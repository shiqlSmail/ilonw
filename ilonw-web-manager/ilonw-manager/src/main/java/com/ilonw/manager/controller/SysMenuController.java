package com.ilonw.manager.controller;

import com.ilonw.manager.domain.SysMenuBO;
import com.ilonw.manager.service.SysMenuService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/sys")
public class SysMenuController{
    @Autowired
    private SysMenuService sysMenuService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/menu", produces = "application/json")
    @ResponseBody
    public JSONObject selectMenu() {
        Map<String,Object> map = new HashMap<>();
        List<SysMenuBO> listMenu = sysMenuService.selectSysMenu();
        map.put("data",JSONArray.fromObject(listMenu));
        return JSONObject.fromObject(map);
    }
}
