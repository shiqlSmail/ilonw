package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.OmsPortalOrderService;
import com.ilonw.server.bto.shop.OrderParam;
import com.server.tools.result.APIBaseResult;
import com.server.tools.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 订单管理Controller
 */
@RestController
@EnableAutoConfiguration
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController  extends BaseController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "根据购物车信息生成确认单信息", notes="订单管理")
    @RequestMapping(value = "/generateConfirmOrder",method = RequestMethod.POST)
    @ResponseBody
    public APIBaseResult generateConfirmOrder(HttpServletRequest request){
        long now = System.currentTimeMillis();
        Map<String, Object> map = portalOrderService.generateConfirmOrder();
        return getIntefaceData(request, map, "/generateConfirmOrder", "/order", now, "无参数", "根据购物车信息生成确认单信息");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam){
        return portalOrderService.generateOrder(orderParam);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation("支付成功的回调")
    @RequestMapping(value = "/paySuccess",method = RequestMethod.POST)
    @ResponseBody
    public Object paySuccess(@RequestParam Long orderId){
        return portalOrderService.paySuccess(orderId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object cancelTimeOutOrder(){
        return portalOrderService.cancelTimeOutOrder();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOrder(Long orderId){
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return CommonResult.success(null);
    }
}
