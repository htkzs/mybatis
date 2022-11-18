package com.itheima.mapper;

import com.itheima.entity.Address;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {

    Address queryAddressById(Integer addressId);
    //查询一个地址中的所有人 封装在Address的List<Person>
    Address queryAddressByIdPlus(@Param("addressId") Integer addressId);

    Address queryAddressByIdWithDiscriminator(@Param("addressId") Integer addressId);
}
