package com.ilonw.api.service.impl;

import com.ilonw.api.service.AlipayOrderService;
import com.ilonw.server.bto.AlipayOrderBTO;
import com.ilonw.server.facade.pay.AlipayOrderFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 支付宝支付处理器实现
 * shiqilong
 */
@Service
public class AlipayOrderServiceImpl implements AlipayOrderService {

	@Resource
	private AlipayOrderFacade alipayOrderFacade;

	@Override
	public void add(AlipayOrderBTO alipayOrderBTO) {
		alipayOrderFacade.add(alipayOrderBTO);
	}

	@Override
	public void update(AlipayOrderBTO alipayOrderBTO) {
		alipayOrderFacade.update(alipayOrderBTO);
	}

	@Override
	public AlipayOrderBTO queryByOuttradeno(String outtradeno) {
		return alipayOrderFacade.queryByOuttradeno(outtradeno);
	}

}
