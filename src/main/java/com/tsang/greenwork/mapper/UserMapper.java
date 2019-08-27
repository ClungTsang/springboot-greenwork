package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.User;
import com.tsang.greenwork.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String telephone);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    List<User> selectByCheck(String checked);

//    List<User> selectCheckinToday(String telephone);

    String selectByUsername(String username);

    User selectByPhonemac(String phonemac);

    User selectByPrimaryKey(String telephone);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateCheckin(String telephone);

    List<User> selectByAll();
}