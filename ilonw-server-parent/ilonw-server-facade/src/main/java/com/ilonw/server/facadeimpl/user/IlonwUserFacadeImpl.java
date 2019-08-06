package com.ilonw.server.facadeimpl.user;

import com.ilonw.server.facade.user.IlonwUserFacade;
import com.ilonw.server.biz.user.IlonwUserService;
import com.ilonw.server.bo.IlonwUserBO;
import com.ilonw.server.bto.IlonwUserBTO;
import com.ilonw.server.convert.IlonwUserConvert;
import com.ilonw.server.page.PageBean;
import com.ilonw.server.page.PageConvert;
import com.ilonw.server.page.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("ilonwUserFacade")
public class IlonwUserFacadeImpl implements IlonwUserFacade {

    @Autowired
    private IlonwUserService ilonwUserService;

    public PageBean<IlonwUserBTO> findAllIlonwUserInfo(PageData pageData){
        List<IlonwUserBTO> listBTO = new ArrayList<>();
        PageBean<IlonwUserBO> listBO =  ilonwUserService.findAllIlonwUserInfo(pageData);
        for(IlonwUserBO bto : listBO.getItems()){
            listBTO.add(IlonwUserConvert.convertBO(bto));
        }
        return PageConvert.getPageBean(listBO,listBTO);
    }

    public Map<String,Object> loginIlonwUserByPhoneAndEmailAndCode(IlonwUserBTO record){
        return ilonwUserService.loginIlonwUserByPhoneAndEmailAndCode(IlonwUserConvert.convertBTO(record));
    }

    //用户登录  根据手机号验证码
    public Map<String,Object> loginIlonwUserByPhone(IlonwUserBTO record,String ip){
        return ilonwUserService.loginIlonwUserByPhone(IlonwUserConvert.convertBTO(record),ip);
    }

    //检查注册手机号码是否存在
    public Map<String,Object> checkIlonwUserByPhoneExits(IlonwUserBTO param){
        return ilonwUserService.checkIlonwUserByPhoneExits(IlonwUserConvert.convertBTO(param));
    }

    //检查注册邮箱是否存在
    public Map<String,Object> checkIlonwUserByEmailExits(IlonwUserBTO param){
        return ilonwUserService.checkIlonwUserByEmailExits(IlonwUserConvert.convertBTO(param));
    }

    //用户注册
    public boolean saveIlonwUserInfo(IlonwUserBTO param){
        return ilonwUserService.saveIlonwUserInfo(IlonwUserConvert.convertBTO(param));
    }

    //忘记密码，根据手机号码进行修改
    public Map<String,Object> updateIlonwUserPassword(IlonwUserBTO param){
        return ilonwUserService.updateIlonwUserPassword(IlonwUserConvert.convertBTO(param));
    }

}
