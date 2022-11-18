package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName : sqlSessionUtils
 * @Description : 获取Mapper的配置工具
 * @Author : 20609
 * @Date: 2022/11/14  18:00
 */
public class sqlSessionUtils {
    public static SqlSession getSqlSession() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = sessionFactory.openSession(true);
        return sqlSession;
    }
}
