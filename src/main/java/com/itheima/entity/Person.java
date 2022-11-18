package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName : Person
 * @Description : 复杂对象
 * @Author : 20609
 * @Date: 2022/11/18  10:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private Integer no;
    private String name;
    private Integer age;
    private Long height;
    private Address address;
}
