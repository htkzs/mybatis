package com.itheima.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonTo {
    private Integer no;
    private String name;
    private Integer age;
    private Long height;
}
