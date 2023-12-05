package com.itheima.entity;

import lombok.*;

/**
 * @ClassName Animal
 * @Description TODO
 * @Author 20609
 * @Date 2023/12/4 15:09
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class Animal {
    private Integer id;
    private String nickName;
    private String actualName;
    private Integer age;
}
