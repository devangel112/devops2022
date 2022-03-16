package com.netflix.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.netflix.itlp.models.Categorias;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriasRM implements RowMapper<Categorias> {
    @Override
    public Categorias mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categorias categoria = new Categorias();
        categoria.setId(rs.getInt("id"));
        categoria.setClasificacion(rs.getString("clasificacion"));
        categoria.setDescripcion(rs.getString("descripcion"));
        categoria.setActivo(rs.getInt("activo"));
        categoria.setCreado(rs.getDate("creado"));
        categoria.setModificado(rs.getDate("modificado"));
        categoria.setEliminado(rs.getDate("eliminado"));

        return categoria;

    }
}