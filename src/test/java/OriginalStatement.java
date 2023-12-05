import com.itheima.entity.Animal;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName OriginalStatement 原始的操作方式 后来使用mapper动态代理的方式操作数据库
 * @Description TODO
 * @Author 20609
 * @Date 2023/12/4 16:38
 * @Version 1.0
 */
public class OriginalStatement {
    @Test
    public void test(){
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
            //注意这里设置为不自动提交 当执行CUD操作时需要手动commit()
            SqlSession sqlSession = build.openSession();
            String statement = "com.itheima.mapper.AnimalMapper.queryAnimalById";
            Animal animal = sqlSession.selectOne(statement, 1);
            System.out.println(animal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
