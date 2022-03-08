package com.netflix.itlp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.netflix.itlp.models.Actores;

@Repository
public class ActoresJDBC {

    @Autowired
    private JdbcTemplate conexion;

    public int insertar(Actores actor) {
        String sql = "INSERT INTO actores (nombre_completo) VALUES (?);";
        conexion.update(sql, actor.getNombre_completo());
        sql = "SELECT LAST_INSERT_ID()";
        return conexion.queryForObject(sql, Integer.class);
    }

    public void modificar(int actor_id, Actores actor) {
        String sql = "UPDATE actores SET nombre_completo = ?, modificado = CURRENT_TIMESTAMP() WHERE id = ?";
        conexion.update(sql, actor.getNombre_completo(), actor_id);
    }

    public List<Actores> listar() {
        String sql = "SELECT * FROM actores WHERE activo = 1";
        return conexion.query(sql, new ActoresRM());
    }

    public void desactivar(int actor_id) {
        String sql = "UPDATE actores SET activo = 0, eliminado = CURRENT_TIMESTAMP() WHERE id = ?";
        conexion.update(sql, actor_id);
    }
}
