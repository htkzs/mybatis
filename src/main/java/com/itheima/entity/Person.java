package com.itheima.entity;

import lombok.*;

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
@Setter @Getter
public class Person {
    private Integer no;
    private String name;
    private Integer age;
    private Long height;
    private Address address;

    public Person(Integer no, String name, Integer age, Long height) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
