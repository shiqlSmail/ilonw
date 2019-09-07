package com.ilonw.server.bto.shop;


import com.ilonw.server.bo.shop.Product;
import com.ilonw.server.bo.shop.ProductFullReduction;
import com.ilonw.server.bo.shop.ProductLadder;
import com.ilonw.server.bo.shop.SkuStock;

import java.util.List;

/**
 * 商品的促销信息，包括sku、打折优惠、满减优惠
 */
public class PromotionProduct extends Product {
    //商品库存信息
    private List<SkuStock> skuStockList;
    //商品打折信息
    private List<ProductLadder> productLadderList;
    //商品满减信息
    private List<ProductFullReduction> productFullReductionList;

    public List<SkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<SkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<ProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<ProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<ProductFullReduction> getProductFullReductionList() {
        return productFullReductionList;
    }

    public void setProductFullReductionList(List<ProductFullReduction> productFullReductionList) {
        this.productFullReductionList = productFullReductionList;
    }
}
