/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.VehiculoCRUD;
import entidades.Producto;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;/**
 *
 * @author jssa3
 */
public class VehiculoNegocio {

    VehiculoCRUD vCRUD = new VehiculoCRUD();

    public boolean CrearVehiculo(Producto vehiculo) {
        return vCRUD.crearvehiculo(vehiculo);
    }

    public Producto validarExistenciaXplaca(String placa) {
        return vCRUD.validarExistencia(placa);
    }

    public DefaultComboBoxModel cargarComboMarcas(JComboBox c) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        c.setModel(combo);
        ArrayList<String> marcas = vCRUD.cargarComboMarcas();
        combo.addElement("MARCAS");
        for (int i = 0; i < marcas.size(); i++) {
            combo.addElement(marcas.get(i));
        }
        return combo;
    }

    public DefaultComboBoxModel cargarComboModelo(JComboBox d) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        d.setModel(combo);
        ArrayList<String> modelos = vCRUD.cargarComboModelos();
        combo.addElement("MODELOS");
        for (int i = 0; i < modelos.size(); i++) {
            combo.addElement(modelos.get(i));
        }
        return combo;
    }

    public boolean vehiculoVendido(int estado, int idVehiculo) {
        return vCRUD.vehiculoVendido(estado, idVehiculo);
    }
}
