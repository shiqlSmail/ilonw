package com.ilonw.server.bizimpl.user;

import com.github.pagehelper.PageHelper;
import com.ilonw.server.Eunms.UserEunms;
import com.ilonw.server.biz.user.IlonwUserService;
import com.ilonw.server.bo.user.IlonwUserBO;
import com.ilonw.server.page.PageBean;
import com.ilonw.server.page.PageConvert;
import com.ilonw.server.page.PageData;
import com.ilonw.server.repository.user.IlonwUserRepository;
import com.server.tools.encryption.MD5Util;
import com.server.tools.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ilonwUserService")
public class IlonwUserServiceImpl implements IlonwUserService {

    @Autowired
    private IlonwUserRepository ilonwUserRepository;

    @Override
    public PageBean<IlonwUserBO> findAllIlonwUserInfo(PageData pageData) {
        PageBean<IlonwUserBO> page = new PageBean<IlonwUserBO>();
        if (null != pageData.getCurrentPage()) {
            page.setCurrentPage(pageData.getCurrentPage());
        }
        if (null != pageData.getPageSize()) {
            page.setPageSize(pageData.getPageSize());
        }

        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<IlonwUserBO> listUser = ilonwUserRepository.findAllIlonwUserInfo();
        Integer countUser = ilonwUserRepository.countAllIlonwUserInfo();

        //返回数据，这样返回才会有分页的参数
        return PageConvert.getDataPages(page,listUser,countUser);
    }

    /**
     * 用户登录  根据账号密码
     *
     * @param record
     * @return
     */
    public Map<String, Object> loginIlonwUserByPhoneAndEmailAndCode(IlonwUserBO record) {
        Map<String, Object> map = new HashMap<String, Object>();
        //先判断手机号码、邮箱、code是否存在
        Integer phoneAndEmailAndCodeIsExits = ilonwUserRepository.checkIlonwUserByPhoneAndEmailAndCodeExits(record);

        if (phoneAndEmailAndCodeIsExits.equals(0)) {
            map.put("resCode", UserEunms.LOGIN_CODE_NOTEXITS.getResCode());
            map.put("resMsg", UserEunms.LOGIN_CODE_NOTEXITS.getResMsg());
            return map;
        }

        IlonwUserBO ilonwUser = ilonwUserRepository.loginIlonwUserByPhoneAndEmailAndCode(record);
        if (StringUtils.isEmpty(ilonwUser)) {
            map.put("resCode", UserEunms.PASSWORD_FAIL.getResCode());
            map.put("resMsg", UserEunms.PASSWORD_FAIL.getResMsg());
            return map;
        }
        map.put("resCode", UserEunms.SUCCESS.getResCode());
        map.put("resMsg", UserEunms.SUCCESS.getResMsg());
        map.put("data", ilonwUser);
        return map;
    }

    /**
     * 用户登录  根据手机号验证码
     *
     * @param record
     * @param ip
     * @return
     */
    public Map<String, Object> loginIlonwUserByPhone(IlonwUserBO record, String ip) {
        Map<String, Object> map = new HashMap<String, Object>();
        //先判断手机号码是否存在
        Integer phoneAndEmailAndCodeIsExits = ilonwUserRepository.checkIlonwUserByPhoneExits(record);
        if (null == phoneAndEmailAndCodeIsExits || phoneAndEmailAndCodeIsExits == 0) {
            String codes = UUIDUtil.userCode(7);
            //如果手机号不存在，调用注册接口
            IlonwUserBO records = new IlonwUserBO();
            records.setIlonwUserPhone(record.getIlonwUserPhone());
            records.setIlonwUserIp(ip);
            Integer flag = ilonwUserRepository.checkIlonwUserByCodeExits(records);
            if (flag.equals(0)) {
                records.setIlonwUserCode(codes);
            } else {
                records.setIlonwUserCode(codes + UUIDUtil.userCode(2));
            }
            records.setIlonwUserId(UUIDUtil.primaryKeyUUID());
            records.setIlonwUserStatus(1);
            records.setIlonwUserCreatetime(new Date());
            ilonwUserRepository.saveIlonwUserInfo(records);
        }
        IlonwUserBO ilonwUser = ilonwUserRepository.loginIlonwUserByPhone(record);
        if (null == ilonwUser) {
            map.put("resCode", UserEunms.USER_NULL.getResCode());
            map.put("resMsg", UserEunms.USER_NULL.getResMsg());
        } else {
            map.put("resCode", UserEunms.SUCCESS.getResCode());
            map.put("resMsg", UserEunms.SUCCESS.getResMsg());
            map.put("data", ilonwUser);
        }
        return map;
    }

    /**
     * 检查注册手机号码是否存在
     *
     * @param param
     * @return
     */
    public Map<String, Object> checkIlonwUserByPhoneExits(IlonwUserBO param) {
        Map<String, Object> map = new HashMap<String, Object>();

        Integer num = ilonwUserRepository.checkIlonwUserByPhoneExits(param);
        if (num == 0) {
            map.put("resCode", UserEunms.SUCCESS.getResCode());
            map.put("resMsg", UserEunms.SUCCESS.getResMsg());
            map.put("data", num);
        } else {
            map.put("resCode", UserEunms.PHONE_NOTNULL.getResCode());
            map.put("resMsg", UserEunms.PHONE_NOTNULL.getResMsg());
        }
        return map;
    }

    /**
     * 检查注册邮箱是否存在
     *
     * @param param
     * @return
     */
    public Map<String, Object> checkIlonwUserByEmailExits(IlonwUserBO param) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer num = ilonwUserRepository.checkIlonwUserByEmailExits(param);
        if (num == 0) {
            map.put("resCode", UserEunms.SUCCESS.getResCode());
            map.put("resMsg", UserEunms.SUCCESS.getResMsg());
            map.put("data", num);
        } else {
            map.put("resCode", UserEunms.EMAIL_NOTNULL.getResCode());
            map.put("resMsg", UserEunms.EMAIL_NOTNULL.getResMsg());
        }
        return map;
    }

    /**
     * 用户注册
     *
     * @param record
     * @return
     */
    public boolean saveIlonwUserInfo(IlonwUserBO record) {
        String codes = UUIDUtil.userCode(7);
        Integer flag = ilonwUserRepository.checkIlonwUserByCodeExits(record);
        if (flag.equals(0)) {
            record.setIlonwUserCode(codes);
        } else {
            record.setIlonwUserCode(codes + UUIDUtil.userCode(2));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Integer ages = Integer.valueOf(sdf.format(new Date())) - Integer.valueOf(record.getIlonwUserBrithday().substring(0, 4));
        record.setIlonwUserAge(ages);
        record.setIlonwUserId(UUIDUtil.primaryKeyUUID());
        record.setIlonwUserStatus(1);
        record.setIlonwUserCreatetime(new Date());
        record.setIlonwUserPassword(MD5Util.MD5Encode(record.getIlonwUserPassword(), "UTF-8"));
        return ilonwUserRepository.saveIlonwUserInfo(record);
    }

    /**
     * 忘记密码，根据手机号码进行修改
     *
     * @param param
     * @return
     */
    public Map<String, Object> updateIlonwUserPassword(IlonwUserBO param) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer num = ilonwUserRepository.updateIlonwUserPassword(param);
        if (num > 0) {
            map.put("resCode", UserEunms.SUCCESS.getResCode());
            map.put("resMsg", UserEunms.SUCCESS.getResMsg());
            map.put("data", num);
        } else {
            map.put("resCode", UserEunms.PASSWORD_UPDATE_FAIL.getResCode());
            map.put("resMsg", UserEunms.PASSWORD_UPDATE_FAIL.getResMsg());
        }
        return map;
    }

}
