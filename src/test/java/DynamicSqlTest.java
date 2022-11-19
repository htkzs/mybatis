import com.itheima.entity.Address;
import com.itheima.entity.Person;
import com.itheima.mapper.DynamicSqlMapper;
import com.itheima.to.PersonTo;
import com.itheima.utils.sqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicSqlTest {
    /*
     * @Author Zhonghuan
     * @Description 测试if判断
     * @Date 19:18:28 2022/11/18
     * @Param []
     * @return void
     **/
    @Test
    public void queryPersonByCondition(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            PersonTo person = new PersonTo(1,"%z%",23,175L);
            List<Person> condition = mapper.queryPersonByCondition(person);
            System.out.println(condition);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
     * @Author Zhonghuan
     * @Description 测试trim标签的使用
     * @Date 19:41:54 2022/11/18
     * @Param []
     * @return void
     **/
    @Test
    public void queryPersonByConditionByTrim(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            PersonTo person = new PersonTo(1,"%z%",23,175L);
            List<Person> condition = mapper.queryPersonByConditionByTrim(person);
            System.out.println(condition);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
     * @Author GhostGalaxy
     * @Description 测试choose标签
     * @Date 19:58:50 2022/11/18
     * @Param []
     * @return void
     **/
    @Test
    public void queryPersonByConditionByChoose(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            PersonTo person = new PersonTo(null,null,23,175L);
            List<Person> condition = mapper.queryPersonByConditionByChoose(person);
            System.out.println(condition);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
     * @Author GhostGalaxy
     * @Description 更新数据库操作
     * @Date 20:06:47 2022/11/18
     * @Param []
     * @return void
     **/
    @Test
    public void queryPersonByConditionBySet(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            //不传递的字段值将不会更新
            PersonTo person = new PersonTo(1,null,null,172L);
            mapper.updatePersonByConditionBySet(person);
            System.out.println("更行新数据成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * @Author GhostGalaxy
     * @Description 根据id批量查询
     * @Date 20:38:26 2022/11/18
     * @Param []
     * @return void
     **/
    @Test
    public void queryPersonWithBatchByIds(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            //不传递的字段值将不会更新
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);list.add(2);list.add(3);

            List<Person> people = mapper.queryPersonWithBatchByIds(list);
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * @Author GhostGalaxy
     * @Description 测试foreach标签
     * @Date 20:47:20 2022/11/18
     * @Param []
     * @return void
     **/
    @Test
    public void queryPersonWithBatchByIdsForeach(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);list.add(2);list.add(3);

            List<Person> people = mapper.queryPersonWithBatchByIdsForeach(list);
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * @Author GhostGalaxy
     * @Description 测试通过map传递参数
     * @Date 20:57:59 2022/11/18
     * @Param []
     * @return void
     **/
    @Test
    public void queryPersonWithBatchByIdsForeachTransformMap(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("1",1);  map.put("2",2); map.put("3",3);
            List<Person> people = mapper.queryPersonWithBatchByIdsForeachTransformMap(map);
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * @Author GhostGalaxy
     * @Description 批量保存方法
     * @Date 14:12:45 2022/11/19
     * @Param []
     * @return void
     **/
    @Test
    public void saveBatchPerson(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

            List<Person> list = new ArrayList<Person>();
            list.add(new Person(null,"smith",23,178L,new Address(1)));
            list.add(new Person(null,"rose",24,176L,new Address(2)));
            list.add(new Person(null,"lucy",28,168L,new Address(2)));
            boolean b = mapper.saveBatchPerson(list);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
    /*
     * @Author GhostGalaxy
     * @Description 多SQL执行 需要配置mybatis对多SQL的支持  url=jdbc:mysql://localhost:3306/test?allowMultiQueries=true 通常用于批量删除，修改等操作
     * @Date 14:28:18 2022/11/19
     * @Param []
     * @return void
     **/
    @Test
    public void saveBatchPersonForMultiSql(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

            List<Person> list = new ArrayList<Person>();
            list.add(new Person(null,"smith",23,178L,new Address(1)));
            list.add(new Person(null,"rose",24,176L,new Address(2)));
            list.add(new Person(null,"lucy",28,168L,new Address(2)));
            boolean b = mapper.saveBatchPersonForMultiSql(list);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
    /*
     * @Author GhostGalaxy
     * @Description oracle支持的批量保存方法
     * Oracle不支持 insert into person(no,name,age,height,address_id) values (person_seq.nextval,'smith',25,174,2),
                                                         (person_seq.nextval,'rose',25,174,2),
                                                         (person_seq.nextval,'lucy',23,176,2);
       oracle支持如下两种方式的批量插入操作
        begin
            insert into person(no,name,age,height,address_id) values (person_seq.nextval,'smith',25,174,2);
            insert into person(no,name,age,height,address_id) values (person_seq.nextval,'rose',25,174,2);
            insert into person(no,name,age,height,address_id) values (person_seq.nextval,'lucy',23,176,2);
        end;

        借助中间表：
        insert into person(no,name,age,height,address_id)
            select person_seq.nextval,name,age,height,address_id from(
                    select 'test_a_01' name,'test_a_01 'age,'test_a_01' age, 'test_a_01' height,'test_a_01' address_id  from dual
                    union
                    select 'test_a_02' name,'test_a_02 'age,'test_a_02' age, 'test_a_02' height,'test_a_02' address_id  from dual
                    union
                    select 'test_a_02' name,'test_a_02 'age,'test_a_02' age, 'test_a_02' height,'test_a_02' address_id  from dual
                    )
     * @Date 14:39:27 2022/11/19
     * @Param []
     * @return void
     **/
    @Test
    public void saveBatchPersonForOracle(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

            List<Person> list = new ArrayList<Person>();
            list.add(new Person(null,"smith",23,178L,new Address(1)));
            list.add(new Person(null,"rose",24,176L,new Address(2)));
            list.add(new Person(null,"lucy",28,168L,new Address(2)));
            boolean b = mapper.saveBatchPersonForMultiSqlWithOracle(list);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    /*
     * @Author GhostGalaxy
     * @Description 测试mybatis的 _parameter和 _databaseId
     * <!--两个内置参数:
                不只是方法传递过来的参数可以被用来判断，取值。。。mybatis默认还有两个内置参数:
                _parameter:代表整个参数
                    单个参数:_parameter就是这个参数
                    多个参数:参数会被封装为一个map; _parameter就是代表这个map
                _databaseId :如果配置了databaseIdProvider标签。
                    _databaseId就是代表当前数据库的别名oracle
                -->
     * @Date 15:08:30 2022/11/19
     * @Param []
     * @return void
     **/
    @Test
    public void MyBatisInnerParameter(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            Person person = new Person(1,"zhangsan",23,178L);
            List<Person> people = mapper.MyBatisInnerParameter(person);
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
    /*
     * @Author GhostGalaxy
     * @Description 使用bind进行模糊查询
     * @Date 15:42:40 2022/11/19
     * @Param []
     * @return void
     **/
    @Test
    public void MyBatisInnerParameterWithBind(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
            Person person = new Person(1,"a",23,178L);
            List<Person> people = mapper.MyBatisInnerParameterWithBind(person);
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
}
