package com.netflix.itlp.dao;

import com.netflix.itlp.models.Categorias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriasJDBC {
        @Autowired
        private JdbcTemplate conexion;

        public int insertar(Categorias nueva_categoria) {
                String sql = "INSERT INTO categorias (clasificacion, descripcion)"
                                + "VALUES (?, ?);";
                conexion.update(sql,
                                nueva_categoria.getClasificacion(),
                                nueva_categoria.getDescripcion()
                );
                sql = "SELECT LAST_INSERT_ID();";
                return conexion.queryForObject(sql, Integer.class);
        }

        //nombre, descripcion y clasificacion
        public void modificarCategoria(int categoria_id, Categorias categoria) {
                String sql = "UPDATE categorias SET clasificacion = ?, modificado = NOW(), descripcion = ? WHERE id = ?;";
                conexion.update(sql,
                                categoria.getClasificacion(),
                                categoria.getDescripcion(), 
                                categoria_id);
        }
     
        
        public void desactivar(int categoria_id) {
                String sql = "UPDATE categorias SET activo = 0, eliminado = NOW() WHERE id = ?";
                conexion.update(sql,
                                categoria_id);
        }
     
        // Metodo pubico
    	public List<Categorias> listar() {
    		String sql = "SELECT * FROM categorias WHERE activo = 1";
    		return conexion.query(sql, new CategoriasRM()); // Regresa una lista 
    	}      
}
