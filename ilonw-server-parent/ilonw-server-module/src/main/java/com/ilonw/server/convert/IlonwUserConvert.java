package com.ilonw.server.convert;


import com.ilonw.server.bo.user.IlonwUserBO;
import com.ilonw.server.bto.IlonwUserBTO;

/**
 * 支付宝订单转换类
 * shiqilong
 */
public class IlonwUserConvert {

    /**
     * BTO转BO
     * @param ilonwUserBTO
     * @return
     */
    public static IlonwUserBO convertBTO(IlonwUserBTO ilonwUserBTO){
        if(null == ilonwUserBTO){
            return null;
        }
        IlonwUserBO userBO = new IlonwUserBO();
        userBO.setIlonwUserAddress(ilonwUserBTO.getIlonwUserAddress());
        userBO.setIlonwUserAge(ilonwUserBTO.getIlonwUserAge());
        userBO.setIlonwUserBrithday(ilonwUserBTO.getIlonwUserBrithday());
        userBO.setIlonwUserCode(ilonwUserBTO.getIlonwUserCode());
        userBO.setIlonwUserCreatetime(ilonwUserBTO.getIlonwUserCreatetime());
        userBO.setIlonwUserEmail(ilonwUserBTO.getIlonwUserEmail());
        userBO.setIlonwUserId(ilonwUserBTO.getIlonwUserId());
        userBO.setIlonwUserImage(ilonwUserBTO.getIlonwUserImage());
        userBO.setIlonwUserIp(ilonwUserBTO.getIlonwUserIp());
        userBO.setIlonwUserName(ilonwUserBTO.getIlonwUserName());
        userBO.setIlonwUserNikename(ilonwUserBTO.getIlonwUserNikename());
        userBO.setIlonwUserPassword(ilonwUserBTO.getIlonwUserPassword());
        userBO.setIlonwUserPhone(ilonwUserBTO.getIlonwUserPhone());
        userBO.setIlonwUserSex(ilonwUserBTO.getIlonwUserSex());
        userBO.setIlonwUserStatus(ilonwUserBTO.getIlonwUserStatus());
        return userBO;
    }

    /**
     * BO转BTO
     * @param userBO
     * @return
     */
    public static IlonwUserBTO convertBO(IlonwUserBO userBO){
        if(null == userBO){
            return null;
        }
        IlonwUserBTO userBTO = new IlonwUserBTO();
        userBTO.setIlonwUserAddress(userBO.getIlonwUserAddress());
        userBTO.setIlonwUserAge(userBO.getIlonwUserAge());
        userBTO.setIlonwUserBrithday(userBO.getIlonwUserBrithday());
        userBTO.setIlonwUserCode(userBO.getIlonwUserCode());
        userBTO.setIlonwUserCreatetime(userBO.getIlonwUserCreatetime());
        userBTO.setIlonwUserEmail(userBO.getIlonwUserEmail());
        userBTO.setIlonwUserId(userBO.getIlonwUserId());
        userBTO.setIlonwUserImage(userBO.getIlonwUserImage());
        userBTO.setIlonwUserIp(userBO.getIlonwUserIp());
        userBTO.setIlonwUserName(userBO.getIlonwUserName());
        userBTO.setIlonwUserNikename(userBO.getIlonwUserNikename());
        userBTO.setIlonwUserPassword(userBO.getIlonwUserPassword());
        userBTO.setIlonwUserPhone(userBO.getIlonwUserPhone());
        userBTO.setIlonwUserSex(userBO.getIlonwUserSex());
        userBTO.setIlonwUserStatus(userBO.getIlonwUserStatus());
        return userBTO;
    }
}