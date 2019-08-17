package com.ilonw.server.facadeimpl.pay;

import com.ilonw.server.facade.pay.AlipayOrderFacade;
import com.ilonw.server.biz.pay.AlipayOrderService;
import com.ilonw.server.bo.pay.AlipayOrderBO;
import com.ilonw.server.bto.AlipayOrderBTO;
import com.ilonw.server.convert.AlipayOrderConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付宝支付处理器实现
 * shiqilong
 */
@Service("alipayOrderFacade")
public class AlipayOrderFacadeImpl implements AlipayOrderFacade {

	@Autowired
	private AlipayOrderService alipayOrderService;

	@Override
	public void add(AlipayOrderBTO alipayOrderBTO) {
		AlipayOrderBO bo = AlipayOrderConvert.convertBTO(alipayOrderBTO);
		alipayOrderService.add(bo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Throwable.class})
	public void update(AlipayOrderBTO alipayOrderBTO) {
		AlipayOrderBO bo = AlipayOrderConvert.convertBTO(alipayOrderBTO);
		alipayOrderService.update(bo);
	}

	@Override
	public AlipayOrderBTO queryByOuttradeno(String outtradeno) {
		AlipayOrderBO bo = alipayOrderService.queryByOuttradeno(outtradeno);
		return AlipayOrderConvert.convertBO(bo);
	}
}
