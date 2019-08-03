package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.vo.EmailSendParam;
import com.ilonw.api.vo.PhoneSmsParam;
import com.ilonw.server.SysSmsFacade;
import com.ilonw.server.bo.SysEmailCodeBO;
import com.ilonw.server.bo.SysEmailUrlBO;
import com.ilonw.server.bo.SysSmsBO;
import com.server.tools.result.APIBaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sms/")
public class DataController  extends BaseController {
    @Resource
    private SysSmsFacade sysSmsFacade;

    /**
     * 查看邮件，点击邮件链接激活
     * @param param
     * @param request
     * @return
     */
    @RequestMapping(value = "/emailurl", produces = "application/json", method = {RequestMethod.POST})
    public APIBaseResult findEmailUrl(@RequestBody EmailSendParam param, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        SysEmailUrlBO BO = new SysEmailUrlBO();
        BO.setEmailName(param.getEmail());
        List<SysEmailUrlBO> listBO = sysSmsFacade.findEmailByEmailUrl(BO);
        map.put("resMsg", "success");
        map.put("resCode", "000000");
        map.put("data", listBO);
        return getIntefaceData( request,map, "/findEmailUrl", "/email", now, param,"查看邮件激活链接");
    }


    /**
     * 发送邮件验证码
     * @param param
     * @param request
     * @return
     */
    @RequestMapping(value = "/emailyzm", produces = "application/json", method = {RequestMethod.POST})
    public APIBaseResult findEmailYzm(@RequestBody EmailSendParam param, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        SysEmailCodeBO BO = new SysEmailCodeBO();
        BO.setEmailName(param.getEmail());
        List<SysEmailCodeBO> listBO = sysSmsFacade.findEmailCodeByEmailName(BO);
        map.put("resMsg", "success");
        map.put("resCode", "000000");
        map.put("data", listBO);
        return getIntefaceData(request,map, "/findEmailYzm", "/email", now, param ,"发送邮件验证码");
    }


    @RequestMapping(value = "/sms", produces = "application/json", method = {RequestMethod.POST})
    public String findSmsByPhone(@RequestBody PhoneSmsParam param, HttpServletRequest request) {
        SysSmsBO BO = new SysSmsBO();
        BO.setSmsPhone(param.getPhone());
        List<SysSmsBO> listBo = sysSmsFacade.findSmsByPhone(BO);
        request.setAttribute("listBo", listBo);
        return "index";
    }

}
