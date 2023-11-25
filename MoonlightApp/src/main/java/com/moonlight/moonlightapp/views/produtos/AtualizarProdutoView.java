/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.produtos;

import javax.swing.JOptionPane;

import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.produtos.AtualizarInformacoesProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.TipoProdutoDTO;
import com.moonlight.moonlightapp.dtos.unidadesmedidas.UnidadeMedidaDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.TipoProdutoModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.services.produtos.AtualizarProdutoInformacoesService;

/**
 *
 * @author victor.santos8
 */
public class AtualizarProdutoView extends javax.swing.JFrame {
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final ProdutoDAO produtoDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final AtualizarProdutoInformacoesService atualizarProdutoInformacoesService;

    /**
     * Creates new form AtualizarProdutoView
     */
    public AtualizarProdutoView() {
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        produtoDAO = new ProdutoDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
        atualizarProdutoInformacoesService = new AtualizarProdutoInformacoesService();
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

        lblNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblDescricao = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblUnidadeMedida = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        cbUnidadesMedidas = new javax.swing.JComboBox<>();
        cbTipo = new javax.swing.JComboBox<>();
        lblAtualizarProduto = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblSelecioneProduto = new javax.swing.JLabel();
        cbProdutos = new javax.swing.JComboBox<>();
        btnAtualizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNome.setText("Nome");

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDescricao.setText("Descrição");

        lblValor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblValor.setText("Valor");

        lblUnidadeMedida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUnidadeMedida.setText("Unidade Medida");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTipo.setText("Tipo");

        cbUnidadesMedidas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbUnidadesMedidas.setModel(
                new javax.swing.DefaultComboBoxModel<>());

        cbTipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTipo.setModel(
                new javax.swing.DefaultComboBoxModel<>());

        lblAtualizarProduto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAtualizarProduto.setText("Atualizar Produto");

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblSelecioneProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneProduto.setText("Selecione o Produto");

        cbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbProdutos.setModel(
                new javax.swing.DefaultComboBoxModel<>());
        cbProdutos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProdutosItemStateChanged(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblTipo)
                                                .addGap(120, 120, 120)
                                                .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblValor)
                                                .addGap(55, 55, 55)
                                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 167,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblUnidadeMedida)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbUnidadesMedidas, 0,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblDescricao)
                                                        .addComponent(lblNome))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(txtNome))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAtualizarProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(btnAtualizar)
                                                        .addGap(40, 40, 40)
                                                        .addComponent(btnVoltar))
                                        .addComponent(lblSelecioneProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cbProdutos, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 321,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAtualizarProduto)
                                        .addComponent(lblNome)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblSelecioneProduto)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblDescricao)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblValor)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUnidadeMedida)
                                        .addComponent(cbUnidadesMedidas, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTipo)
                                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAtualizar)
                                        .addComponent(btnVoltar))
                                .addGap(31, 31, 31)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbProdutosItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbProdutosItemStateChanged
        var produtoSelecionado = (ProdutoModel) cbProdutos.getSelectedItem();

        txtDescricao.setText(produtoSelecionado.getDescricao());
        txtNome.setText(produtoSelecionado.getNome());
        txtValor.setText(String.valueOf(produtoSelecionado.getValorProduto().getValor()));
        
        cbTipo.getModel().setSelectedItem(produtoSelecionado.getTipo());
        cbTipo.setSelectedItem(produtoSelecionado.getTipo());
        cbUnidadesMedidas.getModel().setSelectedItem(produtoSelecionado.getUnidadeMedida());
    }// GEN-LAST:event_cbProdutosItemStateChanged

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
        this.dispose();
    }// GEN-LAST:event_btnVoltarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAtualizarActionPerformed
        var produtoOriginal = (ProdutoModel) cbProdutos.getSelectedItem();

        var unidadeMedida = (UnidadeMedidaModel) cbUnidadesMedidas.getSelectedItem();
        var tipoProduto = (TipoProdutoModel) cbTipo.getSelectedItem();

        var unidadeMedidaDto = new UnidadeMedidaDTO(unidadeMedida.getNome());
        var tipoProdutoDto = new TipoProdutoDTO(tipoProduto.getNome());

        var dto = new AtualizarInformacoesProdutoDTO(txtNome.getText(), produtoOriginal.getNome(),
                txtDescricao.getText(),
                unidadeMedidaDto, tipoProdutoDto, Double.parseDouble(txtValor.getText()));

        var resultadoAtualizacao = atualizarProdutoInformacoesService.atualizar(dto);
        JOptionPane.showMessageDialog(null, resultadoAtualizacao.getMensagem());
        
        this.setVisible(false);
        this.dispose();
    }// GEN-LAST:event_btnAtualizarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        cbProdutos.removeAll();
        cbTipo.removeAll();
        cbUnidadesMedidas.removeAll();

        produtoDAO.buscarTodos().forEach(produto -> cbProdutos.addItem(produto));
        tipoProdutoDAO.buscarTodos().forEach(tipo -> cbTipo.addItem(tipo));
        unidadeMedidaDAO.buscarTodos().forEach(unidade -> cbUnidadesMedidas.addItem(unidade));

        var produtoSelecionado = (ProdutoModel) cbProdutos.getSelectedItem();
        cbTipo.setSelectedItem(produtoSelecionado.getTipo());
        cbUnidadesMedidas.setSelectedItem(produtoSelecionado.getUnidadeMedida());
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
            java.util.logging.Logger.getLogger(AtualizarProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarProdutoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<ProdutoModel> cbProdutos;
    private javax.swing.JComboBox<TipoProdutoModel> cbTipo;
    private javax.swing.JComboBox<UnidadeMedidaModel> cbUnidadesMedidas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtualizarProduto;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSelecioneProduto;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUnidadeMedida;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
