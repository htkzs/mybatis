package com.itheima.mapper;

import com.itheima.entity.Person;
import com.itheima.to.PersonTo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @project
 * @description 测试动态SQL
 * @author 66
 * @date 2022/11/18 17:42:34
 * @version 1.0
 */
public interface DynamicSqlMapper {
     List<Person> queryPersonByCondition(PersonTo person);

     List<Person> queryPersonByConditionByTrim(PersonTo person);

     List<Person> queryPersonByConditionByChoose(PersonTo person);

     void updatePersonByConditionBySet(PersonTo person);

     List<Person> queryPersonWithBatchByIds(@Param("ids") List<Integer> ids);

     List<Person> queryPersonWithBatchByIdsForeach(List<Integer> ids);

     List<Person> queryPersonWithBatchByIdsForeachTransformMap(@Param("map") Map<String, Object> map);
}
