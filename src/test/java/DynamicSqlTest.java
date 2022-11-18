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


}
