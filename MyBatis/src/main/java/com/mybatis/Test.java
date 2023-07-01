package com.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: nekotako
 * @Date: 2023/7/1 10:34
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //测试是否连接成功
        //mybatis 核心对象 sqlSession

        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取session工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //通过工厂获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
    }
}


















