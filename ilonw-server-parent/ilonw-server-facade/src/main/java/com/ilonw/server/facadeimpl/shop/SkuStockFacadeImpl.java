package com.ilonw.server.facadeimpl.shop;

import com.ilonw.server.biz.shop.SkuStockService;
import com.ilonw.server.bo.shop.SkuStock;
import com.ilonw.server.facade.shop.SkuStockFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品sku库存管理facade实现类
 */
@Service("skuStockFacade")
public class SkuStockFacadeImpl implements SkuStockFacade {
    @Autowired
    private SkuStockService skuStockService;

    @Override
    public List<SkuStock> getList(Long pid, String keyword) {
        return skuStockService.getList(pid,keyword);
    }

    @Override
    public int update(Long pid, List<SkuStock> skuStockList) {
        return skuStockService.update(pid,skuStockList);
    }
}
