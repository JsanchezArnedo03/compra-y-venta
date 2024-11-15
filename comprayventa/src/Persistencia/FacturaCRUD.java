/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jssa3
 */
public class FacturaCRUD {

    Connection con = Conexion.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;

    public boolean crearFacturaVenta(Factura factura) {
        try {
            sql = "call crearFacturaVenta(?,?,?,?,?,?);";
            ps = con.prepareCall(sql);
            ps.setInt(1, factura.getId_empleado());
            ps.setDate(2, factura.getFechaMoviento());
            ps.setInt(3, factura.getId_producto());
            ps.setFloat(4, factura.getCantidad());
            ps.setInt(5, factura.getTipoTransaccion());
            ps.setInt(6, factura.getId_cliente());
            rs = ps.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean crearFacturaCompra(Factura factura) {
        try {
            sql = "call detalle_factura(?,?,?,?,?,?);";
            ps = con.prepareCall(sql);
            ps.setInt(1, factura.getId_empleado());
            ps.setDate(2, factura.getFechaMoviento());
            ps.setInt(3, factura.getId_producto());
            ps.setInt(4, factura.getCantidad());
            ps.setInt(5, factura.getTipoTransaccion());
            ps.setInt(6, factura.getId_cliente());
            rs = ps.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
