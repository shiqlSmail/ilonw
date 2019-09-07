package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.MemberReadHistoryService;
import com.ilonw.server.bo.shop.MemberReadHistory;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 会员商品浏览记录管理Controller
 */
@RestController
@EnableAutoConfiguration
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController   extends BaseController {
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "创建浏览记录", notes="会员商品浏览记录管理")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public APIBaseResult create(@RequestBody MemberReadHistory memberReadHistory, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = memberReadHistoryService.create(memberReadHistory);
        return getIntefaceData(request, map, "/create", "/member/readHistory", now, "param:::"+memberReadHistory, "创建浏览记录");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "删除浏览记录", notes="会员商品浏览记录管理")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIBaseResult delete(@RequestParam("ids") List<String> ids, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = memberReadHistoryService.delete(ids);
        return getIntefaceData(request, map, "/delete", "/member/readHistory", now, "param:::"+ids, "删除浏览记录");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "展示浏览记录", notes="会员商品浏览记录管理")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIBaseResult list(String memberId, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = memberReadHistoryService.list(memberId);
        return getIntefaceData(request, map, "/list", "/member/readHistory", now, "param:::"+memberId, "展示浏览记录");
    }
}
