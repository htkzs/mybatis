package com.itheima.mapper;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
* @ClassName : UserMapperAnnotation
* @Description :  通过注解方式编写SQL
* @Author : 20609
* @Date: 2022/11/17 11:18
*/

public interface UserMapperAnnotation {
    /*
    当使用注解方式的时候 可以通过接口指定<mapper class="com.itheima.mapper.UserMapper"/> SQL语句写在接口中
     */
    @Select("select* from user where id = #{userId}")
    User getUser(@Param("userId") Integer userId);
}
