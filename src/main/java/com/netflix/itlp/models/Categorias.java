package com.netflix.itlp.models;

import java.util.Date;

public class Categorias {
	private String clasificacion; //varchar
    private String descripcion;
    private int activo;
    private Date creado;
    private Date modificado;
    private Date eliminado;
   
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public Date getCreado() {
		return creado;
	}
	public void setCreado(Date creado) {
		this.creado = creado;
	}
	public Date getModificado() {
		return modificado;
	}
	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}
	public Date getEliminado() {
		return eliminado;
	}
	public void setEliminado(Date eliminado) {
		this.eliminado = eliminado;
	}
	
	
	
	
	
}
