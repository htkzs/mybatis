import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @ClassName : MapperCacheTest
 * @Description : mybatis标签详解
 * @Author : 20609
 * @Date: 2022/11/14  17:24
 */


public class MapperCacheTest {
    /**
     * @Param :
     * @Description :  测试一级缓存
     * @Author : 20609
     * @Date : 2022/11/14 20:16
     */
    public static void getUser() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser(1);
        //设置手动清除一级缓存
        //sqlSession.clearCache();

        //由于使用的是同一个sqlSession所以共享一级缓存 数据库SQL只执行一次 mybatis莫认开启一级缓存 和mapper没有关系。
        UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper1.getUser(1);
        System.out.println(user);
        System.out.println(user1);
    }
    /**
    * @Param :
    * @Description :  需要手动开启，同一个sqlSessionFactory共享二级缓存，一个sqlSessionFactory可以创建多个sqlSession，通过这n多个sql会话执行查询操作时会共享二级缓存。保存的时机提交或者关闭sqlSession就会保存到二级缓存。
     * 缓存失效：两次查询之间执行任意的数据库写操作会导致缓存失效。
    * @Author : 20609
    * @Date : 2022/11/14 20:17
    */

    public static void getUserList() {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            SqlSession sqlSession = build.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> allUser = mapper.getAllUser();
            System.out.println(allUser);
            sqlSession.close();
            //通过同一个SqlSessionFactory获取到session会话共享二级缓存
            SqlSession sqlSession1 = build.openSession(true);
            UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
            List<User> allUser1 = mapper1.getAllUser();
            System.out.println(allUser1);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private static void deleteUserById(){
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            //设置sql会话的自动提交
            SqlSession sqlSession = build.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUserById(3);
            //对于数据库的写操作必须提交commit后才会真正执行
            //如果上面没有自动提交的话这里就需要手动提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {
        MapperCacheTest.getUser();
        //MapperCacheTest.getUserList();
        //MapperCacheTest.deleteUserById();
    }
}
