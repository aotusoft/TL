package com.example.demo1.dao;

import com.example.demo1.entity.User;

import java.util.List;

public interface UserDao {

    int regist(String username,String password);
    int login(String username,String password);
    int del(int id);
    List<User> list();
    String byUserName(String username);
}
