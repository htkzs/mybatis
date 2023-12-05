import com.itheima.entity.Address;
import com.itheima.entity.Animals;
import com.itheima.entity.Person;
import com.itheima.entity.Student;
import com.itheima.mapper.AddressMapper;
import com.itheima.mapper.AnimalsMapper;
import com.itheima.mapper.PersonMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.utils.sqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName : Junit4Test
 * @Description : 单元测试类
 * @Author : 20609
 * @Date: 2022/11/17  21:02
 */
public class Junit4Test {
    /**
    * @Param :
    * @Description :  将查询的结果map的形式返回 返回结果为{sex=男, name=zhangsan, id=1, age=23}
    * @Author : 20609
    * @Date : 2022/11/17 21:10
    */

    @Test
    public void queryStudentByResultMap(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Map<String, Object> stringObjectMap = mapper.queryStudentByResultMap(1);
            System.out.println(stringObjectMap);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }

    }
    /**
    * @Param :
    * @Description :  指定返回的map的key 返回的结果为{1=Student(id=1, name=zhangsan, age=23, sex=男)}
    * @Author : 20609
    * @Date : 2022/11/17 21:18
    */
    @Test
    public void queryStudentByResultMapWithKey(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Map<Integer, Student> integerStudentMap = mapper.queryStudentByResultMapWithKey(1);
            System.out.println(integerStudentMap);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //防止空指针异常这里增加一条判断
            assert sqlSession != null;
            sqlSession.close();
        }

    }
    @Test
    public void queryAnimalsById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            AnimalsMapper mapper = sqlSession.getMapper(AnimalsMapper.class);
            Animals animal = mapper.getAnimalsById(1);
            System.out.println(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
    /**
    * @Param :
    * @Description :  测试两表联合查询
    * @Author : 20609
    * @Date : 2022/11/18 12:38
    */
    @Test
    public void queryPersonAndAddress(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = mapper.queryPersonById(1);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
    /**
    * @Param :
    * @Description :  通过分步查询完成两表表联查
    * @Author : 20609
    * @Date : 2022/11/18 13:49
    */

    @Test
    public void queryPersonAndAddressByStep(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = mapper.queryPersonByIdWithStep(1);
            System.out.println(person.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           if(sqlSession != null){
               sqlSession.close();
           }

        }
    }
    /**
    * @Param :
    * @Description :  测试延迟加载
    * @Author : 20609
    * @Date : 2022/11/18 14:02
    */

    @Test
    public void queryPersonAndAddressByStepLazyOut(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = mapper.queryPersonByIdWithStep(1);
            System.out.println(person.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
    /**
    * @Param :
    * @Description : 测试包含List元素的封装
    * @Author : 20609
    * @Date : 2022/11/18 15:34
    */

    @Test
    public void queryAddressAndPersonPlus(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
            Address address = mapper.queryAddressByIdPlus(1);
            System.out.println(address);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
    /*
     * @Author Zhonghuan
     * @Description  测试mybatis的鉴别器
     * @Date 17:07 2022/11/18
     * @Param []
     * @return void
     **/
    @Test
    public void queryAddressByIdWithDiscriminator(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
            //如果查询的address_id为1时 由于对应的 province为 宝鸡 就返回该地址对应的person信息
            //如果查询的address_id为2时 由于对应的 province为 西安 就不返回该地址对应的person信息 而将地址信息的city和town信息设置为一样
            Address address = mapper.queryAddressByIdWithDiscriminator(2);
            System.out.println(address);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

}
