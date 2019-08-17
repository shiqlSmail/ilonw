package com.ilonw.server.bizimpl.shop;

import com.ilonw.server.biz.shop.ShopLoopService;
import com.ilonw.server.bo.shop.ShopLoopBO;
import com.ilonw.server.repository.shop.ShopLoopRepository;
import com.server.tools.date.DateUtil;
import com.server.tools.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("shopLoopService")
public class ShopLoopServiceImpl implements ShopLoopService {
	@Autowired
	private ShopLoopRepository shopLoopRepository;

	/**s
	 * 首页显示商品轮播信息
	 * @return
	 */
	public List<ShopLoopBO> findLoopShop(){
		return shopLoopRepository.findLoopShop();
	}

	/**
	 * 后台管理显示商品轮播信息
	 * @return
	 */
	public List<ShopLoopBO> findAllLoopShop(){
		return shopLoopRepository.findAllLoopShop();
	}

	/**
	 * 新增首页轮播商品
	 * @param BO
	 * @return
	 */
	public boolean saveLoopShop(ShopLoopBO BO){
		BO.setLoopId(UUIDUtil.primaryKeyUUID());
		BO.setLoopCreatetime(DateUtil.getDateTime(new Date()));
		return shopLoopRepository.saveLoopShop(BO);
	}

	/**
	 * 后台修改轮播图信息
	 * @param BO
	 * @return
	 */
	public boolean updateLoopShop(ShopLoopBO BO){
		BO.setLoopUpdatetime(DateUtil.getDateTime(new Date()));
		return shopLoopRepository.updateLoopShop(BO);
	}
}
