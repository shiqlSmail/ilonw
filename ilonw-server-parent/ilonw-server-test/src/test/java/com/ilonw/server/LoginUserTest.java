/*
package com.ilonw.server;

import com.ilonw.server.bto.IlonwUserBTO;
import com.ilonw.server.facade.user.IlonwUserFacade;
import com.server.tools.encryption.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(classes=IlonwServerCoreDubboApplication.class)
public class LoginUserTest {
    @Resource
    public IlonwUserFacade ilonwUserFacade;

    @Test
    public void test1(){
        IlonwUserBTO record = new IlonwUserBTO();
        */
/*List<IlonwUserBTO> map = ilonwUserFacade.findAllIlonwUserInfo();
        System.out.println("查询所有用户"+map);*//*

    }

    @Test
    public void test2(){
        IlonwUserBTO record = new IlonwUserBTO();
        record.setIlonwUserPhone("17621663876");
        Map<String,Object> map = ilonwUserFacade.loginIlonwUserByPhone(record,"127.0.0.1");
        System.out.println("根据验证码登录"+map);
    }

    @Test
    public void test3(){
        IlonwUserBTO record = new IlonwUserBTO();
        record.setIlonwUserPhone("17621663876");
        record.setIlonwUserPassword(MD5Util.MD5Encode("admin","UTF-8"));
        Map<String,Object> map = ilonwUserFacade.loginIlonwUserByPhoneAndEmailAndCode(record);
        System.out.println("根据密码登录"+map);
    }

    @Test
    public void test4(){
        IlonwUserBTO record = new IlonwUserBTO();
        record.setIlonwUserPhone("17621663876");
        Map<String,Object> map = ilonwUserFacade.checkIlonwUserByPhoneExits(record);
        System.out.println("检查注册手机号码是否存在"+map);
    }

}
*/
