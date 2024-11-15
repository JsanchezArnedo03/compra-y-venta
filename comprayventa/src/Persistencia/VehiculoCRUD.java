/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Marcas;
import entidades.Producto;
import java.sql.Connection;
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
public class VehiculoCRUD {

    Connection con = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    Marcas marca = new Marcas();
    Producto vehiculo = null;

    public boolean crearvehiculo(Producto vehiculo) {

        String sql = "call crearVehiculo(?,?,?,?,?,?,?);";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getPlaca());
            ps.setString(4, vehiculo.getDescripcion());
            ps.setFloat(5, vehiculo.getPrecio());
            ps.setFloat(6, vehiculo.getPrecioVenta());
            ps.setInt(7, vehiculo.getEstado());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public Producto validarExistencia(String placa) {
        try {
            String sql = "select id_producto from productos where placa = ?;";
            ps = con.prepareCall(sql);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            while (rs.next()) {
                vehiculo = new Producto();
                vehiculo.setIdProducto(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculo;
    }

    public DefaultTableModel buscarXmarca(int marca) {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        try {
            String sql = "SELECT MARCA,MODELO,PLACA,DESCRIPCION,PRECIO,ESTADO "
                    + "FROM PRODUCTOS WHERE id_producto = ?";
            ps = con.prepareCall(sql);
            ps.setInt(1, marca);
            rs = ps.executeQuery();
            model.addColumn("MARCA");
            model.addColumn("MODELO");
            model.addColumn("PLACA");
            model.addColumn("DESCRIPCION");
            model.addColumn("PRECIO");
            model.addColumn("ESTADO");
            while (rs.next()) {
                Object[] RowData = new Object[]{
                    rs.getObject(1).toString().toUpperCase(),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4),
                    rs.getObject(5),
                    rs.getObject(6)};
                model.addRow(RowData);
            }
            table.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public DefaultTableModel buscarXmodelo(int modelo) {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        try {
            String sql = "SELECT MARCA,MODELO,PLACA,DESCRIPCION,PRECIO,ESTADO FROM PRODUCTOS WHERE MODELO = ?";
            model.addColumn("MARCA");
            model.addColumn("MODELO");
            model.addColumn("PLACA");
            model.addColumn("DESCRIPCION");
            model.addColumn("PRECIO");
            model.addColumn("ESTADO");

            ps = con.prepareCall(sql);
            ps.setInt(1, modelo);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] RowData = new Object[]{
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4),
                    rs.getObject(5),
                    rs.getObject(6)};
                model.addRow(RowData);
            }
            table.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public DefaultTableModel listadoVehiculos(JTable table) {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id Producto");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Precio");
        table.setModel(model);
        try {
            String consultarExistencia = ("SELECT * FROM PRODUCTOS where estado !=2;");
            ps = con.prepareCall(consultarExistencia);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object rowData = new Object[]{
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4)};
                model.addRow((Object[]) rowData);
            }
            table.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public boolean vehiculoVendido(int estado, int idVehiculo) {
        String sql = "update productos set estado=? where id_producto = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, idVehiculo);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public ArrayList cargarComboModelos() {

        ArrayList<String> listadoModelos = new ArrayList<>();
        try {
            String sql = "call ComboModelo();";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                marca = new Marcas();
                marca.setModelo(rs.getString(1));
                listadoModelos.add(marca.getModelo());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoModelos;
    }

    public ArrayList cargarComboMarcas() {

        ArrayList<String> listadoMarcas = new ArrayList<>();
        try {
            String sql = "call ComboMarcas();";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                marca = new Marcas();
                marca.setNombre(rs.getString(1));
                listadoMarcas.add(marca.getNombre().toUpperCase());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoMarcas;
    }

}
