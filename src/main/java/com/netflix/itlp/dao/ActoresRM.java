package com.netflix.itlp.dao;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.netflix.itlp.models.Actores;

@Repository
public class ActoresRM implements RowMapper<Actores> {
    @Override
    public Actores mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actores actor = new Actores();
        actor.setId(rs.getInt("id"));
        actor.setNombre_completo(rs.getString("nombre_completo"));
        actor.setActivo(rs.getInt("activo"));
        actor.setModificado(rs.getDate("modificado"));
        actor.setCreado(rs.getDate("creado"));
        actor.setEliminado(rs.getDate("eliminado"));

        return actor;

    }
}
