package com.itheima.mapper;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User getUser(@Param("userId") Integer userId);

    List<User> getAllUser();

    void deleteUserById(@Param("userId") Integer userId);
    //测试Oracle获取当前插入数据的主键id值
    void addUser(User user);
}
