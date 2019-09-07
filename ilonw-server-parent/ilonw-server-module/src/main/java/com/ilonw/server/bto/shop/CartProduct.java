package com.ilonw.server.bto.shop;

import com.ilonw.server.bo.shop.Product;
import com.ilonw.server.bo.shop.ProductAttribute;
import com.ilonw.server.bo.shop.SkuStock;

import java.util.List;

/**
 * 购物车中选择规格的商品信息
 */
public class CartProduct extends Product {
    private List<ProductAttribute> productAttributeList;
    private List<SkuStock> skuStockList;

    public List<ProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<ProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }

    public List<SkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<SkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }
}
