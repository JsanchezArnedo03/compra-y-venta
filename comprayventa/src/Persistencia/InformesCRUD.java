/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Empleado;
import entidades.Filtro;
import entidades.Transacciones;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jssa3
 */
public class InformesCRUD {
    
    Connection con = Conexion.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    /*METODO ENCARGADO DE HACER LA BUSQUEDA POR EL EMPLEADO */
 /*FALTA SOLAMENTE HACER EL PROCEDIMIENTO DE ALMACENADO CON TODO LO QUE SE 
    DEBA PEDIR*/
    public DefaultTableModel reporteXVendedor(Empleado empleado) {
        String sql = "call informeXVendedor(?);";
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        try {
            model.addColumn("EMPLEADO");
            model.addColumn("MARCA");
            model.addColumn("MODELO");
            model.addColumn("PRECIO COMPRA");
            model.addColumn("PRECIO VENTA");
            model.addColumn("FECHA");
            ps = con.prepareCall(sql);
            ps.setString(1, empleado.getDocumento());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object rowData = new Object[]{
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4),
                    rs.getObject(5),
                    rs.getObject(6)
                };
                model.addRow((Object[]) rowData);
            }
            table.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(InformesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    /*METODO ENCARGADO DE HACER LA BUSQUEDA POR FECHAS Y POR TIPO DE TRANSACCION Y POR VENDEDOR
    (COMPRADOS Y/O VENDIDOS EN UN RANGO DE FECHAS)
     */
    public DefaultTableModel InformeGeneral(Filtro filtro) {
        String sql = "call informeGeneral(?,?,?,?);";
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        model.addColumn("EMPLEADO");
        model.addColumn("CLIENTE");
        model.addColumn("VEHICULO");
        model.addColumn("MODELO");
        model.addColumn("PRECIO COMPRA");
        model.addColumn("PRECIO VENTA");
        model.addColumn("FECHA VENTA");
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, filtro.getDocumentoEmpleado().getDocumento());
            ps.setInt(2, filtro.getTipo_Transaccion());
            ps.setDate(3, (Date) filtro.getFechaIncio());
            ps.setDate(4, (Date) filtro.getFechaFin());
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] rowData = new Object[]{
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4),
                    rs.getObject(5),
                    rs.getObject(6),
                    rs.getObject(7),};
                model.addRow(rowData);
            }
            table.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(InformesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    /*METODO ENVARGADO DE REALIZAR LA BUSQUEDA POR FECHAS*/
    public DefaultTableModel InformeXfechas(Filtro filtro) {
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "call informeXfechas(?,?,?);";
        model.addColumn("VENDEDOR O COMPRADOR");
        model.addColumn("CLIENTE");
        model.addColumn("MARCA");
        model.addColumn("MODELO");
        model.addColumn("TIPO TRANSACCION");
        model.addColumn("VALOR");
        try {
            ps = con.prepareCall(sql);
            ps.setDate(1, (Date) filtro.getFechaIncio());
            ps.setDate(2, (Date) filtro.getFechaFin());
            ps.setInt(3, filtro.getTipo_Transaccion());
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] rowData = new Object[]{
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4),
                    rs.getObject(5)};
                model.addRow(rowData);
            }
            table.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(InformesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public ArrayList listadoTransaccion() {
        Transacciones transaccion;
        ArrayList<String> listado = new ArrayList<>();
        try {
            String sql = "SELECT tipoTransaccion FROM tipoTransaccion;";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                transaccion = new Transacciones();
                transaccion.setTipoTransaccion(rs.getString(1).toUpperCase());
                listado.add(transaccion.getTipoTransaccion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
    
    public int mostrar_ganancia(String documento, int tipo_transaccion) {
        int acumulador = 0;
        if (tipo_transaccion != 2) {
            return 0;
        }
        try {
            String sql = "call ganancia(?,?);";
            ps = con.prepareCall(sql);
            ps.setString(1, documento);
            ps.setInt(2, tipo_transaccion);
            rs = ps.executeQuery();
            while (rs.next()) {
                acumulador += rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InformesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.valueOf(acumulador);
    }
    
    public DefaultTableModel informe_transaccion(String documento, int tipo_transaccion) {
        DefaultTableModel model = new DefaultTableModel();
        if (tipo_transaccion == 1) {
            model.addColumn("MARCA");
            model.addColumn("PRECIO COMPRA");
            model.addColumn("CANTIDAD");
            model.addColumn("TIPO DE TRANSACCION");
        } else if (tipo_transaccion == 2) {
            model.addColumn("MARCA");
            model.addColumn("PRECIO COMPRA");
            model.addColumn("PRECIO VENTA");
            model.addColumn("CANTIDAD");
            mostrar_ganancia(documento, tipo_transaccion);
        }
        try {
            String sql = "call informe_venta_ganancia(?,?);";
            ps = con.prepareCall(sql);
            ps.setString(1, documento);
            ps.setInt(2, tipo_transaccion);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] rowData = new Object[]{
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4),};
                model.addRow(rowData);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InformesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
}
