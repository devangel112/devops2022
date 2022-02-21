package com.netflix.itlp.models;

public class Perfiles {
    private int id;
    private String nombre;
    private String idioma;
    private String clasificacion_edad;
    private int cuentas_id;
    private int activo;

    public int getActivo() {
        return this.activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getClasificacion_edad() {
        return this.clasificacion_edad;
    }

    public void setClasificacion_edad(String clasificacion_edad) {
        this.clasificacion_edad = clasificacion_edad;
    }

    public int getCuentas_id() {
        return this.cuentas_id;
    }

    public void setCuentas_id(int cuentas_id) {
        this.cuentas_id = cuentas_id;
    }

}
