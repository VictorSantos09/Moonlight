/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.principal;

import com.moonlight.moonlightapp.services.produtos.DeletarProdutoService;
import com.moonlight.moonlightapp.views.produtos.AtualizarProdutoProcessosView;
import com.moonlight.moonlightapp.views.produtos.AtualizarProdutoView;
import com.moonlight.moonlightapp.views.produtos.CriarProdutoView;
import com.moonlight.moonlightapp.views.produtos.RemoverProdutoView;
import com.moonlight.moonlightapp.views.produtos.VisualizarProdutoView;
import com.moonlight.moonlightapp.views.relatorios.RelatorioView;

/**
 *
 * @author victor.santos8
 */
public class MenuPrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipalView
     */
    public MenuPrincipalView() {
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

        lblMoonlight = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        lblDicaMenuSuperior = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnAdicionarProduto = new javax.swing.JMenuItem();
        mnVisualizarProdutos = new javax.swing.JMenuItem();
        mnRemoverProduto = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnAtualizarProduto = new javax.swing.JMenuItem();
        mnAtualizarProcessos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mnRelatorio = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnVisualizarTipoProduto = new javax.swing.JMenuItem();
        mnVisualizarTipoMateriaPrima = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMoonlight.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblMoonlight.setText("Moonlight");

        lblBemVindo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblBemVindo.setText("Bem Vindo(a)");

        lblDicaMenuSuperior.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblDicaMenuSuperior.setText("Acesse o menu superior para ver as funcionalidades");

        jMenu1.setText("Produto");

        mnAdicionarProduto.setText("Adicionar");
        mnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAdicionarProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(mnAdicionarProduto);

        mnVisualizarProdutos.setText("Visualizar");
        mnVisualizarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVisualizarProdutosActionPerformed(evt);
            }
        });
        jMenu1.add(mnVisualizarProdutos);

        mnRemoverProduto.setText("Remover");
        mnRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRemoverProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(mnRemoverProduto);
        jMenu1.add(jSeparator1);

        mnAtualizarProduto.setText("Atualizar");
        mnAtualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAtualizarProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(mnAtualizarProduto);

        mnAtualizarProcessos.setText("Atualizar Processos");
        mnAtualizarProcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAtualizarProcessosActionPerformed(evt);
            }
        });
        jMenu1.add(mnAtualizarProcessos);

        jMenuItem2.setText("Atualizar Matérias Primas");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Matéria Prima");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Processos");
        jMenuBar1.add(jMenu3);

        mnRelatorio.setText("Relatório");
        mnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRelatorioActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Consultar");
        mnRelatorio.add(jMenuItem5);

        jMenuBar1.add(mnRelatorio);

        jMenu5.setText("Tipos");

        mnVisualizarTipoProduto.setText("Visualizar Produto");
        mnVisualizarTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVisualizarTipoProdutoActionPerformed(evt);
            }
        });
        jMenu5.add(mnVisualizarTipoProduto);

        mnVisualizarTipoMateriaPrima.setText("Visualizar Matéria Prima");
        jMenu5.add(mnVisualizarTipoMateriaPrima);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Unidades Medidas");

        jMenuItem6.setText("Consultar");
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(lblMoonlight)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(lblDicaMenuSuperior)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lblBemVindo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(lblBemVindo)
                .addGap(18, 18, 18)
                .addComponent(lblMoonlight)
                .addGap(18, 18, 18)
                .addComponent(lblDicaMenuSuperior)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRelatorioActionPerformed
       RelatorioView view = new RelatorioView();
       view.setVisible(true);
    }//GEN-LAST:event_mnRelatorioActionPerformed

    private void mnVisualizarTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVisualizarTipoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnVisualizarTipoProdutoActionPerformed

    private void mnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAdicionarProdutoActionPerformed
        CriarProdutoView view = new CriarProdutoView();
        view.setVisible(true);
    }//GEN-LAST:event_mnAdicionarProdutoActionPerformed

    private void mnVisualizarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVisualizarProdutosActionPerformed
        VisualizarProdutoView view = new VisualizarProdutoView();
        view.setVisible(true);
    }//GEN-LAST:event_mnVisualizarProdutosActionPerformed

    private void mnAtualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAtualizarProdutoActionPerformed
        AtualizarProdutoView view = new AtualizarProdutoView();
        view.setVisible(true);
    }//GEN-LAST:event_mnAtualizarProdutoActionPerformed

    private void mnRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRemoverProdutoActionPerformed
        RemoverProdutoView view = new RemoverProdutoView();
        view.setVisible(true);
    }//GEN-LAST:event_mnRemoverProdutoActionPerformed

    private void mnAtualizarProcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAtualizarProcessosActionPerformed
        AtualizarProdutoProcessosView view = new AtualizarProdutoProcessosView();
        view.setVisible(true);
    }//GEN-LAST:event_mnAtualizarProcessosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblDicaMenuSuperior;
    private javax.swing.JLabel lblMoonlight;
    private javax.swing.JMenuItem mnAdicionarProduto;
    private javax.swing.JMenuItem mnAtualizarProcessos;
    private javax.swing.JMenuItem mnAtualizarProduto;
    private javax.swing.JMenu mnRelatorio;
    private javax.swing.JMenuItem mnRemoverProduto;
    private javax.swing.JMenuItem mnVisualizarProdutos;
    private javax.swing.JMenuItem mnVisualizarTipoMateriaPrima;
    private javax.swing.JMenuItem mnVisualizarTipoProduto;
    // End of variables declaration//GEN-END:variables
}
