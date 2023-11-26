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
import com.moonlight.moonlightapp.validators.DefaultValidator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

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
        lblSelecioneProcessos = new javax.swing.JLabel();
        lblSelecioneMateriasPrimas = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProcessos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMateriasPrimas = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Produto");
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

        lblSelecioneProcessos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneProcessos.setText("Selecione os Processos");

        lblSelecioneMateriasPrimas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSelecioneMateriasPrimas.setText("Selecione a Matéria Prima");

        tbProcessos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Etapa", "Custo"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbProcessos);

        tbMateriasPrimas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Item", "Tipo", "Unidade Medida", "Valor", "Quantidade"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class,
                    java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbMateriasPrimas);

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
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblNome,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 68,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(txtNome))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblDescricao,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 253,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(lblUnidadeMedida,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 175,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblTipoProduto,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 149,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(cbUnidadeMedida,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 179,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cbTipoProduto,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 179,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSelecioneProcessos)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 357,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(328, 328, 328)
                                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(btnVoltar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblSelecioneMateriasPrimas)
                                                        .addComponent(jScrollPane4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 539,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(27, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
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
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(42, 42, 42)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(95, 95, 95)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lblUnidadeMedida,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                43,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cbUnidadeMedida,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                32,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(lblValor,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtValor,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(64, 64, 64)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblTipoProduto,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 78,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbTipoProduto,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSelecioneProcessos,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblSelecioneMateriasPrimas,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jScrollPane3)
                                                        .addComponent(jScrollPane4))
                                                .addGap(107, 107, 107)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnVoltar)
                                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(27, 27, 27)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarActionPerformed
        setVisible(false);
        dispose();
    }// GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed
        var unidadeMedida = cbUnidadeMedida.getSelectedItem().toString();
        var tipoProduto = cbTipoProduto.getSelectedItem().toString();
        var processosSelecionados = tbProcessos.getSelectedRows();
        var materiasPrimasSelecionadas = tbMateriasPrimas.getSelectedRows();
        var nomeProduto = txtNome.getText();
        var descricao = txtDescricao.getText();
        var valor = 0d;
        try {
            valor = Double.parseDouble(txtValor.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "informe o valor do produto");
        }

        if (DefaultValidator.isBlankOrEmpty(unidadeMedida)) {
            JOptionPane.showMessageDialog(null, "Selecione a matéria prima");
        } else if (DefaultValidator.isBlankOrEmpty(tipoProduto)) {
            JOptionPane.showMessageDialog(null, "Selecione o tipo do produto");

        } else if (processosSelecionados.length == 0) {
            JOptionPane.showMessageDialog(null, "Selecione os processos");

        } else if (materiasPrimasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Selecione as matérias primas");

        } else if (DefaultValidator.isBlankOrEmpty(nomeProduto)) {
            JOptionPane.showMessageDialog(null, "Informe o nome do produto");

        } else if (DefaultValidator.isBlankOrEmpty(descricao)) {
            JOptionPane.showMessageDialog(null, "Informe a descrição do produto");

        } else if (DefaultValidator.isZeroOrNegative(valor)) {
            JOptionPane.showMessageDialog(null, "Informe o valor do produto");

        } else {
            UnidadeMedidaDTO unidadeMedidaDTO = new UnidadeMedidaDTO(unidadeMedida);
            TipoProdutoDTO tipoProdutoDTO = new TipoProdutoDTO(tipoProduto);

            List<ProcessoDTO> processosDTO = new ArrayList<>();
            List<ItemProdutoDTO> itensProdutos = new ArrayList<>();

            DefaultTableModel tabelaProcessos = (DefaultTableModel) tbProcessos.getModel();
            for (int i : processosSelecionados) {
                String etapa = tabelaProcessos.getValueAt(i, 0).toString();
                Double custo = (Double) tabelaProcessos.getValueAt(i, 1);

                ProcessoDTO dto = new ProcessoDTO(etapa, custo);

                processosDTO.add(dto);
            }

            Boolean isValido = true;
            DefaultTableModel tabelaMateriasPrimas = (DefaultTableModel) tbMateriasPrimas.getModel();
            for (var i : materiasPrimasSelecionadas) {
                Integer quantidade = (Integer) tabelaMateriasPrimas.getValueAt(i, 4);
                String nomeMateriaPrima = tabelaMateriasPrimas.getValueAt(i, 0).toString();

                if (DefaultValidator.isZeroOrNegative(quantidade)) {
                    JOptionPane.showMessageDialog(null,
                            "informe a quantidade para a matéria prima " + nomeMateriaPrima);
                    isValido = false;
                    break;
                } else {
                    ItemProdutoDTO dto = new ItemProdutoDTO(quantidade, nomeMateriaPrima, nomeProduto);
                    itensProdutos.add(dto);
                }
            }

            if (isValido) {
                var dto = new ProdutoDTO(nomeProduto, descricao, valor, processosDTO,
                        itensProdutos, tipoProdutoDTO, unidadeMedidaDTO);

                var resultado = criarProdutoService.criar(dto);

                JOptionPane.showMessageDialog(null, resultado.getMensagem());
            }
        }
    }// GEN-LAST:event_btnSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        cbUnidadeMedida.removeAllItems();
        cbTipoProduto.removeAllItems();
        tbMateriasPrimas.removeAll();
        tbProcessos.removeAll();

        var unidadesMedidas = unidadeMedidaDAO.buscarTodos();
        var tiposProdutos = tipoProdutoDAO.buscarTodos();
        var materiasPrimas = materiaPrimaDAO.buscarTodos();
        var processos = processoDAO.buscarTodos();

        DefaultTableModel tabelaProcessos = (DefaultTableModel) tbProcessos.getModel();
        processos.forEach(processo -> {
            var processoObj = new Object[] {
                    processo.getEtapa(),
                    processo.getCusto()
            };
            tabelaProcessos.addRow(processoObj);
        });

        DefaultTableModel tabelaMateriasPrimas = (DefaultTableModel) tbMateriasPrimas.getModel();
        materiasPrimas.forEach(materiaPrima -> {
            var materiaPrimaObj = new Object[] {
                    materiaPrima.getNome(),
                    materiaPrima.getTipoMateriaPrima().getNome(),
                    materiaPrima.getUnidadeMedida().getNome(),
                    materiaPrima.getValor()

            };

            tabelaMateriasPrimas.addRow(materiaPrimaObj);
        });

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CriarProdutoView.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarProdutoView.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarProdutoView.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarProdutoView.class.getName()).log(
                    java.util.logging.Level.SEVERE,
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
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbTipoProduto;
    private javax.swing.JComboBox<String> cbUnidadeMedida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSelecioneMateriasPrimas;
    private javax.swing.JLabel lblSelecioneProcessos;
    private javax.swing.JLabel lblTipoProduto;
    private javax.swing.JLabel lblUnidadeMedida;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tbMateriasPrimas;
    private javax.swing.JTable tbProcessos;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
