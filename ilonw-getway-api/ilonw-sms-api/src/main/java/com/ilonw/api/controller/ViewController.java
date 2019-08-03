package com.ilonw.api.controller;

import com.alibaba.druid.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sms")
public class ViewController {

    /**
     * 打开登录页面
     * @return
     */
    @RequestMapping("/login.htm")
    public String  login() {
        return "login";
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("/loginout.htm")
    public String  loginout() {
        return "login";
    }

    /**
     * 登录成功
     * @return
     */
    @RequestMapping(value = "/main.htm",method = {RequestMethod.POST})
    public String  to_login(@RequestParam("username") String username, @RequestParam("password") String password){
        if(StringUtils.equals("admin",username) || StringUtils.equals("admin",password)){
            return null;
        }
        return "index";
    }
}
