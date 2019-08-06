package com.ilonw.server.bizimpl.pay;

import com.ilonw.server.biz.pay.WxPayOrderService;
import com.ilonw.server.bo.WxpayOrderBO;
import com.ilonw.server.repository.pay.WxpayOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 微信支付处理器实现
 */
@Service("wxPayOrderService")
public class WxPayOrderServiceImpl implements WxPayOrderService {
	@Autowired
    private WxpayOrderRepository wxpayOrderMapper;

	/**
	 * 保存微信订单信息
	 * @param wxpayOrderBO
	 * @return
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Throwable.class})
	public void add(WxpayOrderBO wxpayOrderBO) {
		wxpayOrderMapper.insertSelective(wxpayOrderBO);
	}

	/**
	 * 更新微信订单信息
	 * @param wxpayOrderBO
	 * @return
	 */
    @Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Throwable.class})
	public void update(WxpayOrderBO wxpayOrderBO) {
		wxpayOrderMapper.updateByPrimaryKeySelective(wxpayOrderBO);
	}

	/**
	 * 查看微信订单信息
	 * @param outtradeno
	 * @return
	 */
    @Override
	public WxpayOrderBO queryByOuttradeno(String outtradeno) {
		WxpayOrderBO param = new WxpayOrderBO();
		param.setOutTradeNo(outtradeno);
		return wxpayOrderMapper.selectByExample(param);
	}
}
