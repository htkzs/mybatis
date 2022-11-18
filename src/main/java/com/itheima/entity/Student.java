package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName : Student
 * @Description : 学生实体类
 * @Author : 20609
 * @Date: 2022/11/17  15:08
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
