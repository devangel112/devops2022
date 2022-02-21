package com.netflix.itlp.models;

import java.util.Date;

public class Cuentas {
    private int id;
    private String email;
    private String password;
    private int activa;
    private Date fecha_ultimo_pago;
    private String nombre;
    private String apellido;
    private String numero_tarjeta;
    private String fecha_vencimiento;
    private String codigo_seguridad;
    private String tipo_tarjeta;
    private int planes_id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActiva() {
        return this.activa;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }

    public Date getFecha_ultimo_pago() {
        return this.fecha_ultimo_pago;
    }

    public void setFecha_ultimo_pago(Date fecha_ultimo_pago) {
        this.fecha_ultimo_pago = fecha_ultimo_pago;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero_tarjeta() {
        return this.numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getFecha_vencimiento() {
        return this.fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getCodigo_seguridad() {
        return this.codigo_seguridad;
    }

    public void setCodigo_seguridad(String codigo_seguridad) {
        this.codigo_seguridad = codigo_seguridad;
    }

    public String getTipo_tarjeta() {
        return this.tipo_tarjeta;
    }

    public void setTipo_tarjeta(String tipo_tarjeta) {
        this.tipo_tarjeta = tipo_tarjeta;
    }

    public int getPlanes_id() {
        return this.planes_id;
    }

    public void setPlanes_id(int planes_id) {
        this.planes_id = planes_id;
    }
}
