/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Persistencia.InformesCRUD;
import Validadaciones.InformeNegocio;
import Validadaciones.NegocioEmpleado;
import entidades.Empleado;
import Validadaciones.NegocioTransacciones;
import entidades.Filtro;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class FrmInformes extends javax.swing.JFrame {

    NegocioTransacciones nTransaccion = new NegocioTransacciones();
    Empleado empleado;
    NegocioEmpleado eNegocio = new NegocioEmpleado();
    InformeNegocio iNegocio = new InformeNegocio();
    InformesCRUD iCRUD = new InformesCRUD();
    Integer tipoTransaccion;
    Filtro filtro;

    public FrmInformes() {
        initComponents();
        CargarComboTipoTransaccion(jcTipodeInforme);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnInicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInformes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtDocumentoVendedor = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jcTipodeInforme = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        dateInicioBusqueda = new com.toedter.calendar.JDateChooser();
        dateFinBusqueda = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_ganancia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        BtnInicio.setText("INICIO");
        BtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicioActionPerformed(evt);
            }
        });

        tbInformes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbInformes);

        jLabel2.setText("BUSQUEDA POR VENDEDOR");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jcTipodeInforme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("TIPO DE TRANSACCION");

        jLabel3.setText("DESDE: ");

        jLabel4.setText("HASTA:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("GANANCIA:");

        lbl_ganancia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_ganancia.setText("0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BtnInicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumentoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(jcTipodeInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateInicioBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(dateFinBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_ganancia)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BtnInicio)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateInicioBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFinBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcTipodeInforme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_ganancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDocumentoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInicioActionPerformed
        this.setVisible(false);
        FrmPrincipal fp = new FrmPrincipal(0);
        fp.setVisible(true);
        fp.setLocationRelativeTo(null);
    }//GEN-LAST:event_BtnInicioActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filtrar();
        limpiar();
    }//GEN-LAST:event_btnBuscarActionPerformed
    final void CargarComboTipoTransaccion(JComboBox e) {
        nTransaccion.CargarComboTipoTransaccion(e);
    }

    void limpiar() {
        txtDocumentoVendedor.setText("");
        jcTipodeInforme.setSelectedIndex(0);
    }

    void filtrar() {
        filtro = new Filtro();
        empleado = new Empleado();
        tipoTransaccion = jcTipodeInforme.getSelectedIndex();
        if (dateInicioBusqueda.getDate()
                != null && dateFinBusqueda.getDate()
                != null && jcTipodeInforme.getSelectedIndex() != 0 && !txtDocumentoVendedor.getText().isEmpty()) {
            empleado.setDocumento(txtDocumentoVendedor.getText());
            java.sql.Date fechaInicio = new java.sql.Date(dateInicioBusqueda.getDate().getTime());
            java.sql.Date fechaFin = new java.sql.Date(dateFinBusqueda.getDate().getTime());
            filtro.setFechaIncio(fechaInicio);
            filtro.setFechaFin(fechaFin);
            filtro.setTipo_Transaccion(jcTipodeInforme.getSelectedIndex());
            filtro.setDocumentoEmpleado(empleado);
            tbInformes.setModel(iCRUD.InformeGeneral(filtro));
            System.out.println(filtro.getDocumentoEmpleado().getDocumento());
        } else if (txtDocumentoVendedor.getText().isEmpty()
                && dateInicioBusqueda.getDate() == null && dateFinBusqueda.getDate() == null
                && jcTipodeInforme.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBE TENER ALGUN PARAMETRO DE BUSQUEDA", "FOMATO INVALIDO", 2);
        } else if (!txtDocumentoVendedor.getText().isEmpty()) {
            empleado = eNegocio.validarExistencia(txtDocumentoVendedor.getText());
            if (empleado != null) {
                tbInformes.setModel(iCRUD.reporteXVendedor(empleado));
                lbl_ganancia.setText(String.valueOf(iCRUD.mostrar_ganancia(txtDocumentoVendedor.getText(),tipoTransaccion)));
            } else {
                JOptionPane.showMessageDialog(rootPane, "EL EMPLEADO NO EXISTE", "ESPERA", 2);
            }
        } else if (jcTipodeInforme.getSelectedIndex() != 0) {
            tipoTransaccion = jcTipodeInforme.getSelectedIndex();
            tbInformes.setModel(iCRUD.informe_transaccion(txtDocumentoVendedor.getText(), tipoTransaccion));
            lbl_ganancia.setText(String.valueOf(iNegocio.validaciones(txtDocumentoVendedor.getText(),tipoTransaccion)));
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInformes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmInformes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInicio;
    private javax.swing.JButton btnBuscar;
    private com.toedter.calendar.JDateChooser dateFinBusqueda;
    private com.toedter.calendar.JDateChooser dateInicioBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcTipodeInforme;
    private javax.swing.JLabel lbl_ganancia;
    private javax.swing.JTable tbInformes;
    private javax.swing.JTextField txtDocumentoVendedor;
    // End of variables declaration//GEN-END:variables
}
