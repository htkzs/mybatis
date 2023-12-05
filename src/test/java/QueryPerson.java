import com.itheima.entity.Person;
import com.itheima.mapper.PersonMapper;
import com.itheima.utils.sqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName QueryPerson 测试PersonMapper.xml
 * @Description TODO
 * @Author 20609
 * @Date 2023/12/4 17:52
 * @Version 1.0
 */
public class QueryPerson {
    @Test
    public void queryPersonByArray(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            int [] nos = {1,2,3};
            List<Person> peoples = personMapper.queryPersonByArray(nos);
            System.out.println(peoples);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(sqlSession !=null){
                sqlSession.close();
            }

        }
    }
    /**
     * @description: TODO  传入对象为数组
     * @author 20609
     * @date 2023/12/4 18:31
     * @version 1.0
     */
    @Test
    public void queryPersonByArrayWithWhere(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            int [] nos = {1,2,3};
            List<Person> peoples = personMapper.queryPersonByArrayWithWhere(nos);
            System.out.println(peoples);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(sqlSession !=null){
                sqlSession.close();
            }

        }
    }

    /**
     * @description: 输入参数为HashMap类型
     * @author 20609
     * @date 2023/12/4 18:37
     * @version 1.0
     */

    /**
     * @description: 输出参数为hashMap类型
     * @author 20609
     * @date 2023/12/4 18:37
     * @version 1.0
     */


    /**
     * @description: TOD输出参数为List<HashMap<>>类型
     * @author 20609
     * @date 2023/12/4 18:37
     * @version 1.0
     */
    @Test
    public void queryPersonById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = personMapper.queryPersonById(1);
            System.out.println(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            if(sqlSession !=null){
                sqlSession.close();
            }

        }
    }



}
