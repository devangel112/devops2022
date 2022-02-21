package com.netflix.itlp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.netflix.itlp.models.Perfiles;

@Repository
public class PerfilesJDBC {

    @Autowired
    private JdbcTemplate conexion;

    public int insertar(int cuenta_id, Perfiles perfil) {
        String sql = "INSERT INTO perfiles_usuarios (nombre, idioma, clasificacion_edad, cuentas_id, activo) VALUES (?, ?, ?, ?, 1);";
        conexion.update(sql,
                perfil.getNombre(),
                perfil.getIdioma(),
                perfil.getClasificacion_edad(),
                cuenta_id);
        sql = "SELECT LAST_INSERT_ID()";
        return conexion.queryForObject(sql, Integer.class);
    }

    public void modificar(int perfil_id, Perfiles perfil) {
        String sql = "UPDATE perfiles_usuarios SET nombre = ?, idioma = ?,  clasificacion_edad = ? WHERE id = ?";
        conexion.update(sql, perfil.getNombre(), perfil.getIdioma(), perfil.getClasificacion_edad(), perfil_id);
    }

    public List<Perfiles> listar(int cuenta_id) {
        String sql = "SELECT * FROM perfiles_usuarios WHERE cuentas_id = ? and activo = 1";
        return conexion.query(sql, new PerfilesRM(), cuenta_id);
    }

    public void desactivar(int perfil_id) {
        String sql = "UPDATE perfiles_usuarios SET activo = 0 WHERE id = ?";
        conexion.update(sql, perfil_id);
    }
}
