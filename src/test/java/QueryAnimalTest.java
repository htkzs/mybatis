import com.itheima.entity.Animal;
import com.itheima.entity.Animals;
import com.itheima.entity.Student;
import com.itheima.mapper.AnimalMapper;
import com.itheima.mapper.AnimalsMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.utils.sqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName QueryAnimalTest 当开启驼峰命名时表userName可以映射为username也可以映射为user_name
 * @Description TODO
 * @Author 20609
 * @Date 2023/12/4 15:15
 * @Version 1.0
 */
public class QueryAnimalTest {
    @Test
    public void getAnimalById(){
        SqlSession sqlSession =null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);
            Animal animal = animalMapper.queryAnimalById(1);
            System.out.println(animal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    @Test
    public void insertAnimal(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);
            Animal animal = new Animal(8, "小蓝", "泰迪", 2);
            animalMapper.InsertAnimal(animal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            assert sqlSession != null;
            sqlSession.close();
        }

    }

    @Test
    public void addStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.addStudent(new Student(1001,"zhang",23,"men"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            assert sqlSession != null;
            sqlSession.close();
        }

    }
    /**
     * @description: 测试驼峰命名转换和使用resultMap映射
     * @author 20609
     * @date 2023/12/4 16:24
     * @version 1.0
     */
    @Test
    public void getAnimalsById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            AnimalsMapper animalsMapper = sqlSession.getMapper(AnimalsMapper.class);
            Animals animals = animalsMapper.getAnimalsById(1);
            System.out.println(animals);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            assert sqlSession != null;
            sqlSession.close();
        }

    }
    @Test
    public void insertAnimalWithBoolean(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionUtils.getSqlSession();
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);
            Animal animal = new Animal(4, "小白", "哈士奇", 2);
            Boolean result = animalMapper.InsertAnimalwithBoolean(animal);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            assert sqlSession != null;
            sqlSession.close();
        }

    }


}
