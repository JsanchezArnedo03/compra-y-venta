/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.InformesCRUD;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author jssa3
 */
public class NegocioTransacciones {

    InformesCRUD iCRUD = new InformesCRUD();

    public DefaultComboBoxModel CargarComboTipoTransaccion(JComboBox d) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        d.setModel(combo);
        ArrayList<String> modelos = iCRUD.listadoTransaccion();
        combo.addElement("TIPO TRANSACCION");
        for (int i = 0; i < modelos.size(); i++) {

            combo.addElement(modelos.get(i));
        }
        return combo;
    }
}
