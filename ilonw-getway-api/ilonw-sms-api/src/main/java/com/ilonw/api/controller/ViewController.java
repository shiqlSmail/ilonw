package com.ilonw.api.controller;

import com.alibaba.druid.util.StringUtils;
import com.ilonw.api.config.LoginUserConfig;
import com.ilonw.api.vo.LoginParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/sms")
public class ViewController {

    /**
     * 打开登录页面
     *
     * @return
     */
    @RequestMapping("/login.htm")
    public String login() {
        return "login";
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping("/loginout.htm")
    public String loginout() {
        return "login";
    }

    /**
     * 登录验证
     * 验证登录参数是否正确
     *
     * @return
     */
    @RequestMapping(value = "/loginVail.htm", method = {RequestMethod.POST})
    public String loginVail(@RequestBody LoginParam loginParam,HttpSession session) {
        loginParam.setStatus(1);
        boolean flag = LoginUserConfig.isLoginUserFlag(loginParam);
        if(flag){
            session.setAttribute("username",loginParam.getUsername());
            return "index";
        }else{
            return "login";
        }
    }

    /**
     * 登录成功，跳转到首页
     *
     * @return
     */
    @RequestMapping(value = "/main.htm")
    public String main(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            return "login";
        }
        return "index";
    }

    /**
     * 登录成功，跳转到首页
     *
     * @return
     */
    @RequestMapping(value = "/home.htm")
    public String home(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            return "login";
        }
        return "main";
    }

    /**
     * 跳转到短信验证码列表页面
     *
     * @return
     */
    @RequestMapping(value = "/smsList.htm")
    public String smsList(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            return "login";
        }
        return "list/smsList";
    }

    /**
     * 跳转到邮件验证码列表页面
     *
     * @return
     */
    @RequestMapping(value = "/emailCodeList.htm")
    public String emailCodeList(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            return "login";
        }
        return "list/emailCodeList";
    }

    /**
     * 跳转到邮箱链接认证列表页面
     *
     * @return
     */
    @RequestMapping(value = "/emailUrlList.htm")
    public String emailUrlList(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            return "login";
        }
        return "list/emailUrlList";
    }
}
