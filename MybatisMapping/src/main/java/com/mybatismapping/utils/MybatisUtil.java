package com.mybatismapping.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private MybatisUtil(){}
    private static SqlSessionFactory sessionFactory=null;
    static {
        //1.加载mybatis核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.获取session工厂对象
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //获取sqlsession
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

    //关闭sqlsession
    public static void close(SqlSession session){
        if(session!=null){
            session.close();
        }
    }
}
