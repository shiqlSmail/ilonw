package com.ilonw.server.convert;


import com.ilonw.server.bo.WxpayOrderBO;
import com.ilonw.server.bto.WxpayOrderBTO;

public class WxpayOrderConvert{

    /**
     * BTO转BO
     * @param wxpayOrderBTO
     * @return
     */
    public static WxpayOrderBO convertBTO(WxpayOrderBTO wxpayOrderBTO){
        if(null == wxpayOrderBTO){
            return null;
        }
        WxpayOrderBO wxpayOrderBO = new WxpayOrderBO();
        wxpayOrderBO.setErrCode(wxpayOrderBTO.getErrCode());
        wxpayOrderBO.setErrCodeDes(wxpayOrderBTO.getErrCodeDes());
        wxpayOrderBO.setNonceStr(wxpayOrderBTO.getNonceStr());
        wxpayOrderBO.setOutTradeNo(wxpayOrderBTO.getOutTradeNo());
        wxpayOrderBO.setPrepayId(wxpayOrderBTO.getPrepayId());
        wxpayOrderBO.setResultCode(wxpayOrderBTO.getResultCode());
        wxpayOrderBO.setReturnCode(wxpayOrderBTO.getReturnCode());
        wxpayOrderBO.setReturnMsg(wxpayOrderBTO.getReturnMsg());
        wxpayOrderBO.setSpbillCreateIp(wxpayOrderBTO.getSpbillCreateIp());
        wxpayOrderBO.setTotalFee(wxpayOrderBTO.getTotalFee());
        wxpayOrderBO.setWxpayCreatetime(wxpayOrderBTO.getWxpayCreatetime());
        wxpayOrderBO.setWxpayOrderId(wxpayOrderBTO.getWxpayOrderId());
        wxpayOrderBO.setWxpayUpdatetime(wxpayOrderBTO.getWxpayUpdatetime());
        return wxpayOrderBO;
    }

    /**
     * BO转BTO
     * @param wxpayOrderBO
     * @return
     */
    public static WxpayOrderBTO convertBO(WxpayOrderBO wxpayOrderBO){
        if(null == wxpayOrderBO){
            return null;
        }
        WxpayOrderBTO wxpayOrderBTO = new WxpayOrderBTO();
        wxpayOrderBTO.setErrCode(wxpayOrderBO.getErrCode());
        wxpayOrderBTO.setErrCodeDes(wxpayOrderBO.getErrCodeDes());
        wxpayOrderBTO.setNonceStr(wxpayOrderBO.getNonceStr());
        wxpayOrderBTO.setOutTradeNo(wxpayOrderBO.getOutTradeNo());
        wxpayOrderBTO.setPrepayId(wxpayOrderBO.getPrepayId());
        wxpayOrderBTO.setResultCode(wxpayOrderBO.getResultCode());
        wxpayOrderBTO.setReturnCode(wxpayOrderBO.getReturnCode());
        wxpayOrderBTO.setReturnMsg(wxpayOrderBO.getReturnMsg());
        wxpayOrderBTO.setSpbillCreateIp(wxpayOrderBO.getSpbillCreateIp());
        wxpayOrderBTO.setTotalFee(wxpayOrderBO.getTotalFee());
        wxpayOrderBTO.setWxpayCreatetime(wxpayOrderBO.getWxpayCreatetime());
        wxpayOrderBTO.setWxpayOrderId(wxpayOrderBO.getWxpayOrderId());
        wxpayOrderBTO.setWxpayUpdatetime(wxpayOrderBO.getWxpayUpdatetime());
        return wxpayOrderBTO;
    }
}
