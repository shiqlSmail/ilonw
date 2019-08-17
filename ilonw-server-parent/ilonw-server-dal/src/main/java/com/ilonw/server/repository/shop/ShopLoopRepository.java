package com.ilonw.server.repository.shop;

import com.ilonw.server.bo.file.TableFileBO;
import com.ilonw.server.bo.shop.ShopLoopBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopLoopRepository {

	/**
	 * 首页显示商品轮播信息
	 * @return
	 */
	List<ShopLoopBO> findLoopShop();

	/**
	 * 后台管理显示商品轮播信息
	 * @return
	 */
	List<ShopLoopBO> findAllLoopShop();

	/**
	 * 新增首页轮播商品
	 * @param BO
	 * @return
	 */
	boolean saveLoopShop(ShopLoopBO BO);

	/**
	 * 后台修改轮播图信息
	 * @param BO
	 * @return
	 */
	boolean updateLoopShop(ShopLoopBO BO);
}
