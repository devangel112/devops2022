package com.netflix.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.netflix.itlp.models.Login;

import org.springframework.jdbc.core.RowMapper;

public class LoginRM implements RowMapper<Login> {
    @Override
    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
        Login login = new Login();
        login.setEmail(rs.getString("email"));
        login.setPassword(rs.getString("password"));
        return login;
    }
}
