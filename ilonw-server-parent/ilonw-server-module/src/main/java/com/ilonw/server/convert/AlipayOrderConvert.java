package com.ilonw.server.convert;


import com.ilonw.server.bo.AlipayOrderBO;
import com.ilonw.server.bto.AlipayOrderBTO;

/**
 * 支付宝订单转换类
 * shiqilong
 */
public class AlipayOrderConvert{

    /**
     * BTO转BO
     * @param alipayOrderBTO
     * @return
     */
    public static AlipayOrderBO convertBTO(AlipayOrderBTO alipayOrderBTO){
        if(null == alipayOrderBTO){
            return null;
        }
        AlipayOrderBO alipayOrderBO = new AlipayOrderBO();
        alipayOrderBO.setAlipayOrderId(alipayOrderBTO.getAlipayOrderId());
        alipayOrderBO.setAlipayCreatetime(alipayOrderBTO.getAlipayCreatetime());
        alipayOrderBO.setAlipayUpdatetime(alipayOrderBTO.getAlipayUpdatetime());
        alipayOrderBO.setOrderId(alipayOrderBTO.getOrderId());
        alipayOrderBO.setOutTradeNo(alipayOrderBTO.getOutTradeNo());
        alipayOrderBO.setReturnBody(alipayOrderBTO.getReturnBody());
        alipayOrderBO.setTotalAmount(alipayOrderBTO.getTotalAmount());
        alipayOrderBO.setUserId(alipayOrderBTO.getUserId());
        return alipayOrderBO;
    }

    /**
     * BO转BTO
     * @param alipayOrderBO
     * @return
     */
    public static AlipayOrderBTO convertBO(AlipayOrderBO alipayOrderBO){
        if(null == alipayOrderBO){
            return null;
        }
        AlipayOrderBTO alipayOrderBTO = new AlipayOrderBTO();
        alipayOrderBTO.setAlipayOrderId(alipayOrderBO.getAlipayOrderId());
        alipayOrderBTO.setAlipayCreatetime(alipayOrderBO.getAlipayCreatetime());
        alipayOrderBTO.setAlipayUpdatetime(alipayOrderBO.getAlipayUpdatetime());
        alipayOrderBTO.setOrderId(alipayOrderBO.getOrderId());
        alipayOrderBTO.setOutTradeNo(alipayOrderBO.getOutTradeNo());
        alipayOrderBTO.setReturnBody(alipayOrderBO.getReturnBody());
        alipayOrderBTO.setTotalAmount(alipayOrderBO.getTotalAmount());
        alipayOrderBTO.setUserId(alipayOrderBO.getUserId());
        return alipayOrderBTO;
    }
}