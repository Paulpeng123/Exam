package com.ivan.Dao.Impl;

import com.ivan.Dao.IUserDao;
import com.ivan.entity.User;
import com.ivan.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public Integer addUser(User user) throws SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into user(u_username,u_password,u_sex,u_hobbies,u_phone,u_email,u_address) values(?,?,?,?,?,?,?)");
        ps.setString(1,user.getU_username());
        ps.setString(2,user.getU_password());
        ps.setString(3,user.getU_sex());
        ps.setString(4,user.getU_hobbies());
        ps.setString(5,user.getU_phone());
        ps.setString(6,user.getU_email());
        ps.setString(7,user.getU_address());
        //1.4 执行sql，返回结果集
        int i = ps.executeUpdate();

        return i;
    }
}
