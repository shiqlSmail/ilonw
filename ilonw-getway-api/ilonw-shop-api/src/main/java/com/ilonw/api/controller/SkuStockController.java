package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.SkuStockService;
import com.ilonw.server.bo.shop.SkuStock;
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
 * sku库存Controller
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/sku")
@Api(tags = "SkuStockController", description = "sku商品库存管理")
public class SkuStockController   extends BaseController {
    @Autowired
    private SkuStockService skuStockService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="根据商品编号及编号模糊搜索sku库存", notes="sku商品库存管理接口详细描述")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public APIBaseResult getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword, HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = skuStockService.getList(pid, keyword);
        return getIntefaceData( request,map, "/{pid}", "/product", now, "param::::"+keyword,"根据商品编号及编号模糊搜索sku库存");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value="批量更新库存信息", notes="sku商品库存管理接口详细描述")
    @RequestMapping(value ="/update/{pid}",method = RequestMethod.POST)
    public APIBaseResult update(@PathVariable Long pid, @RequestBody List<SkuStock> skuStockList, HttpServletRequest request){
        long now = System.currentTimeMillis();
        Map<String, Object> map = skuStockService.update(pid,skuStockList);
        return getIntefaceData( request,map, "/update", "/sku", now, "param::pid::"+pid+"==>skuStockList:::"+skuStockList,"批量更新库存信息");
    }
}
