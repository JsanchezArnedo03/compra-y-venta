/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Cliente;
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

public class ClienteCRUD {

    private final Connection con = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    Cliente cliente;

    public boolean crearCliente(Cliente cliente) {
        String sql = "call crearCliente(?,?,?,?,?,?,?);";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getPrimerNombre());
            ps.setString(3, cliente.getSegundoNombre());
            ps.setString(4, cliente.getPrimerApellido());
            ps.setString(5, cliente.getSegundoApellido());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getEmail());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
        return false;
    }

    public Cliente ValidarExistencia(String documento) {
        try {
            String sql = "call validarExistencia(?);";
            ps = con.prepareCall(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setDocumento(rs.getString(2));
                cliente.setPrimerNombre(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
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

    public DefaultTableModel listadoClientes(JTable table) {
        String sql = "call cargarListados()";
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DOCUMENTO");
        model.addColumn("NOMBRE");
        model.addColumn("E-MAIL");
        model.addColumn("TELEFONO");
        try {
            ps = con.prepareCall(sql);
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
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

}
