/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.materiaprimas;

import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.TipoMateriaPrimaModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.services.materiasprimas.BuscarMateriaPrimaService;

/**
 *
 * @author amanda.medeiros1
 */
public class AtualizarMateriaPrimaView extends javax.swing.JFrame {

    /**
     * Creates new form AtualizarMateriaPrimaView
     */

    private final BuscarMateriaPrimaService buscarMateriaPrimaService = new BuscarMateriaPrimaService();
    private final UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();
    private MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();

    public AtualizarMateriaPrimaView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        btnVoltar = new javax.swing.JButton();
        lblAtualizarMateriaPrima = new javax.swing.JLabel();
        lblNomeMateriaPrima = new javax.swing.JLabel();
        lblDescricaoMateriaPrima = new javax.swing.JLabel();
        lblTipoMateriaPrima = new javax.swing.JLabel();
        lblValorMateriaPrima = new javax.swing.JLabel();
        lblUnidadeMedidaMateriaPrima = new javax.swing.JLabel();
        cbTipoMateriaPrima = new javax.swing.JComboBox<>();
        TxtDescricaoMateriaPrima = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        cbSelecionarMateriaPrima = new javax.swing.JComboBox<>();
        txtNomeMateriaPrima = new javax.swing.JTextField();
        txtValorMateriaPrima = new javax.swing.JTextField();
        cbUnidadeMedidaMateriaPrima = new javax.swing.JComboBox<>();
        lblSelecioneMateriaPrima = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblAtualizarMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAtualizarMateriaPrima.setText("Atualizar Matéria-Prima");

        lblNomeMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNomeMateriaPrima.setText("Nome");

        lblDescricaoMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDescricaoMateriaPrima.setText("Descrição");

        lblTipoMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTipoMateriaPrima.setText("Tipo");

        lblValorMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblValorMateriaPrima.setText("Valor");

        lblUnidadeMedidaMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUnidadeMedidaMateriaPrima.setText("Unidade Medida");

        TxtDescricaoMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDescricaoMateriaPrimaActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        cbUnidadeMedidaMateriaPrima.setModel(new javax.swing.DefaultComboBoxModel<>());

        lblSelecioneMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneMateriaPrima.setText("Atualizar Matéria-Prima");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblNomeMateriaPrima)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblDescricaoMateriaPrima)
                                                        .addComponent(lblUnidadeMedidaMateriaPrima))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbSelecionarMateriaPrima,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 291,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblTipoMateriaPrima)
                                                        .addComponent(lblValorMateriaPrima))
                                                .addGap(101, 101, 101)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(btnAtualizar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 112,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(55, 55, 55)
                                                                .addComponent(btnVoltar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 103,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(TxtDescricaoMateriaPrima)
                                                                                .addComponent(txtNomeMateriaPrima,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        312, Short.MAX_VALUE))
                                                                        .addComponent(cbUnidadeMedidaMateriaPrima,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                217,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cbTipoMateriaPrima,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                217,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtValorMateriaPrima,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                217,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        68, Short.MAX_VALUE)
                                                                .addComponent(lblAtualizarMateriaPrima)
                                                                .addContainerGap())))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSelecioneMateriaPrima)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(txtNomeMateriaPrima,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(37, 37, 37))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(34, 34, 34)
                                                                .addComponent(lblNomeMateriaPrima))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addComponent(lblAtualizarMateriaPrima)))
                                                .addGap(57, 57, 57)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDescricaoMateriaPrima)
                                        .addComponent(TxtDescricaoMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtValorMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblValorMateriaPrima))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSelecioneMateriaPrima)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(cbUnidadeMedidaMateriaPrima,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 25,
                                                                Short.MAX_VALUE)
                                                        .addComponent(cbSelecionarMateriaPrima))
                                                .addGap(33, 33, 33)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbTipoMateriaPrima,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblTipoMateriaPrima)))
                                        .addComponent(lblUnidadeMedidaMateriaPrima))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 45,
                                                Short.MAX_VALUE)
                                        .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(67, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnVoltarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnAtualizarActionPerformed

    private void TxtDescricaoMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtDescricaoMateriaPrimaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_TxtDescricaoMateriaPrimaActionPerformed

    private void cbMateriaPrimaItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbMateriaPrimaItemStateChanged
        // TODO add your handling code here:
    }// GEN-LAST:event_cbMateriaPrimaItemStateChanged

    private void btnAtualizarMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAtualizarMateriaPrimaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnAtualizarMateriaPrimaActionPerformed

    private void btnVoltarMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarMateriaPrimaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnVoltarMateriaPrimaActionPerformed

    private void cbUnidadesMedidasMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbUnidadesMedidasMateriaPrimaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbUnidadesMedidasMateriaPrimaActionPerformed

    private void cbMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbMateriaPrimaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbMateriaPrimaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtualizarMateriaPrimaView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarMateriaPrimaView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarMateriaPrimaView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarMateriaPrimaView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarMateriaPrimaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtDescricaoMateriaPrima;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<MateriaPrimaModel> cbSelecionarMateriaPrima;
    private javax.swing.JComboBox<TipoMateriaPrimaModel> cbTipoMateriaPrima;
    private javax.swing.JComboBox<UnidadeMedidaModel> cbUnidadeMedidaMateriaPrima;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel lblAtualizarMateriaPrima;
    private javax.swing.JLabel lblDescricaoMateriaPrima;
    private javax.swing.JLabel lblNomeMateriaPrima;
    private javax.swing.JLabel lblSelecioneMateriaPrima;
    private javax.swing.JLabel lblTipoMateriaPrima;
    private javax.swing.JLabel lblUnidadeMedidaMateriaPrima;
    private javax.swing.JLabel lblValorMateriaPrima;
    private javax.swing.JTextField txtNomeMateriaPrima;
    private javax.swing.JTextField txtValorMateriaPrima;
    // End of variables declaration//GEN-END:variables
}