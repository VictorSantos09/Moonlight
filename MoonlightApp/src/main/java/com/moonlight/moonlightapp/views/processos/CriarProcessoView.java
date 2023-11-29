/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.processos;

import javax.swing.JOptionPane;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.services.processos.CriarProcessoService;
import com.moonlight.moonlightapp.validators.DefaultValidator;
/**
 *
 * @author pedro.janke
 */
public class CriarProcessoView extends javax.swing.JFrame {
    private final CriarProcessoService criarProcessoService;

    /**
     * Creates new form NewJFrame
     */
    public CriarProcessoView() {
        criarProcessoService = new CriarProcessoService();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        txtCusto = new javax.swing.JTextField();
        lblCusto = new javax.swing.JLabel();
        lblEtapa = new javax.swing.JLabel();
        txtEtapa = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Processo");

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalvar.setLabel("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtCusto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCusto.setToolTipText("");
        txtCusto.setVerifyInputWhenFocusTarget(false);
        txtCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustoActionPerformed(evt);
            }
        });

        lblCusto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCusto.setText("Custo");
        lblCusto.setMaximumSize(new java.awt.Dimension(51, 25));
        lblCusto.setMinimumSize(new java.awt.Dimension(51, 25));

        lblEtapa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEtapa.setText("Etapa");
        lblEtapa.setMaximumSize(new java.awt.Dimension(51, 25));
        lblEtapa.setMinimumSize(new java.awt.Dimension(51, 25));

        txtEtapa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEtapa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEtapaActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Criar Processo");
        lblTitulo.setMaximumSize(new java.awt.Dimension(51, 25));
        lblTitulo.setMinimumSize(new java.awt.Dimension(51, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        var tEtapa = txtEtapa.getText();
        var tCusto = 0d;
        try {
            tCusto = Double.parseDouble(txtCusto.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "informe o custo do processo");
        }
        if (DefaultValidator.isBlankOrEmpty(tEtapa)) {
            JOptionPane.showMessageDialog(null, "Informe a etapa");
        } else if (DefaultValidator.isZeroOrNegative(tCusto)) {
            JOptionPane.showMessageDialog(null, "Informe o custo da etapa");
        } else {

            var dto = new ProcessoDTO(tEtapa, tCusto);

            var resultado = criarProcessoService.criar(dto);

            JOptionPane.showMessageDialog(null, resultado.getMensagem());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustoActionPerformed

    private void txtEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEtapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEtapaActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CriarProcessoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarProcessoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarProcessoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarProcessoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarProcessoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCusto;
    private javax.swing.JLabel lblEtapa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JTextField txtEtapa;
    // End of variables declaration//GEN-END:variables
}
