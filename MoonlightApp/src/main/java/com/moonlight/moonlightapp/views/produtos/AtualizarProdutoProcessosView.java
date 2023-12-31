/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.produtos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.daos.ProdutoProcessosDAO;
import com.moonlight.moonlightapp.dtos.produtos.AtualizarProcessoProdutoDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.services.produtos.AtualizarProdutoProcessoService;
import com.moonlight.moonlightapp.services.produtos.BuscarProdutoService;

/**
 *
 * @author victor.santos8
 */
public class AtualizarProdutoProcessosView extends javax.swing.JFrame {
        private final BuscarProdutoService buscarProdutoService;
        private final AtualizarProdutoProcessoService atualizarProdutoProcessoService;
        private final ProcessoDAO processoDAO;
        private final ProdutoProcessosDAO produtoProcessosDAO;

        /**
         * Creates new form AtualizarProdutoProcessosView
         */
        public AtualizarProdutoProcessosView() {
                buscarProdutoService = new BuscarProdutoService();
                atualizarProdutoProcessoService = new AtualizarProdutoProcessoService();
                processoDAO = new ProcessoDAO();
                produtoProcessosDAO = new ProdutoProcessosDAO();
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
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAtualizarProcessosProduto = new javax.swing.JLabel();
        lblSelecioneProduto = new javax.swing.JLabel();
        cbProdutos = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProcessos = new javax.swing.JTable();
        lblProcessosAtuais = new javax.swing.JLabel();
        lblSelecioneProcessos = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProcessosAtuais = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Processo do Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblAtualizarProcessosProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAtualizarProcessosProduto.setText("Atualizar Processos do Produto");

        lblSelecioneProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneProduto.setText("Selecione o Produto");

        cbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbProdutos.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbProdutos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProdutosItemStateChanged(evt);
            }
        });

        tbProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Etapa", "Custo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbProcessos);

        lblProcessosAtuais.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProcessosAtuais.setText("Processos Atuais");

        lblSelecioneProcessos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneProcessos.setText("Adicione os Processos");

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        tbProcessosAtuais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Etapa", "Custo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbProcessosAtuais);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConfirmar)
                                .addGap(30, 30, 30)
                                .addComponent(btnVoltar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSelecioneProcessos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblProcessosAtuais))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(77, 806, Short.MAX_VALUE)
                                .addComponent(lblAtualizarProcessosProduto)))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSelecioneProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btnRemover)
                                    .addComponent(btnAdicionar)))
                            .addComponent(cbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(528, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(629, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblAtualizarProcessosProduto)
                .addGap(24, 24, 24)
                .addComponent(lblSelecioneProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProcessosAtuais)
                    .addComponent(lblSelecioneProcessos))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionar)
                        .addGap(46, 46, 46)
                        .addComponent(btnRemover)
                        .addGap(199, 199, 199)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnConfirmar))
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(314, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(69, 69, 69)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRemoverActionPerformed
                var processoSelecionadoIndex = tbProcessosAtuais.getSelectedRow();

                DefaultTableModel tabelaProcessosAtuais = (DefaultTableModel) tbProcessosAtuais.getModel();
                tabelaProcessosAtuais.removeRow(processoSelecionadoIndex);

        }// GEN-LAST:event_btnRemoverActionPerformed

        private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdicionarActionPerformed
                var processoSelecionadoIndex = tbProcessos.getSelectedRow();

                var etapaProcessoSelecionado = tbProcessos.getValueAt(processoSelecionadoIndex, 0);
                var custoProcessoSelecionado = tbProcessos.getValueAt(processoSelecionadoIndex, 1);

                DefaultTableModel tabelaProcessosAtuais = (DefaultTableModel) tbProcessosAtuais.getModel();

                boolean isProcessoAdicionado = false;
                for (int i = 0; i < tabelaProcessosAtuais.getRowCount(); i++) {
                        var etapaProcessoAtual = tabelaProcessosAtuais.getValueAt(i, 0).toString();
                        if (etapaProcessoAtual.equals(etapaProcessoSelecionado)) {
                                isProcessoAdicionado = true;
                                JOptionPane.showMessageDialog(null, "processo já adicionado");
                                break;
                        }
                }

                if (!isProcessoAdicionado) {

                        var processoObj = new Object[] {
                                        etapaProcessoSelecionado,
                                        custoProcessoSelecionado
                        };

                        tabelaProcessosAtuais.addRow(processoObj);
                }

        }// GEN-LAST:event_btnAdicionarActionPerformed

        private void cbProdutosItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbProdutosItemStateChanged
                var produtoSelecionado = (ProdutoModel) cbProdutos.getSelectedItem();

                var processosProduto = produtoProcessosDAO.buscarProcessosPorProdutoId(produtoSelecionado.getId());

                DefaultTableModel tabelaProcessosAtuais = (DefaultTableModel) tbProcessosAtuais.getModel();
                tabelaProcessosAtuais.setRowCount(0);

                processosProduto.forEach(processo -> {
                        Object[] processoObj = new Object[] {
                                        processo.getEtapa(),
                                        processo.getCusto()
                        };

                        tabelaProcessosAtuais.addRow(processoObj);
                });
        }// GEN-LAST:event_cbProdutosItemStateChanged

        private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarActionPerformed
                this.setVisible(false);
                this.dispose();
        }// GEN-LAST:event_btnVoltarActionPerformed

        private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConfirmarActionPerformed
                var quantidadeProcessosAtuais = tbProcessosAtuais.getRowCount();
                var produtoSelecionado = (ProdutoModel) cbProdutos.getSelectedItem();

                if (quantidadeProcessosAtuais <= 0) {
                        JOptionPane.showMessageDialog(null, "adicione os processos");
                }

                else if (produtoSelecionado == null) {
                        JOptionPane.showMessageDialog(null, "Selecione o produto");
                }

                else {
                        List<String> etapas = new ArrayList<>();

                        for (int i = 0; i < quantidadeProcessosAtuais; i++) {
                                String etapa = tbProcessosAtuais.getValueAt(i, 0).toString();
                                etapas.add(etapa);
                        }

                        var dto = new AtualizarProcessoProdutoDTO(produtoSelecionado.getNome(), etapas);
                        var resultadoAtualizacao = atualizarProdutoProcessoService.atualizar(dto);

                        JOptionPane.showMessageDialog(null, resultadoAtualizacao.getMensagem());
                        setVisible(false);
                        dispose();
                }
        }// GEN-LAST:event_btnConfirmarActionPerformed

        private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
                cbProdutos.removeAll();
                tbProcessos.removeAll();
                tbProcessosAtuais.removeAll();

                buscarProdutoService.buscarTodos().forEach(produto -> cbProdutos.addItem(produto));

                DefaultTableModel tabelaProcessos = (DefaultTableModel) tbProcessos.getModel();
                tabelaProcessos.setRowCount(0);

                processoDAO.buscarTodos().forEach(processo -> {
                        Object[] processoObj = new Object[] {
                                        processo.getEtapa(),
                                        processo.getCusto()
                        };

                        tabelaProcessos.addRow(processoObj);
                });

                var produtoSelecionado = (ProdutoModel) cbProdutos.getSelectedItem();

                var processosProduto = produtoProcessosDAO.buscarProcessosPorProdutoId(produtoSelecionado.getId());

                DefaultTableModel tabelaProcessosAtuais = (DefaultTableModel) tbProcessosAtuais.getModel();
                tabelaProcessosAtuais.setRowCount(0);

                processosProduto.forEach(processo -> {
                        Object[] processoObj = new Object[] {
                                        processo.getEtapa(),
                                        processo.getCusto()
                        };

                        tabelaProcessosAtuais.addRow(processoObj);
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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(AtualizarProdutoProcessosView.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(AtualizarProdutoProcessosView.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(AtualizarProdutoProcessosView.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(AtualizarProdutoProcessosView.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new AtualizarProdutoProcessosView().setVisible(true);
                        }
                });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<ProdutoModel> cbProdutos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAtualizarProcessosProduto;
    private javax.swing.JLabel lblProcessosAtuais;
    private javax.swing.JLabel lblSelecioneProcessos;
    private javax.swing.JLabel lblSelecioneProduto;
    private javax.swing.JTable tbProcessos;
    private javax.swing.JTable tbProcessosAtuais;
    // End of variables declaration//GEN-END:variables
}
