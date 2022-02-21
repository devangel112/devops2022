package com.netflix.itlp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.netflix.itlp.models.Planes;

// Esta notación afectara a la clase PlanJDCB
@Repository
public class PlanesJDBC {

	@Autowired
	private JdbcTemplate conexion;

	// Metodo pubico
	public List<Planes> consultar() {
		String sql = "SELECT * FROM planes";
		return conexion.query(sql, new PlanesRM()); // Regresa una lista o asi
	}

	public Planes buscar(int id) {
		String sql = "select *from planes WHERE id=? AND activo=1";
		return conexion.queryForObject(sql, new PlanesRM(), id); // Regresa un solo objeto
	}

	// Descactivar datos
	public void desactivar(int id) {
		String sql = "UPDATE planes SET activo = 0, eliminado = NOW() WHERE id=?";
		conexion.update(sql, id);
	}

	// Modificar datos
	public void modificar(int id, Planes plan) {

		String sql = "UPDATE planes SET descripcion = ?, precio_mensual = ?,"
				+ "calidad_video = ?, resolucion = ?,"
				+ "cantidad_dispositivos = ?, modificado = NOW() WHERE id = ?";
		conexion.update(sql, plan.getDescripcion(),
				plan.getPrecio_mensual(), plan.getCalidad_video(), plan.getResolucion(),
				plan.getCantidad_dispositivos(), id);
	}

	public int insertar(Planes nuevo_plan) {

		String sql = "INSERT INTO planes(descripcion, precio_mensual,"
				+ "calidad_video, resolucion, cantidad_dispositivos) VALUES"
				+ "(?, ?, ?, ?, ?)";
		conexion.update(sql, nuevo_plan.getDescripcion(),
				nuevo_plan.getPrecio_mensual(),
				nuevo_plan.getCalidad_video(),
				nuevo_plan.getResolucion(),
				nuevo_plan.getCantidad_dispositivos());

		sql = "SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
	}
}
