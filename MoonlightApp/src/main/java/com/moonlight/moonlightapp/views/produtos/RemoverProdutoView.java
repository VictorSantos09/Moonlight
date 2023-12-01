/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.produtos;

import javax.swing.JOptionPane;

import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.services.produtos.DeletarProdutoService;

/**
 *
 * @author victor.santos8
 */
public class RemoverProdutoView extends javax.swing.JFrame {
    private final ProdutoDAO produtoDAO;
    private final DeletarProdutoService deletarProdutoService;

    /**
     * Creates new form RemoverProdutoView
     */
    public RemoverProdutoView() {
        initComponents();
        produtoDAO = new ProdutoDAO();
        deletarProdutoService = new DeletarProdutoService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbProdutosParaRemover = new javax.swing.JComboBox<>();
        lblSelecioneProdutoParaRemover = new javax.swing.JLabel();
        lblRemoverProduto = new javax.swing.JLabel();
        btnConfirmarRemocaoProduto = new javax.swing.JButton();
        btnCancelarRemocaoProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cbProdutosParaRemover.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbProdutosParaRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutosParaRemoverActionPerformed(evt);
            }
        });

        lblSelecioneProdutoParaRemover.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneProdutoParaRemover.setText("Selecione o Produto");

        lblRemoverProduto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRemoverProduto.setText("Remover Produto");

        btnConfirmarRemocaoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConfirmarRemocaoProduto.setText("Confirmar");
        btnConfirmarRemocaoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarRemocaoProdutoActionPerformed(evt);
            }
        });

        btnCancelarRemocaoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelarRemocaoProduto.setText("Cancelar");
        btnCancelarRemocaoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRemocaoProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRemoverProduto)
                    .addComponent(lblSelecioneProdutoParaRemover)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnConfirmarRemocaoProduto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarRemocaoProduto))
                        .addComponent(cbProdutosParaRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblRemoverProduto)
                .addGap(48, 48, 48)
                .addComponent(lblSelecioneProdutoParaRemover)
                .addGap(18, 18, 18)
                .addComponent(cbProdutosParaRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarRemocaoProduto)
                    .addComponent(btnCancelarRemocaoProduto))
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbProdutosParaRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutosParaRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProdutosParaRemoverActionPerformed

    private void btnCancelarRemocaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarRemocaoProdutoActionPerformed
        this.setVisible(false);
        this.dispose();
    }// GEN-LAST:event_btnCancelarRemocaoProdutoActionPerformed

    private void btnConfirmarRemocaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConfirmarRemocaoProdutoActionPerformed
        String[] opcoes = { "NÃO", "SIM" };
        var selecao = JOptionPane.showOptionDialog(null, "Deseja confirmar a remoção do produto?", "Confirmar",
                0, 3, null, opcoes, opcoes[0]);

        if (selecao == 1) {
            var produtoSelecionado = (ProdutoModel) cbProdutosParaRemover.getSelectedItem();

            if (produtoSelecionado == null) {
                JOptionPane.showMessageDialog(null, "Selecione um produto");
            }

            var resultado = deletarProdutoService.deletar(produtoSelecionado.getNome());

            JOptionPane.showMessageDialog(null, resultado.getMensagem());
            btnCancelarRemocaoProdutoActionPerformed(evt);
        }

        else {
            JOptionPane.showMessageDialog(null, "Remoção cancelada");
        }
    }// GEN-LAST:event_btnConfirmarRemocaoProdutoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        cbProdutosParaRemover.removeAllItems();
        var produtos = produtoDAO.buscarTodos();

        produtos.forEach(produto -> {
            cbProdutosParaRemover.addItem(produto);
        });
    }// GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(RemoverProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemoverProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemoverProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemoverProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemoverProdutoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarRemocaoProduto;
    private javax.swing.JButton btnConfirmarRemocaoProduto;
    private javax.swing.JComboBox<ProdutoModel> cbProdutosParaRemover;
    private javax.swing.JLabel lblRemoverProduto;
    private javax.swing.JLabel lblSelecioneProdutoParaRemover;
    // End of variables declaration//GEN-END:variables
}
