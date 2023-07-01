package com.keywordmanagement.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    static Connection conn = null;

    //获取连接
    public static Connection getConn() {
        try {
//            //创建Properties对象
//            Properties properties=new Properties();
//           //使用load方法加载properties文件
//            // getClassLoader : 获取类加载器
//            // getResourceAsStream : 把资源转换为流
//            // 这里 定位到src.所以可以直接写文件名,而流是定位到项目
//            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            Properties properties=PropertiesUtil.getProperties();
            //根据key获取value
            String driver=properties.getProperty("jdbc.driver");
            String url=properties.getProperty("jdbc.url");
            String username=properties.getProperty("jdbc.username");
            String password=properties.getProperty("jdbc.password");

            //1.加载驱动
            Class.forName(driver);
            //2.建立连接
            if (conn == null) {
                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭连接
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }
}
