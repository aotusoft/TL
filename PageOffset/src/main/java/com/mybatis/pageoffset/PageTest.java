package com.mybatis.pageoffset;

import com.mybatis.pageoffset.mapper.UserMapper;
import com.mybatis.pageoffset.pojo.User;
import com.mybatis.pageoffset.utils.MybatisUtil;
import com.mybatis.pageoffset.utils.PageOffsetUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/7/3 11:38
 */
public class PageTest {
    @Test
    public void print() {
        SqlSession session = MybatisUtil.getSession();
        int count = session.getMapper(UserMapper.class).getCount();
        PageOffsetUtil pageOffsetUtil = new PageOffsetUtil();
        pageOffsetUtil.setPageSize(100);
        pageOffsetUtil.setCurrentPage(2);
        pageOffsetUtil.setTotalCount(count);
        List<User> list = session.getMapper(UserMapper.class).getAllInfo((pageOffsetUtil.getCurrentPage() - 1) * pageOffsetUtil.getPageSize(), pageOffsetUtil.getPageSize());
        pageOffsetUtil.setList(list);
    }
}
