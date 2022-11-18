package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName : Address
 * @Description : 地址信息
 * @Author : 20609
 * @Date: 2022/11/18  10:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private Integer addressId;
    private String province;
    private String city;
    private String town;

    //该地址下包含的所有人的信息
    private List<Person> persons;
}
