package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.ProductCategoryService;
import com.ilonw.server.bo.shop.ProductCategoryParam;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 商品分类模块Controller
 */
@Controller
@Api(tags = "ProductCategoryController", description = "商品分类管理")
@RequestMapping("/productCategory")
public class ProductCategoryController   extends BaseController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="添加产品分类", notes="商品分类管理接口详细描述")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public APIBaseResult create(@Validated @RequestBody ProductCategoryParam productCategoryParam,
                                BindingResult result, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productCategoryService.create(productCategoryParam);
        return getIntefaceData( request,map, "/create", "/productCategory", now, "param::::"+productCategoryParam,"添加产品分类");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="修改商品分类", notes="商品分类管理接口详细描述")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public APIBaseResult update(@PathVariable Long id,
                         @Validated @RequestBody ProductCategoryParam productCategoryParam,
                         BindingResult result, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productCategoryService.update(id, productCategoryParam);
        return getIntefaceData( request,map, "/update/{id}", "/productCategory", now, "param::::"+productCategoryParam,"修改商品分类");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="分页查询商品分类", notes="商品分类管理接口详细描述")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    public APIBaseResult getList(@PathVariable Long parentId, HttpServletRequest request,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productCategoryService.getList(parentId, pageSize, pageNum);
        return getIntefaceData( request,map, "/list/{parentId}", "/productCategory", now, "param::::"+parentId,"分页查询商品分类");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="根据id获取商品分类", notes="商品分类管理接口详细描述")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public APIBaseResult getItem(@PathVariable Long id, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productCategoryService.getItem(id);
        return getIntefaceData( request,map, "/{id}", "/productCategory", now, "param::::"+id,"根据id获取商品分类");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="删除商品分类", notes="商品分类管理接口详细描述")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public APIBaseResult delete(@PathVariable Long id, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productCategoryService.delete(id);
        return getIntefaceData( request,map, "/delete/{id}", "/productCategory", now, "param::::"+id,"删除商品分类");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="修改导航栏显示状态", notes="商品分类管理接口详细描述")
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    public APIBaseResult updateNavStatus(@RequestParam("ids") List<Long> ids, @RequestParam("navStatus") Integer navStatus, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productCategoryService.updateNavStatus(ids, navStatus);
        return getIntefaceData( request,map, "/update/navStatus", "/productCategory", now, "param::::"+ids,"修改导航栏显示状态");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="修改显示状态", notes="商品分类管理接口详细描述")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    public APIBaseResult updateShowStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map  = productCategoryService.updateShowStatus(ids, showStatus);
        return getIntefaceData( request,map, "/update/showStatus", "/productCategory", now, "param::::"+ids,"修改显示状态");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="查询所有一级分类及子分类", notes="商品分类管理接口详细描述")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    public APIBaseResult listWithChildren(HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productCategoryService.listWithChildren();
        return getIntefaceData( request,map, "/list/withChildren", "/productCategory", now, "无参数","查询所有一级分类及子分类");
    }
}
