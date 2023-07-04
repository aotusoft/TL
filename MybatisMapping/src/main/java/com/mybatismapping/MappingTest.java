package com.mybatismapping;

import com.mybatismapping.mapper.UserMapper;
import com.mybatismapping.pojo.User;
import com.mybatismapping.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/7/4 14:57
 */
public class MappingTest {
    @org.junit.Test
    public void resultMapTest() {
        SqlSession session = MybatisUtil.getSession();
        List<User> allInfo = session.getMapper(UserMapper.class).getAllInfo();
        for (User user : allInfo) {
            System.out.println("ID--"+user.getId() +"---username--"+ user.getUsername() +"--date--"+ user.getDate());
        }
    }
}
