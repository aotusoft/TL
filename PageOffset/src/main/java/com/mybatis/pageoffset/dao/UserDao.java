package com.mybatis.pageoffset.dao;


import com.mybatis.pageoffset.pojo.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/7/1 14:25
 */
public interface UserDao {

    List<User> getAllInfo();
}
