package com.ivan.Dao;

import com.ivan.entity.User;

import java.sql.SQLException;

public interface IUserDao {
    //注册功能
    Integer addUser(User user) throws SQLException;
}
