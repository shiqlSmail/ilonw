package com.ilonw.server.convert;


import com.ilonw.server.bo.OrderinfoBO;
import com.ilonw.server.bto.OrderinfoBTO;

public class OrderinfoConvert{

    /**
     * BTO转BO
     * @param orderinfoBTO
     * @return
     */
    public static OrderinfoBO convertBTO(OrderinfoBTO orderinfoBTO){
        if(null == orderinfoBTO){
            return null;
        }
        OrderinfoBO orderinfoBO = new OrderinfoBO();
        orderinfoBO.setCreatetime(orderinfoBTO.getCreatetime());
        orderinfoBO.setMoney(orderinfoBTO.getMoney());
        orderinfoBO.setOrderId(orderinfoBTO.getOrderId());
        orderinfoBO.setOrderType(orderinfoBTO.getOrderType());
        orderinfoBO.setPayState(orderinfoBTO.getPayState());
        orderinfoBO.setPayType(orderinfoBTO.getPayType());
        orderinfoBO.setUpdatetime(orderinfoBTO.getUpdatetime());
        orderinfoBO.setUserId(orderinfoBTO.getUserId());
        return orderinfoBO;
    }

    /**
     * BO转BTO
     * @param orderinfoBO
     * @return
     */
    public static OrderinfoBTO convertBO(OrderinfoBO orderinfoBO){
        if(null == orderinfoBO){
            return null;
        }
        OrderinfoBTO orderinfoBTO = new OrderinfoBTO();
        orderinfoBTO.setCreatetime(orderinfoBO.getCreatetime());
        orderinfoBTO.setMoney(orderinfoBO.getMoney());
        orderinfoBTO.setOrderId(orderinfoBO.getOrderId());
        orderinfoBTO.setOrderType(orderinfoBO.getOrderType());
        orderinfoBTO.setPayState(orderinfoBO.getPayState());
        orderinfoBTO.setPayType(orderinfoBO.getPayType());
        orderinfoBTO.setUpdatetime(orderinfoBO.getUpdatetime());
        orderinfoBTO.setUserId(orderinfoBO.getUserId());
        return orderinfoBTO;
    }

}
