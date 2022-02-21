package com.netflix.itlp.dao;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.netflix.itlp.models.Perfiles;

@Repository
public class PerfilesRM implements RowMapper<Perfiles> {
    @Override
    public Perfiles mapRow(ResultSet rs, int rowNum) throws SQLException {
        Perfiles perfil = new Perfiles();
        perfil.setId(rs.getInt("id"));
        perfil.setNombre(rs.getString("nombre"));
        perfil.setIdioma(rs.getString("idioma"));
        perfil.setClasificacion_edad(rs.getString("clasificacion_edad"));
        perfil.setCuentas_id(rs.getInt("cuentas_id"));
        perfil.setActivo(rs.getInt("activo"));

        return perfil;

    }
}
