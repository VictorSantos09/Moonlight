/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.produtos;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.moonlight.moonlightapp.daos.ItensProdutoDAO;
import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.dtos.produtos.AtualizarItemProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.AtualizarProcessoProdutoDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.services.produtos.AtualizarProdutoItemService;
import com.moonlight.moonlightapp.services.produtos.BuscarProdutoService;

/**
 *
 * @author victor.santos8
 */
public class AtualizarProdutoItensView extends javax.swing.JFrame {
    private final BuscarProdutoService buscarProdutoService;
    private final AtualizarProdutoItemService atualizarProdutoItemService;
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final ItensProdutoDAO itensProdutoDAO;

    /**
     * Creates new form AtualizarProdutoItensView
     */
    public AtualizarProdutoItensView() {
        buscarProdutoService = new BuscarProdutoService();
        atualizarProdutoItemService = new AtualizarProdutoItemService();
        materiaPrimaDAO = new MateriaPrimaDAO();
        itensProdutoDAO = new ItensProdutoDAO();
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelecioneProduto = new javax.swing.JLabel();
        lblAtualizarItensProduto = new javax.swing.JLabel();
        cbProdutos = new javax.swing.JComboBox<>();
        lblAdicioneMateriasPrimas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMateriasPrimas = new javax.swing.JTable();
        lblMateriasPrimasAtuais = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMateriasPrimasAtuais = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Itens do Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblSelecioneProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneProduto.setText("Selecione o Produto");

        lblAtualizarItensProduto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAtualizarItensProduto.setText("Atualizar Itens do Produto");

        cbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbProdutos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProdutosItemStateChanged(evt);
            }
        });

        lblAdicioneMateriasPrimas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAdicioneMateriasPrimas.setText("Adicione as Matérias Primas");

        tbMateriasPrimas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Unidade Medida", "Tipo", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbMateriasPrimas);

        lblMateriasPrimasAtuais.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMateriasPrimasAtuais.setText("Matérias Primas Atuais");

        tbMateriasPrimasAtuais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Unidade Medida", "Tipo", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbMateriasPrimasAtuais);

        btnRemover.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addGap(40, 40, 40)
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btnRemover)
                                    .addComponent(btnAdicionar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblAtualizarItensProduto))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAdicioneMateriasPrimas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMateriasPrimasAtuais)))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelecioneProduto)
                            .addComponent(cbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblAtualizarItensProduto)
                .addGap(13, 13, 13)
                .addComponent(lblSelecioneProduto)
                .addGap(18, 18, 18)
                .addComponent(cbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMateriasPrimasAtuais)
                    .addComponent(lblAdicioneMateriasPrimas))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btnAdicionar)
                        .addGap(39, 39, 39)
                        .addComponent(btnRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnVoltar))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarActionPerformed
        setVisible(false);
        dispose();
    }// GEN-LAST:event_btnVoltarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConfirmarActionPerformed
        var quantidadeMateriasPrimasAtuais = tbMateriasPrimasAtuais.getRowCount();
        var produtoSelecionado = (ProdutoModel) cbProdutos.getSelectedItem();

        if (quantidadeMateriasPrimasAtuais <= 0) {
            JOptionPane.showMessageDialog(null, "adicione os processos");
        }

        else if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Selecione o produto");
        }

        else {
            Hashtable<String, Float> nomesMateriasPrimasQuantidade = new Hashtable<>();
            boolean isValido = true;

            for (int i = 0; i < quantidadeMateriasPrimasAtuais; i++) {
                String nomeMateriaPrima = tbMateriasPrimasAtuais.getValueAt(i, 0).toString();
                
                if ((Float) tbMateriasPrimasAtuais.getValueAt(i, 3) == null) {
                    JOptionPane.showMessageDialog(null,
                            "informe a quantidade para a matéria prima " + nomeMateriaPrima);
                    isValido = false;
                } else {
                    var quantidadeMateriaPrima = (Float) tbMateriasPrimasAtuais.getValueAt(i, 3);
                    nomesMateriasPrimasQuantidade.put(nomeMateriaPrima, quantidadeMateriaPrima);
                }
            }

            if (isValido) {
                var dto = new AtualizarItemProdutoDTO(produtoSelecionado.getNome(), nomesMateriasPrimasQuantidade);
                var resultadoAtualizacao = atualizarProdutoItemService.atualizar(dto);

                JOptionPane.showMessageDialog(null, resultadoAtualizacao.getMensagem());
                setVisible(false);
                dispose();
            }

        }
    }// GEN-LAST:event_btnConfirmarActionPerformed

    private void cbProdutosItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbProdutosItemStateChanged
        var produtoSelecionado = (ProdutoModel) cbProdutos.getSelectedItem();
        var itensProduto = itensProdutoDAO.buscarPorProdutoId(produtoSelecionado.getId());

        DefaultTableModel tabela = (DefaultTableModel) tbMateriasPrimasAtuais.getModel();
        tabela.setRowCount(0);

        itensProduto.forEach(ip -> {
            var materiaPrimaObj = new Object[] {
                    ip.getMateriaPrima().getNome(),
                    ip.getMateriaPrima().getUnidadeMedida().getNome(),
                    ip.getMateriaPrima().getTipoMateriaPrima().getNome(),
                    ip.getQuantidade()
            };

            tabela.addRow(materiaPrimaObj);
        });
    }// GEN-LAST:event_cbProdutosItemStateChanged

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdicionarActionPerformed
        var materiaPrimaSelecionadaIndex = tbMateriasPrimas.getSelectedRow();

        var nomeMateriaPrimaSelecionada = tbMateriasPrimas.getValueAt(materiaPrimaSelecionadaIndex, 0);
        var unidadeMedidaMateriaPrimaSelecionada = tbMateriasPrimas.getValueAt(materiaPrimaSelecionadaIndex, 1);
        var tipoMateriaPrimaSelecionada = tbMateriasPrimas.getValueAt(materiaPrimaSelecionadaIndex, 2);

        DefaultTableModel tabelaMateriasPrimasAtuais = (DefaultTableModel) tbMateriasPrimasAtuais.getModel();

        boolean isMateriaPrimaAdicionada = false;
        for (int i = 0; i < tabelaMateriasPrimasAtuais.getRowCount(); i++) {
            var nomeMateriaPrimaAtual = tabelaMateriasPrimasAtuais.getValueAt(i, 0).toString();
            if (nomeMateriaPrimaAtual.equals(nomeMateriaPrimaSelecionada)) {
                isMateriaPrimaAdicionada = true;
                JOptionPane.showMessageDialog(null, "matéria prima já adicionada");
                break;
            }
        }

        if (!isMateriaPrimaAdicionada) {

            var materiaPrimaObj = new Object[] {
                    nomeMateriaPrimaSelecionada,
                    unidadeMedidaMateriaPrimaSelecionada,
                    tipoMateriaPrimaSelecionada
            };

            tabelaMateriasPrimasAtuais.addRow(materiaPrimaObj);
        }
    }// GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRemoverActionPerformed
        var materiaPrimaSelecionadaIndex = tbMateriasPrimasAtuais.getSelectedRow();

        DefaultTableModel tabelaMateriasPrimasAtuais = (DefaultTableModel) tbMateriasPrimasAtuais.getModel();
        tabelaMateriasPrimasAtuais.removeRow(materiaPrimaSelecionadaIndex);
    }// GEN-LAST:event_btnRemoverActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        cbProdutos.removeAll();

        buscarProdutoService.buscarTodos().forEach(p -> {
            cbProdutos.addItem(p);
        });

        DefaultTableModel tabela = (DefaultTableModel) tbMateriasPrimas.getModel();
        tabela.setRowCount(0);

        materiaPrimaDAO.buscarTodos().forEach(m -> {
            var materiaPrimaObj = new Object[] {
                    m.getNome(),
                    m.getUnidadeMedida().getNome(),
                    m.getTipoMateriaPrima().getNome(),
                    m.getValor()
            };

            tabela.addRow(materiaPrimaObj);
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
            java.util.logging.Logger.getLogger(AtualizarProdutoItensView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutoItensView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutoItensView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutoItensView.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarProdutoItensView().setVisible(true);
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
    private javax.swing.JLabel lblAdicioneMateriasPrimas;
    private javax.swing.JLabel lblAtualizarItensProduto;
    private javax.swing.JLabel lblMateriasPrimasAtuais;
    private javax.swing.JLabel lblSelecioneProduto;
    private javax.swing.JTable tbMateriasPrimas;
    private javax.swing.JTable tbMateriasPrimasAtuais;
    // End of variables declaration//GEN-END:variables
}
