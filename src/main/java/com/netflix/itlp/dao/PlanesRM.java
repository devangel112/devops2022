package com.netflix.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.netflix.itlp.models.Planes;

public class PlanesRM implements RowMapper<Planes> {

	@Override
	public Planes mapRow(ResultSet rs, int rowNum) throws SQLException {
		Planes plan = new Planes();
		plan.setId(rs.getInt("id"));
		plan.setDescripcion(rs.getString("descripcion"));
		plan.setPrecio_mensual(rs.getBigDecimal("precio_mensual"));
		plan.setCalidad_video(rs.getString("calidad_video"));
		plan.setResolucion(rs.getString("resolucion"));
		plan.setCantidad_dispositivos(rs.getInt("cantidad_dispositivos"));

		return plan;

	}

}
