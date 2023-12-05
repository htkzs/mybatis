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
     * 同一个sqlSession共享一级缓存
     * 缓存失效的时机
     * 1.sqlSession不同
     * 2.是同一个sqlSession但查询条件不一样
     * 3.在两个查询之间执行一次增删改操作都会导致缓存失效
     * 4.手动清理缓存 sqlSession.clearCache();
     * @Author : 20609
     * @Date : 2022/11/14 20:16
     */
    public static void getUser() throws IOException {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = sessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(1);
            System.out.println(user);
            //设置手动清除一级缓存
            //sqlSession.clearCache();

            //由于使用的是同一个sqlSession所以共享一级缓存 数据库SQL只执行一次 mybatis默认开启一级缓存 和mapper没有关系。
            UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);
            User user1 = mapper.getUser(1);
            System.out.println(user1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }

        }

    }
    /**
    * @Param :
    * @Description :  需要手动开启， 1.配置mybatis-config.xml <setting name="cacheEnabled" value="true"/>
     *                            2.在需要开启二级缓存的namespace中设置 <cache type="org.mybatis.caches.ehcache.EhcacheCache" eviction="FIFO" size="2000"/>
     *
     * 同一个sqlSessionFactory共享二级缓存，一个sqlSessionFactory可以创建多个sqlSession，通过这n多个sql会话执行查询操作时会共享二级缓存。
     * 保存的时机提交或者关闭sqlSession就会保存到二级缓存。
     * 缓存失效：
     *
    * @Author : 20609
    * @Date : 2022/11/14 20:17
    */

    public static void getUserList() {
        Reader resourceAsReader = null;
        try {
            resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            SqlSession sqlSession = build.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> allUser = mapper.getAllUser();
            System.out.println(allUser);
            //当执行会话关闭操作的时候该保存到一级缓存的数据会被保存到二级缓存
            sqlSession.close();
            //通过同一个SqlSessionFactory获取到session会话共享二级缓存
            SqlSession sqlSession1 = build.openSession(true);
            UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
            List<User> allUser1 = mapper1.getAllUser();
            System.out.println(allUser1);
            sqlSession1.close();

        } catch (IOException e) {

            e.printStackTrace();
        }finally {
            try {
                assert resourceAsReader != null;
                resourceAsReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void deleteUserById(){
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            //设置sql会话的自动提交
            sqlSession = build.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUserById(3);
            //对于数据库的写操作必须提交commit后才会真正执行
            //如果上面没有自动提交的话这里就需要手动提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            assert sqlSession != null;
            sqlSession.close();
        }

    }
    public static void main(String[] args) throws IOException {
        //MapperCacheTest.getUser();
        //MapperCacheTest.getUserList();
        MapperCacheTest.deleteUserById();
    }
}
