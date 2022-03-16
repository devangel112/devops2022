package com.netflix.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.netflix.itlp.models.Generos;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GenerosRM implements RowMapper<Generos> {
    @Override
    public Generos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Generos genero = new Generos();
        genero.setId(rs.getInt("id"));
        genero.setNombre(rs.getString("nombre"));
        genero.setActivo(rs.getInt("activo"));
        genero.setModificado(rs.getDate("modificado"));
        genero.setCreado(rs.getDate("creado"));
        genero.setEliminado(rs.getDate("eliminado"));

        return genero;

    }
}
