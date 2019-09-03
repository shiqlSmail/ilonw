package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.SkuStockService;
import com.ilonw.server.bo.shop.SkuStock;
import com.ilonw.server.facade.shop.SkuStockFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品sku库存管理Service实现类
 */
@Service("skuStockService")
public class SkuStockServiceImpl  extends BaseService implements SkuStockService {
    @Resource
    private SkuStockFacade skuStockFacade;

    @Override
    public Map<String, Object> getList(Long pid, String keyword) {
        List<SkuStock> skuStockList = skuStockFacade.getList(pid,keyword);
        if (null == skuStockList || skuStockList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(skuStockList);
        }
    }

    @Override
    public Map<String, Object> update(Long pid, List<SkuStock> skuStockList) {
        int count = skuStockFacade.update(pid,skuStockList);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }
}
