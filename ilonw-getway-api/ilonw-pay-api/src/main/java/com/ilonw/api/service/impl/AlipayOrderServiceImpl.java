package com.ilonw.api.service.impl;

import com.ilonw.api.service.AlipayOrderService;
import com.ilonw.server.facade.pay.AlipayOrderFacade;
import com.ilonw.server.bto.AlipayOrderBTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付宝支付处理器实现
 * shiqilong
 */
@Service
public class AlipayOrderServiceImpl implements AlipayOrderService {

	@Autowired(required = false)
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
