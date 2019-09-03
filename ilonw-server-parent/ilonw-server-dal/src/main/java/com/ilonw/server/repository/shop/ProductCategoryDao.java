package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.shop.ProductCategoryWithChildrenItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品分类自定义Dao
 */
@Mapper
@Repository
public interface ProductCategoryDao {
    List<ProductCategoryWithChildrenItem> listWithChildren();
}
