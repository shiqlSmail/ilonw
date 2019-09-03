package com.ilonw.api.service;

import com.ilonw.server.bo.shop.ProductParam;
import com.ilonw.server.bo.shop.ProductQueryParam;

import java.util.List;
import java.util.Map;

/**
 * 商品管理Service
 */
public interface ProductService {
    /**
     * 创建商品
     */
    Map<String, Object> create(ProductParam productParam);

    /**
     * 根据商品编号获取更新信息
     */
    Map<String, Object> getUpdateInfo(Long id);

    /**
     * 更新商品
     */
    Map<String, Object> update(Long id, ProductParam productParam);

    /**
     * 分页查询商品
     */
    Map<String, Object> list(ProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改审核状态
     * @param ids 产品id
     * @param verifyStatus 审核状态
     * @param detail 审核详情
     */
    Map<String, Object>  updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量修改商品上架状态
     */
    Map<String, Object>  updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    Map<String, Object> updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改新品状态
     */
    Map<String, Object> updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     */
    Map<String, Object> updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     */
    Map<String, Object> list(String keyword);
}
