package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.vo.EmailSendParam;
import com.ilonw.server.SysSmsFacade;
import com.ilonw.server.bo.SysEmailCodeBO;
import com.ilonw.server.bo.SysEmailUrlBO;
import com.server.tools.cache.Cache;
import com.server.tools.result.APIBaseResult;
import com.server.tools.send.SendEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/send")
@Api(description = "邮件接口")
public class SendEmailController extends BaseController {
    @Resource
    private SysSmsFacade sysSmsFacade;

    /**
     * 发送邮件，点击邮件链接激活
     * @param param
     * @param request
     * @param bindingResult
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/emailUrl", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="发送邮件激活链接", notes="发送邮件接口详细描述")
    public APIBaseResult sendEmailUrl(@RequestBody @Valid EmailSendParam param, HttpServletRequest request, BindingResult bindingResult) {
        APIBaseResult api = vailForm(bindingResult);
        if (api != null) {
            return getAPIResult(api);
        }
        long now = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        try {
            SendEmailUtils email = new SendEmailUtils();
            boolean isFlag = email.sendAccountActivateEmailToUrl(param.getEmail(),param.getUrl(),param.getUsername());
            if (isFlag) {
                map.put("resMsg", "success");
            } else {
                map.put("resMsg", "邮件发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SysEmailUrlBO BO = new SysEmailUrlBO();
        BO.setEmailUrl(param.getUsername() + "先生/女士您好，请点击此链接激活账号" + "<a target='_BLANK' href='" + param.getUrl() + "'>" + param.getUrl() + "</a>");
        BO.setEmailName(param.getEmail());
        sysSmsFacade.saveEmailUrl(BO);
        return getIntefaceData( request,map, "/emailUrl", "/email", now, param,"发送邮件激活链接");
    }


    /**
     * 发送邮件验证码
     * @param param
     * @param request
     * @param bindingResult
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/emailYzm", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="发送邮件验证码", notes="发送邮件接口详细描述")
    public APIBaseResult sendEmailYzm(@RequestBody @Valid EmailSendParam param, HttpServletRequest request, BindingResult bindingResult) {
        APIBaseResult api = vailForm(bindingResult);
        if (api != null) {
            return getAPIResult(api);
        }
        long now = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        Cache.put(param.getEmail(), code, 60000*5);
        try {
            SendEmailUtils email = new SendEmailUtils();
            boolean isFlag = email.sendAccountActivateEmailToYzm(param.getEmail(),String.valueOf(code),param.getUsername());
            if (isFlag) {
                map.put("resMsg", "success");
            } else {
                map.put("resMsg", "发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SysEmailCodeBO BO = new SysEmailCodeBO();
        BO.setEmailCode(code);
        BO.setEmailName(param.getEmail());
        return getIntefaceData(request,map, "/emailYzm", "/email", now, param + ":::::"+code,"发送邮件验证码");
    }
}
