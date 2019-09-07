package com.ilonw.api.controller;

import com.ilonw.api.base.BaseController;
import com.ilonw.api.service.OmsCartItemService;
import com.ilonw.api.vo.request.UserInfoParam;
import com.ilonw.server.bo.shop.OmsCartItem;
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
 * 购物车管理Controller
 */
@RestController
@EnableAutoConfiguration
@Api(tags = "OmsCartItemController", description = "购物车管理")
@RequestMapping("/cart")
public class OmsCartItemController  extends BaseController {
    @Autowired
    private OmsCartItemService cartItemService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "添加商品到购物车", notes="购物车管理")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public APIBaseResult add(@RequestBody OmsCartItem cartItem,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = cartItemService.add(cartItem);
        return getIntefaceData(request, map, "/add", "/cart", now, "param:::"+cartItem, "添加商品到购物车");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "获取某个会员的购物车列表", notes="购物车管理")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIBaseResult list(@RequestParam String memberId,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = cartItemService.list(memberId);
        return getIntefaceData(request, map, "/list", "/cart", now, "param:::"+memberId, "获取某个会员的购物车列表");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "获取某个会员的购物车列表,包括促销信息", notes="购物车管理")
    @RequestMapping(value = "/list/promotion", method = RequestMethod.GET)
    public APIBaseResult listPromotion(@RequestParam String memberId,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = cartItemService.listPromotion(memberId);
        return getIntefaceData(request, map, "/list/promotion", "/cart", now, "param:::"+memberId, "获取某个会员的购物车列表,包括促销信息");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "修改购物车中某个商品的数量", notes="购物车管理")
    @RequestMapping(value = "/update/quantity", method = RequestMethod.GET)
    public APIBaseResult updateQuantity(@RequestParam Long id,HttpServletRequest request,@RequestParam String memberId,
                                       @RequestParam Integer quantity) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = cartItemService.updateQuantity(id, memberId, quantity);
        return getIntefaceData(request, map, "/list/quantity", "/cart", now, "param:::"+id+quantity, "修改购物车中某个商品的数量");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "获取购物车中某个商品的规格,用于重选规格", notes="购物车管理")
    @RequestMapping(value = "/getProduct/{productId}", method = RequestMethod.GET)
    public APIBaseResult getCartProduct(@PathVariable Long productId,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = cartItemService.getCartProduct(productId);
        return getIntefaceData(request, map, "/getProduct/{productId}", "/cart", now, "param:::"+productId, "获取购物车中某个商品的规格,用于重选规格");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "修改购物车中商品的规格", notes="购物车管理")
    @RequestMapping(value = "/update/attr", method = RequestMethod.POST)
    public APIBaseResult updateAttr(@RequestBody OmsCartItem cartItem,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = cartItemService.updateAttr(cartItem);
        return getIntefaceData(request, map, "/update/attr", "/cart", now, "param:::"+cartItem, "修改购物车中商品的规格");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "删除购物车中的某个商品", notes="购物车管理")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIBaseResult delete(@RequestBody UserInfoParam userInfoParam,@RequestParam("ids") List<Long> ids,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = cartItemService.delete(userInfoParam.getMemberId(), ids);
        return getIntefaceData(request, map, "/delete", "/cart", now, "param:::"+ids, "删除购物车中的某个商品");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ApiOperation(value = "清空购物车", notes="购物车管理")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public APIBaseResult clear(@RequestBody UserInfoParam userInfoParam,HttpServletRequest request) {
        long now = System.currentTimeMillis();
        Map<String, Object> map = cartItemService.clear(userInfoParam.getMemberId());
        return getIntefaceData(request, map, "/clear", "/cart", now, "param:::"+userInfoParam, "清空购物车");
    }
}
