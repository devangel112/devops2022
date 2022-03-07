package com.netflix.itlp.models;

import java.util.Date;

public class Actores {
    private int id;
    private String nombre_completo;
    private int activo;
    private Date creado;
    private Date modificado;
    private Date eliminado;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return this.nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public int getActivo() {
        return this.activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getCreado() {
        return this.creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getModificado() {
        return this.modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }

    public Date getEliminado() {
        return this.eliminado;
    }

    public void setEliminado(Date eliminado) {
        this.eliminado = eliminado;
    }
}
