package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.ProductService;
import com.ilonw.server.bo.shop.ProductParam;
import com.ilonw.server.bo.shop.ProductQueryParam;
import com.server.tools.result.APIBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/product")
@Api(tags = "ProductController", description = "商品管理")
public class ProductController  extends BaseController {
    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="创建商品", notes="商品管理接口详细描述")
    @RequestMapping(value = "/create", produces = "application/json", method = RequestMethod.POST)
    public APIBaseResult create(@RequestBody ProductParam productParam, BindingResult bindingResult, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map= productService.create(productParam);
        return getIntefaceData( request,map, "/create", "/product", now, "param::::"+productParam,"创建商品");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="根据商品id获取商品编辑信息", notes="商品管理接口详细描述")
    @RequestMapping(value = "/updateInfo/{id}",method = RequestMethod.GET)
    public APIBaseResult getUpdateInfo(@PathVariable Long id, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productService.getUpdateInfo(id);
        return getIntefaceData( request,map, "/updateInfo", "/product", now, "param::::"+id,"根据商品id获取商品编辑信息");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="更新商品", notes="商品管理接口详细描述")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public APIBaseResult update(@PathVariable Long id, @RequestBody ProductParam productParam, BindingResult bindingResult, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productService.update(id, productParam);
        return getIntefaceData( request,map, "/update", "/product", now, "param::::"+productParam,"更新商品");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="查询商品", notes="商品管理接口详细描述")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIBaseResult getList(ProductQueryParam productQueryParam,
                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productService.list(productQueryParam, pageSize, pageNum);
        return getIntefaceData( request,map, "/list", "/product", now, "param::::"+productQueryParam,"查询商品");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="根据商品名称或货号模糊查询", notes="商品管理接口详细描述")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    public APIBaseResult getList(String keyword, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productService.list(keyword);
        return getIntefaceData( request,map, "/simpleList", "/product", now, "param::::"+keyword,"根据商品名称或货号模糊查询");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="批量修改审核状态", notes="商品管理接口详细描述")
    @RequestMapping(value = "/update/verifyStatus", method = RequestMethod.POST)
    public APIBaseResult updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                           @RequestParam("verifyStatus") Integer verifyStatus,
                                           @RequestParam("detail") String detail, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = productService.updateVerifyStatus(ids, verifyStatus, detail);
        return getIntefaceData( request,map, "/update/verifyStatus", "/product", now, "param:::ids::"+ids+"==>verifyStatus:::"+verifyStatus+"===>detail:::"+detail,"批量修改审核状态");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="批量上下架", notes="商品管理接口详细描述")
    @RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
    public APIBaseResult updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                            @RequestParam("publishStatus") Integer publishStatus, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map  = productService.updatePublishStatus(ids, publishStatus);
        return getIntefaceData( request,map, "/update/publishStatus", "/product", now, "param:::ids:::"+ids+"===>publishStatus:::"+publishStatus,"批量上下架");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="批量推荐商品", notes="商品管理接口详细描述")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    public APIBaseResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                              @RequestParam("recommendStatus") Integer recommendStatus, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map  = productService.updateRecommendStatus(ids, recommendStatus);
        return getIntefaceData( request,map, "/update/recommendStatus", "/product", now, "param::ids:::"+ids+"===>recommendStatus::::"+recommendStatus,"批量推荐商品");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="批量设为新品", notes="商品管理接口详细描述")
    @RequestMapping(value = "/update/newStatus", method = RequestMethod.POST)
    public APIBaseResult updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("newStatus") Integer newStatus, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map  = productService.updateNewStatus(ids, newStatus);
        return getIntefaceData( request,map, "/update/newStatus", "/product", now, "param:::ids::"+ids+"==>newStatus:::"+newStatus,"批量设为新品");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="批量修改删除状态", notes="商品管理接口详细描述")
    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
    public APIBaseResult updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                           @RequestParam("deleteStatus") Integer deleteStatus, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map  = productService.updateDeleteStatus(ids, deleteStatus);
        return getIntefaceData( request,map, "/update/deleteStatus", "/product", now, "param:::ids:::"+ids+"==>deleteStatus:::"+deleteStatus,"批量修改删除状态");
    }
}
