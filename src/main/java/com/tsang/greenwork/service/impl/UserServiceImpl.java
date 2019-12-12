package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.LogMapper;
import com.tsang.greenwork.mapper.UserMapper;
import com.tsang.greenwork.model.User;
import com.tsang.greenwork.model.UserExample;
import com.tsang.greenwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"user"})
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;
    /**
     * 用户数量
     *
     * @return
     */
    @Override
    @Cacheable
    public int countByAll() {
        return userMapper.countByExample(new UserExample());
    }


    /**
     * 查看数据库是否有相同的mac地址 防止二次注册
     * @param phonemac
     * @return
     */
    @Override
    @Cacheable
    public int countByMac(String phonemac) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhonemacEqualTo(phonemac);
        return userMapper.countByExample(userExample);
    }

    /**
     * 检查用户密码和mac地址是否一致
     * @param telephone
     * @param password
     * @return
     */
    @Override
    @Cacheable
    public int checkTelephoneAndPasswordAndMacAddress(String telephone, String password,String phonemac) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andTelephoneEqualTo(telephone);
        criteria.andPasswordEqualTo(password);
        criteria.andPhonemacEqualTo(phonemac);
        return userMapper.countByExample(userExample);
    }


    @Override
    @Cacheable
    public int checkTelephone(String telephone) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andTelephoneEqualTo(telephone);
        return userMapper.countByExample(userExample);
    }

    /**
     * 查询是否有该用户
     * @param telephone
     * @param password
     * @return
     */
    @Override
    @Cacheable
    public int checkAccount(String telephone, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andTelephoneEqualTo(telephone);
        criteria.andPasswordEqualTo(password);
        return userMapper.countByExample(userExample);
    }


    /**
     * 检验登录信息
     * @param telephone
     * @param password
     * @return
     */
    @Override
    @Cacheable
    public User seleteByTelephoneAndPassword(String telephone, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andTelephoneEqualTo(telephone);
        criteria.andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        return users.get(0);
    }


    /**
     * 删除
     *
     * @param telephone
     * @return
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public int deleteByPrimaryKey(String telephone) {
        return userMapper.deleteByPrimaryKey(telephone);
    }

    /**
     * 增加
     *
     * @param record
     * @return
     */
    @Override
    @Cacheable
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    /**
     * 全查
     *
     * @return
     */
    @Override
    @Cacheable
    public List<User> selectByAll() {
        return userMapper.selectByAll();
    }

    /**
     * 单查
     *
     * @param telephone
     * @return
     */
    @Override
    @Cacheable
    public User selectByPrimaryKey(String telephone) {
        return userMapper.selectByPrimaryKey(telephone);
    }

    /**
     *
     * @param checked 通过审核/不通过审核/未审核
     * @return
     */
    @Override
    @Cacheable
    public List<User> selectByCheck(String checked) {
        return userMapper.selectByCheck(checked);
    }


    /**
     * 根据phonemac来选择用户
     * @param phonemac
     * @return
     */
    @Override
    @Cacheable
    public User selectByPhoneMac(String phonemac) {
        return userMapper.selectByPhonemac(phonemac);
    }


    /**
     * 根据名字查对象
     * @param username
     * @return
     */
    @Override
    @Cacheable
    public String selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    /**
     * 更新审核情况
     *
     * @param record
     * @return
     */
    @Override
    @CachePut
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 签到
     * @param telephone 传入电话号码
     * @return
     */
    @Override
    public int checkIn(String telephone) {
        return userMapper.updateCheckin(telephone);
    }



}
