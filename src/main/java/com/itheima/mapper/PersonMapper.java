package com.itheima.mapper;

import com.itheima.entity.Person;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper {
    Person queryPersonById(Integer id);

    Person queryPersonByIdWithStep(@Param("id") Integer id);
}
