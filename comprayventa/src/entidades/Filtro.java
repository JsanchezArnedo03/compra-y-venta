/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author jssa3
 */
public class Filtro {

    private int id;
    private int tipo_Transaccion;
    private Empleado documentoEmpleado;
    private Date fechaIncio;
    private Date fechaFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTipo_Transaccion() {
        return tipo_Transaccion;
    }

    public void setTipo_Transaccion(int tipo_Transaccion) {
        this.tipo_Transaccion = tipo_Transaccion;
    }

    public Empleado getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public void setDocumentoEmpleado(Empleado documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }
}
