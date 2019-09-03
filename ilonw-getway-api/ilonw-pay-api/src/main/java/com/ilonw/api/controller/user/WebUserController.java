package com.ilonw.api.controller.user;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.vo.UserWechatLoginReqVO;
import com.server.tools.result.APIBaseResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/web")
public class WebUserController extends BaseController {

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/wechatLogin", method = { RequestMethod.POST })
	public APIBaseResult register(@RequestBody UserWechatLoginReqVO userWechatLoginReqVO, HttpServletResponse response,
								  HttpServletRequest request) {
		long now = System.currentTimeMillis();
		Map<String, Object> map = new HashMap<>();

		return getIntefaceData(request,map, "/wechatLogin", "/web",now,"param:"+userWechatLoginReqVO,"ILONW系统WEB端微信登录");
	}
}
