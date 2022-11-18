import com.itheima.entity.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.utils.sqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : StudentMapperTest
 * @Description : 测试数据库的增删改查操作
 * @Author : 20609
 * @Date: 2022/11/17  15:14
 */
public class StudentMapperTest {
    /**
    * @Param :
    * @Description :  增加  注意对于数据库的写操作需要提交会话  sqlSession.commit(); 我们可以设置自动提交
     * mybatis对数据库的写操作可以有以下返回值 Integer Long Boolean基本类型和包装类型都可以
     * Integer代表受影响的行数 Boolean代表操作是否成功 直接定义在方法上即可 无需在XML中通过 resultType指定
     *
    * @Author : 20609
    * @Date : 2022/11/17 15:28
    */

    public static void insertStudent(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student(null,"zhaoliu",23,"女");

            mapper.addStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void updateStudent(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student(2,"lisi",25,"女");
            boolean updateStudent = mapper.updateStudent(student);
            System.out.println("更新一条学生数据成功"+updateStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudent(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            boolean deleteStudent = mapper.deleteStudent(5);
            System.out.println("删除一条学生数据成功"+deleteStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    * @Param :
    * @Description :  mybatis获得插入数据的自增的主键值
    * @Author : 20609
    * @Date : 2022/11/17 15:51
    */
    public static void addStudent(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student(null,"lisi",25,"女");
            Integer insertStudent = mapper.insertStudent(student);
            System.out.println("更新一条学生数据成功"+insertStudent+"主键值为"+student.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    * @Param :
    * @Description :  测试当mybatis传递多个参数
    * @Author : 20609
    * @Date : 2022/11/17 16:38
    */

    public static void selectStudentByIdAndName(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.selectStudentByIdAndName(1, "zhangsan");
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * @Param :
    * @Description :  通过MAP传递参数
    * @Author : 20609
    * @Date : 2022/11/17 19:43
    */

    public static void selectStudentByMap(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id",1);
            map.put("name","zhangsan");
            Student student = mapper.selectByIdAndByName(map);
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    * @Param :
    * @Description :  参数传递一个列表
    * @Author : 20609
    * @Date : 2022/11/17 19:53
    */

    public static void queryStudentByIds(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(4);
            List<Student> students = mapper.selectStudentByIds(list);
            System.out.println(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    * @Param :
    * @Description :  通过 select* from student where id in (#{list[0]},#{list[1]},#{list[2]})批量查询
    * @Author : 20609
    * @Date : 2022/11/17 20:00
    */

    public static void selectStudentByIds(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(4);
            List<Student> students = mapper.queryStudentByIds(list);
            System.out.println(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Param :
     * @Description :  通过 select* from student where id in (#{list[0]},#{list[1]},#{list[2]})批量查询
     * @Author : 20609
     * @Date : 2022/11/17 20:00
     */
    public static void selectStudentByIdsForParam(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(4);
            List<Student> students = mapper.queryStudentByIdsForParam(list);
            System.out.println(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    * @Param :
    * @Description :  通过传递一个Array数组进行批量查询
    * @Author : 20609
    * @Date : 2022/11/17 20:06
    */

    public static void selectStudentByIdsForArray(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Integer[] ids = new Integer[]{1,2,4};
            List<Student> students = mapper.queryStudentByIdsForArray(ids);
            System.out.println(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    * @Param :
    * @Description :  测试mysql插入null的情况 测试结果插入没问题
    * @Author : 20609
    * @Date : 2022/11/17 20:35
    */

    public static void insertStudentNullWithMysql(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student(null,null,23,"男");
            mapper.insertStudentNullWithMysql(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Param :
     * @Description :  测试oracle插入null的情况 测试结果插入没问题
     * @Author : 20609
     * @Date : 2022/11/17 20:35
     */
    /*
    public static void insertStudentNullWithOracle(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student(null,null,23,"男");
            mapper.insertStudentNullWithOracle(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */


    public static void main(String[] args) {
        //StudentMapperTest.insertStudent();
        //StudentMapperTest.updateStudent();
        //StudentMapperTest.deleteStudent();
        //StudentMapperTest.addStudent();
        //StudentMapperTest.selectStudentByIdAndName();
        //StudentMapperTest.selectStudentByMap();
        //StudentMapperTest.queryStudentByIds();
        //StudentMapperTest.selectStudentByIds();
        //StudentMapperTest.selectStudentByIdsForParam();
        //StudentMapperTest.selectStudentByIdsForArray();
        StudentMapperTest.insertStudentNullWithMysql();
    }
}
