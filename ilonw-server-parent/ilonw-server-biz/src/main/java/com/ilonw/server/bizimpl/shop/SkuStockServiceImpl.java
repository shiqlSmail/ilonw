package com.ilonw.server.bizimpl.shop;

import com.ilonw.server.biz.shop.SkuStockService;
import com.ilonw.server.bo.shop.SkuStock;
import com.ilonw.server.bo.shop.SkuStockExample;
import com.ilonw.server.repository.shop.SkuStockDao;
import com.ilonw.server.repository.shop.SkuStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品sku库存管理service实现类
 */
@Service("skuStockService")
public class SkuStockServiceImpl implements SkuStockService {
    @Autowired
    private SkuStockMapper skuStockMapper;
    @Autowired
    private SkuStockDao skuStockDao;

    @Override
    public List<SkuStock> getList(Long pid, String keyword) {
        SkuStockExample example = new SkuStockExample();
        SkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public int update(Long pid, List<SkuStock> skuStockList) {
        return skuStockDao.replaceList(skuStockList);
    }
}
