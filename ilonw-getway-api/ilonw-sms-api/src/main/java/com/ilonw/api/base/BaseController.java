package com.ilonw.api.base;

import com.alibaba.fastjson.JSON;
import com.ilonw.server.facade.sys.SysIlonwLogsFacade;
import com.ilonw.server.bo.SysIlonwLogsEntity;
import com.server.tools.exceptions.ArgumentException;
import com.server.tools.result.APIBaseResult;
import com.server.tools.result.SetAPIResultUtil;
import com.server.tools.util.IpUtils;
import com.server.tools.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author shiql
 */
public abstract class BaseController extends ResultResponse {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    SysIlonwLogsFacade sysIlonwLogsFacade;

    public APIBaseResult getIntefaceData(HttpServletRequest requestIp,Map<String, Object> map, String v1Result, String methodResult,long now,Object param,String type) {
        log.info("请求参数："+param);
        APIBaseResult result = new APIBaseResult();
        try {
            result.setData(map);
            SetAPIResultUtil.setSuccess(result);
            log.info("\n request : " + v1Result + methodResult + " \n params : {}" + "\n success :{} \n time : " + (System.currentTimeMillis() - now) + "ms", JSON.toJSON(param), JSON.toJSON(result));
        } catch (Exception e) {
            if (e instanceof ArgumentException) {
                result.setMessage(e.getMessage());
                SetAPIResultUtil.setFail(result);
            } else {
                e.printStackTrace();
                log.error("\n request : " + v1Result + methodResult + " \n params : \n", e);
                result.setMessage("服务器接口异常！");
                SetAPIResultUtil.setFail(result);
            }
            e.printStackTrace();
        }
        log.info("【" + v1Result + methodResult + "】接口返回数据：" + JSON.toJSON(result));

        //保存日志
        saveLogs(requestIp,JSON.toJSON(param),methodResult,JSON.toJSON(result),"SUCCESS",System.currentTimeMillis() - now,type);
        return getAPIResult(result);
    }


    public APIBaseResult getIntefaceData(HttpServletRequest requestIp,Object obj, String v1Result, String methodResult,long now,Object param,String type) {
        log.info("请求参数："+param);
        APIBaseResult result = new APIBaseResult();
        try {
            result.setData(obj);
            SetAPIResultUtil.setSuccess(result);
            log.info("\n request : " + v1Result + methodResult + " \n params : {}" + "\n success :{} \n time : " + (System.currentTimeMillis() - now) + "ms",JSON.toJSON(param), JSON.toJSON(result));
        } catch (Exception e) {
            if (e instanceof ArgumentException) {
                result.setMessage(e.getMessage());
                SetAPIResultUtil.setFail(result);
            } else {
                e.printStackTrace();
                log.error("\n request : " + v1Result + methodResult + " \n params : \n", e);
                result.setMessage("服务器接口异常！");
                SetAPIResultUtil.setFail(result);
            }
            e.printStackTrace();
        }
        log.info("【" + v1Result + methodResult + "】接口返回数据：" + JSON.toJSON(result));
        saveLogs(requestIp,JSON.toJSON(param),methodResult,JSON.toJSON(result),"SUCCESS",System.currentTimeMillis() - now,type);
        return getAPIResult(result);
    }

    //保存日志
    public void saveLogs(HttpServletRequest requestIp, Object param, String request, Object result, String status, long times, String type){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SysIlonwLogsEntity record = new SysIlonwLogsEntity();
        record.setLogAuthor("ilonw_shiql");
        record.setLogCreatetime(sdf.format(new Date()));
        record.setLogId(UUIDUtil.primaryKeyUUID());
        record.setLogIp(IpUtils.getIpAddr(requestIp));
        record.setLogParam(param.toString());
        record.setLogRequest(request);
        record.setLogResult(result.toString());
        record.setLogStatus(status);
        record.setLogTimes(times+"ms");
        record.setLogType(type);
        Boolean saveStatus = sysIlonwLogsFacade.insertLogsByRequest(record);
        if(saveStatus){
            log.info("日志【" + request+"】保存成功");
        }else{
            log.info("日志【" + request+"】保存失败" );
        }
    }
}
