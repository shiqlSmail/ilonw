package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.MemberCollectionService;
import com.ilonw.server.bo.shop.MemberProductCollection;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 会员收藏管理Controller
 */
@RestController
@EnableAutoConfiguration
@Api(tags = "MemberCollectionController", description = "会员收藏管理")
@RequestMapping("/member/collection")
public class MemberCollectionController  extends BaseController {
    @Autowired
    private MemberCollectionService memberCollectionService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "添加商品收藏", notes="会员收藏管理")
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public APIBaseResult addProduct(@RequestBody MemberProductCollection productCollection, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map =  memberCollectionService.addProduct(productCollection);
        return getIntefaceData(request, map, "/addProduct", "/member/collection", now, "param:::"+productCollection, "添加商品收藏");
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "删除收藏商品", notes="会员收藏管理")
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public APIBaseResult deleteProduct(String memberId, Long productId,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map =  memberCollectionService.deleteProduct(memberId, productId);
        return getIntefaceData(request, map, "/deleteProduct", "/member/collection", now, "param:::"+memberId, "删除收藏商品");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "显示关注列表", notes="会员收藏管理")
    @RequestMapping(value = "/listProduct/{memberId}", method = RequestMethod.GET)
    public APIBaseResult listProduct(@PathVariable String memberId,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map  = memberCollectionService.listProduct(memberId);
        return getIntefaceData(request, map, "/listProduct", "/member/collection", now, "param:::"+memberId, "显示关注列表");
    }
}
