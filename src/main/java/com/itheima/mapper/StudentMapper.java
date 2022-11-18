package com.itheima.mapper;

import com.itheima.entity.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @ClassName : StudentMapper
* @Description :  模拟数据库的增删改查操作
* @Author : 20609
* @Date: 2022/11/17 15:06
*/

public interface StudentMapper {
    void addStudent(Student student);
    boolean deleteStudent(Integer id);
    boolean updateStudent(Student student);
    //测试获取插入一条数据自增的主键值
    Integer insertStudent(Student student);
    //测试传递多个参数
    Student selectStudentByIdAndName(@Param("id") Integer id, @Param("name") String name);

    //参数为Map
    Student selectByIdAndByName(Map<String,Object> map);
    //传递一个列表
    List<Student> selectStudentByIds(@Param("ids") List<Integer> ids);
    // 批量查询传递一个list并且不加@Param注解
    List<Student> queryStudentByIds(List<Integer> ids);
    // 批量查询传递一个list并且增加@Param注解
    List<Student> queryStudentByIdsForParam(@Param("ids") List<Integer> list);
    //批量查询传递一个Array并且加@Param注解
    List<Student> queryStudentByIdsForArray(Integer[] ids);

    void insertStudentNullWithMysql(Student student);

//    void insertStudentNullWithOracle(Student student);
    Map<String,Object> queryStudentByResultMap(int id);

    @MapKey("id")
    Map<Integer,Student> queryStudentByResultMapWithKey(int id);
}
