package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.HomeService;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 首页内容管理Controller
 */
@RestController
@EnableAutoConfiguration
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")
public class HomeController extends BaseController {
    @Autowired
    private HomeService homeService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "首页内容页信息展示", notes="首页内容管理")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public APIBaseResult content(HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = homeService.content();
        return getIntefaceData(request, map, "/content", "/home", now, "无参数", "首页内容页信息展示");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "分页获取推荐商品", notes="首页内容管理")
    @RequestMapping(value = "/recommendProductList", method = RequestMethod.GET)
    public APIBaseResult recommendProductList(HttpServletRequest request, @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = homeService.recommendProductList(pageSize, pageNum);
        return getIntefaceData(request, map, "/recommendProductList", "/home", now, "无参数", "分页获取推荐商品");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "获取首页商品分类", notes="首页内容管理")
    @RequestMapping(value = "/productCateList/{parentId}", method = RequestMethod.GET)
    public APIBaseResult getProductCateList(@PathVariable Long parentId, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = homeService.getProductCateList(parentId);
        return getIntefaceData(request, map, "/productCateList/{parentId}", "/home", now, "无参数", "获取首页商品分类");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "根据分类获取专题", notes="首页内容管理")
    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    public APIBaseResult getSubjectList(@RequestParam(required = false) Long cateId, HttpServletRequest request,
                                        @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = homeService.getSubjectList(cateId, pageSize, pageNum);
        return getIntefaceData(request, map, "/subjectList", "/home", now, "无参数", "根据分类获取专题");
    }
}
