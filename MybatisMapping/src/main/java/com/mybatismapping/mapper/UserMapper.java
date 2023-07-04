package com.mybatismapping.mapper;


import com.mybatismapping.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/7/3 10:35
 */
public interface UserMapper {

    //获取信息

    List<User> getAllInfo();
}
