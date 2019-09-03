package com.ilonw.server.facade.shop;

import com.ilonw.server.bo.shop.Product;
import com.ilonw.server.bo.shop.ProductParam;
import com.ilonw.server.bo.shop.ProductQueryParam;
import com.ilonw.server.bo.shop.ProductResult;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品管理facade
 */
public interface ProductFacade {
    /**
     * 创建商品
     */
    public int create(ProductParam productParam);

    /**
     * 根据商品编号获取更新信息
     */
    public ProductResult getUpdateInfo(Long id);

    /**
     * 更新商品
     */
    public int update(Long id, ProductParam productParam);

    /**
     * 分页查询商品
     */
    public List<Product> list(ProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改审核状态
     * @param ids 产品id
     * @param verifyStatus 审核状态
     * @param detail 审核详情
     */
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量修改商品上架状态
     */
    public int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改新品状态
     */
    public int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     */
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     */
    public List<Product> list(String keyword);
}
