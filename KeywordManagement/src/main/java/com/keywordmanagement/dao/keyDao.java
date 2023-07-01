package com.keywordmanagement.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: nekotako
 * @Date: 2023/6/30 16:33
 */
public interface keyDao {
    List getAll() throws SQLException;

    int getInfoByName();
    int add();
}
