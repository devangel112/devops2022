package com.netflix.itlp.dao;

import com.netflix.itlp.models.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginJDBC {
    @Autowired
    private JdbcTemplate conexion;

    public Login consultarUsuario(Login login) {
        String sql = "SELECT * FROM cuentas WHERE email = ? and password = ?";
        String email = login.getEmail();
        String password = login.getPassword();

        return conexion.queryForObject(sql, new LoginRM(), email, password);
    }
}
