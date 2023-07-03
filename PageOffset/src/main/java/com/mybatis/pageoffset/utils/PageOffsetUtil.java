package com.mybatis.pageoffset.utils;

import com.mybatis.pageoffset.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/7/3 11:26
 */
public class PageOffsetUtil {
    //每页显示的条数
    private int pageSize;
    //当前页数
    private int currentPage;
    //总页数
    private int totalPage;
    //总行数
    private int totalCount;
    //存储每页数据
    private List<User> list = new ArrayList<>();

    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页显示的条数
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置当前页数
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        //计算总页数
        //如果总行数不能被每页条数除尽则再加一页页数
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount % pageSize + 1;
    }

    /**
     * 设置总页数
     * @param totalPage
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总行数
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
