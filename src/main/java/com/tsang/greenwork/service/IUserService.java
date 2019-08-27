package com.tsang.greenwork.service;

import com.tsang.greenwork.model.User;

import java.util.List;

public interface IUserService {

    /**
     * 增加
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据id删除
     * @param telephone
     * @return
     */
    int deleteByPrimaryKey(String telephone);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 用户数量
     * @return
     */
    int countByAll();

    /**
     * 检验是否有相同的mac地址
     * @return
     */
    int countByMac(String phonemac);


    /**
     * 检查电话号码和密码和mac地址
     * @param telephone
     * @param password
     * @return
     */
    int checkTelephoneAndPasswordAndMacAddress(String telephone, String password, String phonemac);



    /**
     * 全查
     * @return User集合
     */
    List<User> selectByAll();


    /**
     * 根据电话单查对象
     * @param telephone
     * @return User集合
     */
    User selectByPrimaryKey(String telephone);

    /**
     * 查看审核情况
     * @param checked 通过审核/不通过审核/未审核
     * @return User集合
     */
    List<User> selectByCheck(String checked);




    /**
     * 通过phonemac验证登录信息
     * @param phonemac 手机phonemac
     * @return user对象
     */
    User selectByPhoneMac(String phonemac);

    /**
     * 检查用户是否存在
     *
     * @param telephone 电话号码
     * @param password 密码
     * @return
     */
    int checkAccount(String telephone, String password);


    /**
     * 根据手机号查询数量
     * @param telephone 电话号码
     * @return
     */
    int checkTelephone(String telephone);

    /**
     *根据电话号码和密码 得到用用户信息
     * @param account 账户
      * @param password 密码
     * @return
     */
    User seleteByTelephoneAndPassword(String account, String password);

    /**
     * 签到+1
     * @param telephone 电话号码
     * @return
     */
    int checkIn(String telephone);



    /**
     *根据名字查名字
     * @param username 姓名
     * @return
     */
    String selectByUsername(String username);
}
