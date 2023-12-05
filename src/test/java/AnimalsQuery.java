import com.itheima.entity.Animals;
import com.itheima.mapper.AnimalsMapper;
import com.itheima.utils.sqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName AnimalsQuery Animals表的相关CRUD操作
 * @Description TODO
 * @Author 20609
 * @Date 2023/12/5 14:28
 * @Version 1.0
 */
public class AnimalsQuery {
    /**
     * @description  此时数据库字段为nick_name 而实体类属性值为nickName 使用sql别名建立映射关系
     * @author  20609
     * @date    2023/12/5 14:29
     * @param
     * @return  void
    */
    @Test
    public void getAnimalsById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            AnimalsMapper animalsMapper = sqlSession.getMapper(AnimalsMapper.class);
            Animals animals = animalsMapper.getAnimalsByIdWithAliases(1);
            System.out.println(animals);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            assert sqlSession !=null;
            sqlSession.close();
        }

    }
}
