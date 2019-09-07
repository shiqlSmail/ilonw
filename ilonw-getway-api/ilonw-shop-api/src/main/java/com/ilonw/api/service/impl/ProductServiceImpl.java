package com.ilonw.api.service.impl;

import com.ilonw.api.base.BaseService;
import com.ilonw.api.service.ProductService;
import com.ilonw.server.bo.shop.*;
import com.ilonw.server.bto.shop.ProductParam;
import com.ilonw.server.bto.shop.ProductQueryParam;
import com.ilonw.server.bto.shop.ProductResult;
import com.ilonw.server.facade.shop.ProductFacade;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品管理Service实现类
 */
@Service("productService")
public class ProductServiceImpl extends BaseService implements ProductService {
    @Resource
    private ProductFacade productFacade;

    @Override
    public Map<String, Object> create(ProductParam productParam) {
        int count = productFacade.create(productParam);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    private void handleSkuStockCode(List<SkuStock> skuStockList, Long productId) {
        if (CollectionUtils.isEmpty(skuStockList)) return;
        for (int i = 0; i < skuStockList.size(); i++) {
            SkuStock skuStock = skuStockList.get(i);
            if (StringUtils.isEmpty(skuStock.getSkuCode())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d", productId));
                //三位索引id
                sb.append(String.format("%03d", i + 1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }

    @Override
    public Map<String, Object> getUpdateInfo(Long id) {
        ProductResult productResult = productFacade.getUpdateInfo(id);
        if (null == productResult) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productResult);
        }
    }

    @Override
    public Map<String, Object> update(Long id, ProductParam productParam) {
        int count = productFacade.update(id,productParam);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> list(ProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        List<Product> productList = productFacade.list(productQueryParam,pageSize,pageNum);
        if (null == productList || productList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productList);
        }
    }

    @Override
    public Map<String, Object> updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        int count = productFacade.updateVerifyStatus(ids,verifyStatus,detail);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> updatePublishStatus(List<Long> ids, Integer publishStatus) {
        int count = productFacade.updatePublishStatus(ids, publishStatus);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        int count = productFacade.updateRecommendStatus(ids, recommendStatus);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object>  updateNewStatus(List<Long> ids, Integer newStatus) {
        int count = productFacade.updateNewStatus(ids, newStatus);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        int count = productFacade.updateDeleteStatus(ids, deleteStatus);
        if (count == 1) {
            return getSuccessMap();
        } else {
            return getFailMap();
        }
    }

    @Override
    public Map<String, Object> list(String keyword) {
        List<Product> productList =  productFacade.list(keyword);
        if (null == productList || productList.size() == 0) {
            return getFailMap();
        } else {
            return getSuccessMapObject(productList);
        }
    }
}
