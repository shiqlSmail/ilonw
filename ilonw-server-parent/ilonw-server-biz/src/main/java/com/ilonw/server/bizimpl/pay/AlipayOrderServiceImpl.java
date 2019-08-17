package com.ilonw.server.bizimpl.pay;

import com.ilonw.server.biz.pay.AlipayOrderService;
import com.ilonw.server.bo.pay.AlipayOrderBO;
import com.ilonw.server.repository.pay.AlipayOrderRepository;
import com.server.tools.exceptions.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付宝支付处理器实现
 * shiqilong
 */
@Service("alipayOrderService")
public class AlipayOrderServiceImpl implements AlipayOrderService {

	@Autowired
	private AlipayOrderRepository alipayOrderMapper;

	/**
	 * 保存支付宝订单信息
	 * @param alipayOrderBO
	 * @return
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Throwable.class})
	public void add(AlipayOrderBO alipayOrderBO) {
		int count = alipayOrderMapper.insertSelective(alipayOrderBO);
		if (count == 0) {
			throw new BizException("【add AlipayOrder fail】");
		}
	}

	/**
	 * 更新支付宝订单信息
	 * @param alipayOrderBO
	 * @return
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Throwable.class})
	public void update(AlipayOrderBO alipayOrderBO) {
		int count = alipayOrderMapper.updateByPrimaryKeySelective(alipayOrderBO);
		if (count == 0) {
			throw new BizException("【update AlipayOrder fail】");
		}
	}

	/**
	 * 根据订单号查询支付宝订单信息
	 * @param outtradeno
	 * @return
	 */
	@Override
	public AlipayOrderBO queryByOuttradeno(String outtradeno) {
		AlipayOrderBO param = new AlipayOrderBO();
		param.setOutTradeNo(outtradeno);
		return alipayOrderMapper.selectByExample(param);
	}

}
