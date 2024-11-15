/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.EmpleadoCRUD;
import entidades.Empleado;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author jssa3
 */
public class NegocioEmpleado {

    EmpleadoCRUD eCRUD = new EmpleadoCRUD();

    public boolean crearEmpleado(Empleado empleado) {
        return eCRUD.crearEmpleado(empleado);
    }

    public Empleado validarExistencia(String documento) {
        Empleado empleado = eCRUD.validarExistencia(documento);
        return empleado;
    }

    public DefaultComboBoxModel cargarTipoDocumento(JComboBox c) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        c.setModel(combo);
        combo.addElement("TIPO DOCUMENTO");
        ArrayList<String> listadoDocumento = eCRUD.CargarTipoDocumento();
        for (int i = 0; i < listadoDocumento.size(); i++) {
            combo.addElement(listadoDocumento.get(i));
        }
        return combo;
    }

    public DefaultComboBoxModel cargarComboCargos(JComboBox e) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        e.setModel(combo);
        combo.addElement("SELECCION EL CARGO");
        ArrayList<String> listadoCargos = eCRUD.cargarComboCargo();
        for (int i = 0; i < listadoCargos.size(); i++) {
            combo.addElement(listadoCargos.get(i));
        }
        return combo;
    }
}
