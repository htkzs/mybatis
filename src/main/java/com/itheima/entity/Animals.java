package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName : Animals
 * @Description : 动物实体类
 * @Author : 20609
 * @Date: 2022/11/18  10:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Animals {
    private Integer id;
    private String nickName;
    private String actualName;
    private Integer age;
}
