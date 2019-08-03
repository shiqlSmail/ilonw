package com.ilonw.server.repository;

import com.ilonw.server.bo.IlonwUserBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IlonwUserRepository {
    /**
     * 查询所有用户信息
     * @return
     */
    List<IlonwUserBO> findAllIlonwUserInfo();

    /**
     * 判断手机号码、邮箱、code是否存在
     * @param record
     * @return
     */
    Integer checkIlonwUserByPhoneAndEmailAndCodeExits(IlonwUserBO record);

    /**
     * 用户登录  根据账号密码
     * @param record
     * @return
     */
    IlonwUserBO loginIlonwUserByPhoneAndEmailAndCode(IlonwUserBO record);

    /**
     * 用户登录  根据手机号验证码
     * @param record
     * @return
     */
    IlonwUserBO loginIlonwUserByPhone(IlonwUserBO record);

    /**
     * 检查注册手机号码是否存在
     * @param record
     * @return
     */
    Integer checkIlonwUserByPhoneExits(IlonwUserBO record);

    /**
     * 检查注册邮箱是否存在
     * @param record
     * @return
     */
    Integer checkIlonwUserByEmailExits(IlonwUserBO record);

    /**
     * 检查code是否存在
     * @param record
     * @return
     */
    Integer checkIlonwUserByCodeExits(IlonwUserBO record);

    /**
     * 用户注册
     * @param record
     * @return
     */
    boolean saveIlonwUserInfo(IlonwUserBO record);

    /**
     * 忘记密码，根据手机号码进行修改
     * @param record
     * @return
     */
    Integer updateIlonwUserPassword(IlonwUserBO record);

}
