package com.ilonw.server.facadeimpl.shop;

import com.ilonw.server.biz.shop.ShopLoopService;
import com.ilonw.server.bo.shop.ShopLoopBO;
import com.ilonw.server.facade.shop.ShopLoopFacade;
import com.ilonw.server.repository.shop.ShopLoopRepository;
import com.server.tools.date.DateUtil;
import com.server.tools.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("shopLoopFacade")
public class ShopLoopFacadeImpl implements ShopLoopFacade {
	@Autowired
	private ShopLoopService shopLoopService;

	/**s
	 * 首页显示商品轮播信息
	 * @return
	 */
	public List<ShopLoopBO> findLoopShop(){
		return shopLoopService.findLoopShop();
	}

	/**
	 * 后台管理显示商品轮播信息
	 * @return
	 */
	public List<ShopLoopBO> findAllLoopShop(){
		return shopLoopService.findAllLoopShop();
	}

	/**
	 * 新增首页轮播商品
	 * @param BO
	 * @return
	 */
	public boolean saveLoopShop(ShopLoopBO BO){
		return shopLoopService.saveLoopShop(BO);
	}

	/**
	 * 后台修改轮播图信息
	 * @param BO
	 * @return
	 */
	public boolean updateLoopShop(ShopLoopBO BO){
		return shopLoopService.updateLoopShop(BO);
	}

	@Override
	public boolean deleteLoop(ShopLoopBO BO) {
		return shopLoopService.deleteLoop(BO);
	}
}
