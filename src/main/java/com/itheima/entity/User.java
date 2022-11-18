package com.itheima.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName : User
 * @Description : 用户 开启二级缓存就必须实现序列化接口
 * @Author : 20609
 * @Date: 2022/11/14  17:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
