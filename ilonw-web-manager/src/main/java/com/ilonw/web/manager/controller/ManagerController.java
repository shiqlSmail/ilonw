package com.ilonw.web.manager.controller;

import com.ilonw.web.manager.system.InterfaceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ilonw")
public class ManagerController extends InterfaceBean {

    protected static final Logger log = LoggerFactory.getLogger(ManagerController.class);

    /**
     * 动态接口
     * @param map
     * @return
     */
    @RequestMapping(value = "/com",method = RequestMethod.POST)
    public String queryAllUser(@RequestBody Map<String, String> map){
        String url = map.get("url");
        log.info("获取到的URL信息为："+url);
        String response = toSendPost(url,map);
        log.info("返回的数据为："+response);
        return response;
    }
}
