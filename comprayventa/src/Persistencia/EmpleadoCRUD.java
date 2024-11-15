/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Cargo;
import entidades.Empleado;
import entidades.TipoDocumento;
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
public class EmpleadoCRUD {

    Connection con = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    Empleado empleado;

    public boolean crearEmpleado(Empleado empleado) {
        try {
            String sql = "call crearEmpleado(?,?,?,?,?,?,?,?,?);";
            ps = con.prepareCall(sql);
            ps.setString(1, empleado.getDocumento());
            ps.setString(2, empleado.getPrimerNombre());
            ps.setString(3, empleado.getSegundoNombre());
            ps.setString(4, empleado.getPrimerApellido());
            ps.setString(5, empleado.getSegundoApellido());
            ps.setString(6, empleado.getTelefono());
            ps.setString(7, empleado.getEmail());
            ps.setInt(8, empleado.getCargoFK());
            ps.setBoolean(9, empleado.isEstado());
            rs = ps.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Empleado validarExistencia(String Documento) {
        try {
            String sql = "SELECT * FROM EMPLEADO WHERE DOCUMENTO = ?";
            ps = con.prepareCall(sql);
            ps.setString(1, Documento);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt(1));
                empleado.setDocumento(rs.getString(2));
                empleado.setPrimerNombre(rs.getString(3));
                empleado.setSegundoNombre(rs.getString(4));
                empleado.setPrimerApellido(rs.getString(5));
                empleado.setSegundoApellido(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleado;
    }

    public DefaultTableModel CargarTablaEmpleado(JTable b) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        b.setModel(model);
        try {
            String consultarExistencia = ("SELECT CONCAT(primerNombre,\" \",segundoNombre,\" \",primerApellido,\" \",segundoApellido)'empleado' FROM comprayventa.empleado;");
            ps = con.prepareCall(consultarExistencia);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object rowData = new Object[]{
                    rs.getObject(1)};
                model.addRow((Object[]) rowData);
            }
            b.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }

    public ArrayList CargarTipoDocumento() {
        ArrayList<String> listadoDocumentos = null;
        String sql = "call comboTipoDocumento();";
        try {
            ps = con.prepareCall(sql);
            listadoDocumentos = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDocumento tDocumento = new TipoDocumento();
                tDocumento.setNombre(rs.getString(1));
                listadoDocumentos.add(tDocumento.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoDocumentos;
    }

    public ArrayList cargarComboCargo() {
        ArrayList<String> listadoCargos = null;
        try {
            String sql = "call CargarComboCargo();";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            listadoCargos = new ArrayList<>();
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setNombre(rs.getString(1));
                listadoCargos.add(cargo.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoCargos;
    }
}
