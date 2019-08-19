package com.ilonw.manager.base;

import com.alibaba.fastjson.JSON;
import com.server.tools.exceptions.ArgumentException;
import com.server.tools.result.APIBaseResult;
import com.server.tools.result.SetAPIResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author shiql
 */
public abstract class BaseController extends ResultResponse {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    public APIBaseResult getIntefaceData(Map<String, Object> map, String v1Result, String methodResult,long now,Object param) {
        log.info("请求参数："+param);
        APIBaseResult result = new APIBaseResult();
        try {
            result.setRespData(map);
            SetAPIResultUtil.setSuccess(result);
            log.info("\n request : " + v1Result + methodResult + " \n params : {}" + "\n success :{} \n time : " + (System.currentTimeMillis() - now) + "ms", JSON.toJSON(param), JSON.toJSON(result));
        } catch (Exception e) {
            if (e instanceof ArgumentException) {
                result.setRespMessage(e.getMessage());
                SetAPIResultUtil.setFail(result);
            } else {
                e.printStackTrace();
                log.error("\n request : " + v1Result + methodResult + " \n params : \n", e);
                result.setRespMessage("服务器接口异常！");
                SetAPIResultUtil.setFail(result);
            }
            e.printStackTrace();
        }
        log.info("【" + v1Result + methodResult + "】接口返回数据：" + JSON.toJSON(result));

        return getAPIResult(result);
    }


    public APIBaseResult getIntefaceData(Object obj, String v1Result, String methodResult,long now,Object param) {
        log.info("请求参数："+param);
        APIBaseResult result = new APIBaseResult();
        try {
            result.setRespData(obj);
            SetAPIResultUtil.setSuccess(result);
            log.info("\n request : " + v1Result + methodResult + " \n params : {}" + "\n success :{} \n time : " + (System.currentTimeMillis() - now) + "ms",JSON.toJSON(param), JSON.toJSON(result));
        } catch (Exception e) {
            if (e instanceof ArgumentException) {
                result.setRespMessage(e.getMessage());
                SetAPIResultUtil.setFail(result);
            } else {
                e.printStackTrace();
                log.error("\n request : " + v1Result + methodResult + " \n params : \n", e);
                result.setRespMessage("服务器接口异常！");
                SetAPIResultUtil.setFail(result);
            }
            e.printStackTrace();
        }
        log.info("【" + v1Result + methodResult + "】接口返回数据：" + JSON.toJSON(result));
        return getAPIResult(result);
    }
}
