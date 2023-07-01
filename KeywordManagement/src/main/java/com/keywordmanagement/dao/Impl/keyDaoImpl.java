package com.keywordmanagement.dao.Impl;

import com.keywordmanagement.dao.keyDao;
import com.keywordmanagement.pojo.Keyword;
import com.keywordmanagement.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/6/30 16:37
 */
public class keyDaoImpl implements keyDao {
    Connection conn = null;
    String sql;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List getAll() throws SQLException {
        List<Keyword> keywords = new ArrayList<>();
        conn = DBUtil.getConn();
        sql = "select * from keyword";
        rs = pstmt.executeQuery(sql);
        while (rs.next()){
            Keyword keyword = new Keyword();
            keyword.setId(rs.getInt("id"));
            keyword.setName(rs.getString("name"));
            keyword.setType(rs.getString("type"));
            keyword.setCreateDate(Date.valueOf(rs.getString("createDate")));
            keywords.add(keyword);
        }
        return null;
    }

    @Override
    public int getInfoByName() {
        return 0;
    }

    @Override
    public int add() {
        return 0;
    }
}
