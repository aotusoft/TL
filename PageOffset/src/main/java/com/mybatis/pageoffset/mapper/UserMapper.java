package com.mybatis.pageoffset.mapper;

import com.mybatis.pageoffset.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/7/3 10:35
 */
public interface UserMapper {
    //获取总行数
    int getCount();

    //获取信息

    /**
     * @param offset   Mysql limit 偏移起始量
     * @param pageSize Mysql limit 每页显示条数
     * @return
     */
    List<User> getAllInfo(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 根据不同参数获取信息
     *
     * @return
     */
    List<User> getInfoByParams(User user);
}
