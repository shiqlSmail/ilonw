package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.vo.PhoneSmsParam;
import com.ilonw.server.facade.sms.SysSmsFacade;
import com.ilonw.server.bo.sms.SysEmailCodeBO;
import com.ilonw.server.bo.sms.SysEmailUrlBO;
import com.ilonw.server.bo.sms.SysSmsBO;
import net.sf.json.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sms/")
public class DataController  extends BaseController {
    @Resource
    private SysSmsFacade sysSmsFacade;

    @PostMapping(value="/findSmsByPhone",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONArray findSmsByPhone(@RequestBody PhoneSmsParam param) {
        SysSmsBO BO = new SysSmsBO();
        BO.setSmsPhone(param.getPhone());
        List<SysSmsBO> listBO = sysSmsFacade.findSmsByPhone(BO);
        JSONArray jsons = JSONArray.fromObject(listBO);
        return jsons;
    }



    /**
     * 查看邮件，点击邮件链接激活
     * @param emailName
     * @return
     */
    @GetMapping(value="/emailurl",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JSONArray findEmailUrl(@RequestParam("emailName") String emailName) {
        SysEmailUrlBO BO = new SysEmailUrlBO();
        BO.setEmailName(emailName);
        List<SysEmailUrlBO> listBO = sysSmsFacade.findEmailByEmailUrl(BO);
        JSONArray jsons = JSONArray.fromObject(listBO);
        return jsons;
    }


    /**
     * 发送邮件验证码
     * @param emailName
     * @return
     */
    @GetMapping(value="/emailyzm")
    @ResponseBody
    public JSONArray findEmailYzm(@RequestParam("emailName") String emailName) {
        SysEmailCodeBO BO = new SysEmailCodeBO();
        BO.setEmailName(emailName);
        List<SysEmailCodeBO> listBO = sysSmsFacade.findEmailCodeByEmailName(BO);
        JSONArray jsons = JSONArray.fromObject(listBO);
        return jsons;
    }
}
