package com.ilonw.server.bo.shop;

import java.util.List;

/**
 * 创建和修改商品时使用的参数
 */
public class ProductParam extends Product{
    // 商品阶梯价格设置
    private List<ProductLadder> productLadderList;
     // 商品满减价格设置
    private List<ProductFullReduction> productFullReductionList;
     // 商品会员价格设置
    private List<MemberPrice> memberPriceList;
     // 商品的sku库存信息
    private List<SkuStock> skuStockList;
     // 商品参数及自定义规格属性
    private List<ProductAttributeValue> productAttributeValueList;
     // 专题和商品关系
    private List<CmsSubjectProductRelation> subjectProductRelationList;
     // 优选专区和商品的关系
    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;

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

    public List<MemberPrice> getMemberPriceList() {
        return memberPriceList;
    }

    public void setMemberPriceList(List<MemberPrice> memberPriceList) {
        this.memberPriceList = memberPriceList;
    }

    public List<SkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<SkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<ProductAttributeValue> getProductAttributeValueList() {
        return productAttributeValueList;
    }

    public void setProductAttributeValueList(List<ProductAttributeValue> productAttributeValueList) {
        this.productAttributeValueList = productAttributeValueList;
    }

    public List<CmsSubjectProductRelation> getSubjectProductRelationList() {
        return subjectProductRelationList;
    }

    public void setSubjectProductRelationList(List<CmsSubjectProductRelation> subjectProductRelationList) {
        this.subjectProductRelationList = subjectProductRelationList;
    }

    public List<CmsPrefrenceAreaProductRelation> getPrefrenceAreaProductRelationList() {
        return prefrenceAreaProductRelationList;
    }

    public void setPrefrenceAreaProductRelationList(List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList) {
        this.prefrenceAreaProductRelationList = prefrenceAreaProductRelationList;
    }
}
