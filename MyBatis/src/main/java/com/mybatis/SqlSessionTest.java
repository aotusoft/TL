package com.mybatis;

import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/7/1 10:34
 */
public class SqlSessionTest {

    @Test
    public void testSqlSession() throws IOException {
        //测试是否连接成功
        //mybatis 核心对象 sqlSession

        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取session工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //通过工厂获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
//        System.out.println(sqlSession);
        //命名空间.id
        List<User> users = sqlSession.selectList("User.getAll");
        System.out.println(users);
    }
}


















