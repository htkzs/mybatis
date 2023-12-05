package com.itheima.mapper;

import com.itheima.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    Person queryPersonById(Integer id);

    Person queryPersonByIdWithStep(@Param("id") Integer id);

    Person queryPersonByAddressId(@Param("id") Integer addressId);

    List<Person> queryPersonByArray(int[] nos);

    List<Person> queryPersonByArrayWithWhere(int[] nos);
}
