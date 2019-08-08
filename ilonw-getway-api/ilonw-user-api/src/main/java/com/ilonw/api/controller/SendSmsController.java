package com.ilonw.api.controller;

import com.aliyuncs.exceptions.ClientException;
import com.ilonw.api.base.BaseController;
import com.ilonw.api.vo.PhoneSmsParam;
import com.ilonw.server.bo.SysSmsBO;
import com.ilonw.server.facade.sms.SysSmsFacade;
import com.server.tools.result.APIBaseResult;
import com.server.tools.send.SendSmsUtils;
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
@Api(description = "短信接口")
public class SendSmsController extends BaseController {
    @Resource
    private SysSmsFacade sysSmsFacade;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/sms", produces = "application/json", method = {RequestMethod.POST})
    @ApiOperation(value="发送短信验证码", notes="发送短信接口详细描述")
    public APIBaseResult sendSms(@RequestBody @Valid PhoneSmsParam param, HttpServletRequest request, BindingResult bindingResult) {
        APIBaseResult api = vailForm(bindingResult);
        if (api != null) {
            return getAPIResult(api);
        }
        long now = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        try {
            SendSmsUtils sms = new SendSmsUtils();
            boolean isFlag = sms.send(param.getPhone(), code);
            if (isFlag) {
                map.put("resMsg", "success");
                map.put("data", code);
            } else {
                map.put("resMsg", "验证码发送失败");
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
        /*int code = 111111;*/

        SysSmsBO BO = new SysSmsBO();
        BO.setSmsCode(code);
        BO.setSmsPhone(param.getPhone());
        sysSmsFacade.saveSms(BO);
        return getIntefaceData( request,map, "/send", "/sms", now, param + "：：：" + code,"发送短信验证码");
    }
}
