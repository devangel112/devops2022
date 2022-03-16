package com.netflix.itlp.dao;

import java.util.List;

import com.netflix.itlp.models.Generos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GenerosJDBC {
    @Autowired
    private JdbcTemplate conexion;

    public int insertar(Generos genero) {
        String sql = "INSERT INTO generos (nombre) VALUES (?);";
        conexion.update(sql, genero.getNombre());
        sql = "SELECT LAST_INSERT_ID()";
        return conexion.queryForObject(sql, Integer.class);
    }

    public void modificar(int genero_id, Generos genero) {
        String sql = "UPDATE generos SET nombre = ?, modificado = CURRENT_TIMESTAMP() WHERE id = ?";
        conexion.update(sql, genero.getNombre(), genero_id);
    }

    public List<Generos> listar() {
        String sql = "SELECT * FROM generos WHERE activo = 1";
        return conexion.query(sql, new GenerosRM());
    }

    public void desactivar(int genero_id) {
        String sql = "UPDATE generos SET activo = 0, eliminado = CURRENT_TIMESTAMP() WHERE id = ?";
        conexion.update(sql, genero_id);
    }

    public void asignarGeneroPelicula(int genero_id, int pelicula_id) {
        String sql = "INSERT INTO genero_pelicula (generos_id, peliculas_id) VALUES (?, ?)";
        conexion.update(sql, genero_id, pelicula_id);
    }

    public void asignarGeneroSerie(int genero_id, int serie_id) {
        String sql = "INSERT INTO genero_serie (generos_id, series_id) VALUES (?, ?)";
        conexion.update(sql, genero_id, serie_id);
    }
}
