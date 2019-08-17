package com.ilonw.api.base;

import com.server.tools.exceptions.ArgumentException;
import com.server.tools.result.APIBaseResult;
import com.server.tools.result.SetAPIResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;


public class ResultResponse{
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	protected APIBaseResult getAPIResult(APIBaseResult result) {
		return result;
	}

	public APIBaseResult vailForm(BindingResult bindingResult){
		APIBaseResult result = new APIBaseResult();
		Map<String,Object> map = new HashMap<String, Object>();
		if(bindingResult.hasErrors()){
			log.info("参数不合法"+bindingResult.getFieldError().getDefaultMessage());
			result.setRespMessage(bindingResult.getFieldError().getDefaultMessage());
			result.setRespCode("PARAM_ERROR");
			result.setRespData(map);
			return result;
		}
		return null;
	}

	public void buildException(APIBaseResult result, String path, Exception e, Object param) {
		if (e instanceof ArgumentException) {
			result.setRespMessage(e.getMessage());
			SetAPIResultUtil.setFail(result);
		} else {
			e.printStackTrace();
			log.error("\n request : " + path + " \n params : \n" +
					param, e);
			result.setRespMessage("服务器接口异常！");
			SetAPIResultUtil.setFail(result);
		}
	}
}
