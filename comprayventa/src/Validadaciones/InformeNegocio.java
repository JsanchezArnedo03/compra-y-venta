/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.InformesCRUD;
import entidades.Filtro;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jssa3
 */
public class InformeNegocio {

    InformesCRUD iCRUD = new InformesCRUD();

    public int validaciones(String documento,int tipoTransaccion) {
        return iCRUD.mostrar_ganancia(documento,tipoTransaccion);
    }

    public DefaultTableModel informeXFechasYTipoTransaccion(Filtro filtro) {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        table.setModel(iCRUD.InformeXfechas(filtro));
        return model;
    }

    public void informe_transaccion(String documento, int tipo_transaccion) {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        table.setModel(iCRUD.informe_transaccion(documento, tipo_transaccion));
    }
}
