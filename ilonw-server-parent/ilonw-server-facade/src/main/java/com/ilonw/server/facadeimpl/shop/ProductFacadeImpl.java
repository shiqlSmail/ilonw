package com.ilonw.server.facadeimpl.shop;

import com.ilonw.server.biz.shop.ProductService;
import com.ilonw.server.bo.shop.*;
import com.ilonw.server.bto.shop.ProductParam;
import com.ilonw.server.bto.shop.ProductQueryParam;
import com.ilonw.server.bto.shop.ProductResult;
import com.ilonw.server.facade.shop.ProductFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品管理facade实现类
 */
@Service("productFacade")
public class ProductFacadeImpl implements ProductFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductFacadeImpl.class);

    @Autowired
    private ProductService productService;

    @Override
    public int create(ProductParam productParam) {
        return productService.create(productParam);
    }

    private void handleSkuStockCode(List<SkuStock> skuStockList, Long productId) {
        /*if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i=0;i<skuStockList.size();i++){
            SkuStock skuStock = skuStockList.get(i);
            if(StringUtils.isEmpty(skuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d", productId));
                //三位索引id
                sb.append(String.format("%03d", i+1));
                skuStock.setSkuCode(sb.toString());
            }
        }*/
    }

    @Override
    public ProductResult getUpdateInfo(Long id) {
        return productService.getUpdateInfo(id);
    }

    @Override
    public int update(Long id, ProductParam productParam) {
        return productService.update(id,productParam);
    }

    @Override
    public List<Product> list(ProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        return productService.list(productQueryParam,pageSize,pageNum);
    }

    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        return productService.updateVerifyStatus(ids,verifyStatus,detail);
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return productService.updatePublishStatus(ids, publishStatus);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return productService.updateRecommendStatus(ids,recommendStatus);
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        return productService.updateNewStatus(ids,newStatus);
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return productService.updateDeleteStatus(ids,deleteStatus);
    }

    @Override
    public List<Product> list(String keyword) {
        return productService.list(keyword);
    }

    /**
     * @deprecated 旧版创建
     */
    public int createOld(ProductParam productParam) {
        return productService.create(productParam);
    }
}
