import com.itheima.entity.User;
import com.itheima.mapper.UserMapperAnnotation;
import com.itheima.utils.sqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @ClassName : MapperAnnotationTest
 * @Description : 基于注解的方式编写SQL测试
 * @Author : 20609
 * @Date: 2022/11/17  11:19
 */
public class MapperAnnotationTest {

    public static void mapperAnnotationTest(){
        try {
            SqlSession sqlSession = sqlSessionUtils.getSqlSession();
            UserMapperAnnotation mapper = sqlSession.getMapper(UserMapperAnnotation.class);
            User user = mapper.getUser(1);
            System.out.println(user);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MapperAnnotationTest.mapperAnnotationTest();
    }
}
