package com.example.demo1.dao;

import com.example.demo1.entity.User;
import com.example.demo1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    PreparedStatement pstmt=null;
    Connection conn=null;
    ResultSet rs=null;
    @Override
    public int regist(String username, String password) {
        conn= DBUtil.getConn();
        String sql = "insert into user values(0,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int login(String username, String password) {
        conn= DBUtil.getConn();
        //登录时查询确定是否查到数据
        String sql="select count(1) from user where username=? and password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
        @Override
    public int del(int id) {
        conn= DBUtil.getConn();
            String sql = "delete from user where id=?";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                int count = pstmt.executeUpdate();
               return count;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return 0;
    }

    @Override
    public List<User> list() {
        conn= DBUtil.getConn();
        List<User> userList = new ArrayList<User>();
        //登录时查询确定是否查到数据
        String sql = "select * from user";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                userList.add(u);
            }
            return userList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String byUserName(String username) {
        conn= DBUtil.getConn();
        String sql = "select count(1) from user where username=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Integer count = rs.getInt(1);
                return count.toString();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
