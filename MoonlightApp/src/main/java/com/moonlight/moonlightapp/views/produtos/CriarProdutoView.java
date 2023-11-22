/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.produtos;

import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ItemProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.TipoProdutoDTO;
import com.moonlight.moonlightapp.dtos.unidadesmedidas.UnidadeMedidaDTO;
import com.moonlight.moonlightapp.models.TipoProdutoModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.moonlight.moonlightapp.services.produtos.CriarProdutoService;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author victor.santos8
 */
public class CriarProdutoView extends javax.swing.JFrame {
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final ProcessoDAO processoDAO;
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final CriarProdutoService criarProdutoService;
    private final List<ItemProdutoDTO> itensProdutos;

    /**
     * Creates new form CriarProdutoView
     */
    public CriarProdutoView() {
        initComponents();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
        processoDAO = new ProcessoDAO();
        materiaPrimaDAO = new MateriaPrimaDAO();
        criarProdutoService = new CriarProdutoService();
        itensProdutos = new ArrayList<>();
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblUnidadeMedida = new javax.swing.JLabel();
        lblTipoProduto = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        cbUnidadeMedida = new javax.swing.JComboBox<>();
        cbTipoProduto = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProcessos = new javax.swing.JList<>();
        lblSelecioneProcessos = new javax.swing.JLabel();
        lblSelecioneMateriasPrimas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbcMateriasPrimas = new javax.swing.JComboBox<>();
        lblNomeMateriaPrima = new javax.swing.JLabel();
        lblQuantidadeMateriaPrima = new javax.swing.JLabel();
        txtQuantidadeMateriaPrima = new javax.swing.JTextField();
        lblQuantidadeMateriaPrimaAdicionada = new javax.swing.JLabel();
        btnAdicionarMateriaPrima = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNome.setText("Nome");

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDescricao.setText("Descrição");

        lblValor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblValor.setText("Valor");

        lblUnidadeMedida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUnidadeMedida.setText("Unidade de Medida");

        lblTipoProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTipoProduto.setText("Tipo de Produto");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        cbUnidadeMedida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbUnidadeMedida.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbTipoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTipoProduto.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lstProcessos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane2.setViewportView(lstProcessos);

        lblSelecioneProcessos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneProcessos.setText("Selecione os Processos");

        lblSelecioneMateriasPrimas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneMateriasPrimas.setText("Selecione a Matéria Prima");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Custo Fabricação: R$ ");

        cbcMateriasPrimas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbcMateriasPrimas.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblNomeMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNomeMateriaPrima.setText("Nome");

        lblQuantidadeMateriaPrima.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuantidadeMateriaPrima.setText("Quantidade");

        txtQuantidadeMateriaPrima.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblQuantidadeMateriaPrimaAdicionada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuantidadeMateriaPrimaAdicionada.setText("Quantidade Adicionada: ");

        btnAdicionarMateriaPrima.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdicionarMateriaPrima.setText("Adicionar Matéria Prima");
        btnAdicionarMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarMateriaPrimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblNome,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 68,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(txtNome,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 214,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblDescricao,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 253,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblValor,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(txtValor,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 187,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblUnidadeMedida,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                175,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblTipoProduto,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                149,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(cbUnidadeMedida, 0,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(cbTipoProduto, 0,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))))))
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSelecioneProcessos)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 294,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblQuantidadeMateriaPrimaAdicionada))
                                                        .addGap(284, 284, 284)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(lblSelecioneMateriasPrimas)
                                                        .addGap(287, 287, 287))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNomeMateriaPrima)
                                                        .addComponent(lblQuantidadeMateriaPrima))
                                                .addGap(27, 44, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(cbcMateriasPrimas,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txtQuantidadeMateriaPrima,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        69, Short.MAX_VALUE)
                                                                .addComponent(btnAdicionarMateriaPrima)
                                                                .addGap(53, 53, 53)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(63, 63, 63)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblDescricao,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 147,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblSelecioneProcessos,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(lblSelecioneMateriasPrimas, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbcMateriasPrimas,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNomeMateriaPrima))
                                                .addGap(38, 38, 38)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblQuantidadeMateriaPrima)
                                                        .addComponent(txtQuantidadeMateriaPrima,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnAdicionarMateriaPrima))
                                                .addGap(44, 44, 44)
                                                .addComponent(lblQuantidadeMateriaPrimaAdicionada)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblUnidadeMedida,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbUnidadeMedida,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(44, 44, 44)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdicionarMateriaPrimaActionPerformed
        var nomeMateriaPrima = cbcMateriasPrimas.getSelectedItem().toString();
        var quantidadeMateriaPrima = Integer.parseInt(txtQuantidadeMateriaPrima.getText());

        var itemProduto = new ItemProdutoDTO(quantidadeMateriaPrima, nomeMateriaPrima, txtNome.getText());

        itensProdutos.add(itemProduto);

        lblQuantidadeMateriaPrimaAdicionada
                .setText("Quantidade Adicionada: " + itensProdutos.size());
    }// GEN-LAST:event_btnAdicionarMateriaPrimaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed
        var unidadeMedida = cbUnidadeMedida.getSelectedItem().toString();
        var tipoProduto = cbTipoProduto.getSelectedItem().toString();

        var nome = txtNome.getText();
        var descricao = txtDescricao.getText();
        var valor = Double.parseDouble(txtValor.getText());

        UnidadeMedidaDTO unidadeMedidaDTO = new UnidadeMedidaDTO(unidadeMedida, null);
        TipoProdutoDTO tipoProdutoDTO = new TipoProdutoDTO(tipoProduto);

        List<String> etapasProcessos = lstProcessos.getSelectedValuesList();
        List<ProcessoDTO> processosDTO = new ArrayList<>();
        for (var e : etapasProcessos) {
            var processoEncontrado = processoDAO.buscarPorEtapa(e);

            var processoDTO = new ProcessoDTO(processoEncontrado.getEtapa(), processoEncontrado.getCusto());
            processosDTO.add(processoDTO);
        }

        var dto = new ProdutoDTO(nome, descricao, valor, processosDTO,
                itensProdutos, tipoProdutoDTO, unidadeMedidaDTO);

        var resultado = criarProdutoService.criar(dto);

        JOptionPane.showMessageDialog(null, resultado.getMensagem());
    }// GEN-LAST:event_btnSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        cbUnidadeMedida.removeAllItems();
        cbTipoProduto.removeAllItems();
        cbcMateriasPrimas.removeAllItems();
        lstProcessos.removeAll();

        var unidadesMedidas = unidadeMedidaDAO.buscarTodos();
        var tiposProdutos = tipoProdutoDAO.buscarTodos();
        var materiasPrimas = materiaPrimaDAO.buscarTodos();
        var processos = processoDAO.buscarTodos();

        DefaultListModel<String> model = new DefaultListModel<String>();

        processos.forEach(processo -> model.addElement(processo.getEtapa()));
        lstProcessos.setModel(model);

        materiasPrimas.forEach(materiaPrima -> cbcMateriasPrimas.addItem(materiaPrima.getNome()));
        tiposProdutos.forEach(tipoProduto -> cbTipoProduto.addItem(tipoProduto.getNome()));
        unidadesMedidas.forEach(unidadeMedida -> cbUnidadeMedida.addItem(unidadeMedida.getNome()));

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
            java.util.logging.Logger.getLogger(CriarProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarProdutoView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarProdutoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarMateriaPrima;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbTipoProduto;
    private javax.swing.JComboBox<String> cbUnidadeMedida;
    private javax.swing.JComboBox<String> cbcMateriasPrimas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeMateriaPrima;
    private javax.swing.JLabel lblQuantidadeMateriaPrima;
    private javax.swing.JLabel lblQuantidadeMateriaPrimaAdicionada;
    private javax.swing.JLabel lblSelecioneMateriasPrimas;
    private javax.swing.JLabel lblSelecioneProcessos;
    private javax.swing.JLabel lblTipoProduto;
    private javax.swing.JLabel lblUnidadeMedida;
    private javax.swing.JLabel lblValor;
    private javax.swing.JList<String> lstProcessos;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidadeMateriaPrima;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
