package com.ilonw.api.manager.controller;

import com.ilonw.api.manager.system.InterfaceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController extends InterfaceBean {

    protected static final Logger log = LoggerFactory.getLogger(ViewController.class);

    /**
     * 接口文档
     * @return
     */
    @RequestMapping(value = "/index.htm")
    public String queryAllUser(){
        return "index";
    }

    /**
     * 接口文档统计
     * @return
     */
    @RequestMapping(value = "/count.htm")
    public String count(){
        return "count";
    }
}
