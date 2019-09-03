package com.ilonw.api.controller.user;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.vo.UserWechatLoginReqVO;
import com.server.tools.result.APIBaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppUserController extends BaseController {

	@RequestMapping(value = "/wechatLogin", method = { RequestMethod.POST })
	public APIBaseResult register(@RequestBody UserWechatLoginReqVO userWechatLoginReqVO, HttpServletResponse response,
								  HttpServletRequest request) {
		long now = System.currentTimeMillis();
		Map<String, Object> map = new HashMap<>();
		return getIntefaceData(request,map, "/wechatLogin", "/app",now,"param:"+userWechatLoginReqVO,"ILONW系统APP端微信登录");
	}
}
