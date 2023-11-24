/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.moonlight.moonlightapp.views.relatorios;

import javax.swing.JFrame;

import com.moonlight.moonlightapp.services.relatorios.RelatorioProdutoService;

/**
 *
 * @author victor.santos8
 */
public class RelatorioView extends javax.swing.JFrame {
    private final RelatorioProdutoService relatorioProdutoService;

    /**
     * Creates new form RelatorioView
     */
    public RelatorioView() {
        relatorioProdutoService = new RelatorioProdutoService();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ctProdutoMaisCaro = new javax.swing.JPanel();
        lblProdutoMaisBarato = new javax.swing.JLabel();
        lblNomeProdutoMaisCaro = new javax.swing.JLabel();
        lblValorProdutoMaisCaro = new javax.swing.JLabel();
        lblTipoProdutoMaisCaro = new javax.swing.JLabel();
        lblValorRecomendadoProdutoMaisCaro = new javax.swing.JLabel();
        lblSubtotalProdutoMaisCaro = new javax.swing.JLabel();
        ctProdutoMaisCaro1 = new javax.swing.JPanel();
        lblProdutoMaisCaro = new javax.swing.JLabel();
        lblNomeProdutoMaisBarato = new javax.swing.JLabel();
        lblValorProdutoMaisBarato = new javax.swing.JLabel();
        lblTipoProdutoMaisBarato = new javax.swing.JLabel();
        lblValorRecomendadoProdutoMaisBarato = new javax.swing.JLabel();
        lblSubtotalProdutoMaisBarato = new javax.swing.JLabel();
        ctProdutoMaisCaro2 = new javax.swing.JPanel();
        lblProdutoFabricacaoMaisBarato = new javax.swing.JLabel();
        lblNomeProdutoFabricacaoMaisBarato = new javax.swing.JLabel();
        lblValorProdutoFabricacaoMaisBarato = new javax.swing.JLabel();
        lblTipoProdutoFabricacaoMaisBarato = new javax.swing.JLabel();
        lblValorRecomendadoProdutoFabricacaoMaisBarato = new javax.swing.JLabel();
        lblSubtotalProdutoFabricacaoMaisBarato = new javax.swing.JLabel();
        ctProdutoMaisCaro3 = new javax.swing.JPanel();
        lblProdutoFabricacaoMaisCaro = new javax.swing.JLabel();
        lblNomeProdutoFabricacaoMaisCaro = new javax.swing.JLabel();
        lblValorProdutoFabricacaoMaisCaro = new javax.swing.JLabel();
        lblTipoProdutoFabricacaoMaisCaro = new javax.swing.JLabel();
        lblValorRecomendadoProdutoFabricacaoMaisCaro = new javax.swing.JLabel();
        lblSubtotalProdutoFabricacaoMaisCaro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório Produtos");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        ctProdutoMaisCaro.setBackground(new java.awt.Color(204, 204, 204));
        ctProdutoMaisCaro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ctProdutoMaisCaro.setPreferredSize(new java.awt.Dimension(500, 350));

        lblProdutoMaisBarato.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblProdutoMaisBarato.setText("Produto Mais Barato");

        lblNomeProdutoMaisCaro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNomeProdutoMaisCaro.setText("Produto");

        lblValorProdutoMaisCaro.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblValorProdutoMaisCaro.setText("Valor");

        lblTipoProdutoMaisCaro.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblTipoProdutoMaisCaro.setText("Tipo");

        lblValorRecomendadoProdutoMaisCaro.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblValorRecomendadoProdutoMaisCaro.setText("Valor Recomendado");

        lblSubtotalProdutoMaisCaro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblSubtotalProdutoMaisCaro.setText("Subtotal");

        javax.swing.GroupLayout ctProdutoMaisCaroLayout = new javax.swing.GroupLayout(ctProdutoMaisCaro);
        ctProdutoMaisCaro.setLayout(ctProdutoMaisCaroLayout);
        ctProdutoMaisCaroLayout.setHorizontalGroup(
            ctProdutoMaisCaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctProdutoMaisCaroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblSubtotalProdutoMaisCaro)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ctProdutoMaisCaroLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblProdutoMaisBarato)
                .addGap(273, 392, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctProdutoMaisCaroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ctProdutoMaisCaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeProdutoMaisCaro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTipoProdutoMaisCaro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblValorProdutoMaisCaro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblValorRecomendadoProdutoMaisCaro, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(41, 41, 41))
        );
        ctProdutoMaisCaroLayout.setVerticalGroup(
            ctProdutoMaisCaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctProdutoMaisCaroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProdutoMaisBarato)
                .addGap(14, 14, 14)
                .addComponent(lblNomeProdutoMaisCaro)
                .addGap(34, 34, 34)
                .addComponent(lblTipoProdutoMaisCaro)
                .addGap(31, 31, 31)
                .addComponent(lblValorProdutoMaisCaro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValorRecomendadoProdutoMaisCaro)
                .addGap(22, 22, 22)
                .addComponent(lblSubtotalProdutoMaisCaro)
                .addGap(26, 26, 26))
        );

        ctProdutoMaisCaro1.setBackground(new java.awt.Color(204, 204, 204));
        ctProdutoMaisCaro1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ctProdutoMaisCaro1.setPreferredSize(new java.awt.Dimension(500, 350));

        lblProdutoMaisCaro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblProdutoMaisCaro.setText("Produto Mais Caro");

        lblNomeProdutoMaisBarato.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNomeProdutoMaisBarato.setText("Produto");

        lblValorProdutoMaisBarato.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblValorProdutoMaisBarato.setText("Valor");

        lblTipoProdutoMaisBarato.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblTipoProdutoMaisBarato.setText("Tipo");

        lblValorRecomendadoProdutoMaisBarato.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblValorRecomendadoProdutoMaisBarato.setText("Valor Recomendado");

        lblSubtotalProdutoMaisBarato.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblSubtotalProdutoMaisBarato.setText("Subtotal");

        javax.swing.GroupLayout ctProdutoMaisCaro1Layout = new javax.swing.GroupLayout(ctProdutoMaisCaro1);
        ctProdutoMaisCaro1.setLayout(ctProdutoMaisCaro1Layout);
        ctProdutoMaisCaro1Layout.setHorizontalGroup(
            ctProdutoMaisCaro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctProdutoMaisCaro1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ctProdutoMaisCaro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctProdutoMaisCaro1Layout.createSequentialGroup()
                        .addComponent(lblProdutoMaisCaro)
                        .addContainerGap(426, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctProdutoMaisCaro1Layout.createSequentialGroup()
                        .addGroup(ctProdutoMaisCaro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeProdutoMaisBarato, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTipoProdutoMaisBarato, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorProdutoMaisBarato, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorRecomendadoProdutoMaisBarato, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(44, 44, 44))))
            .addGroup(ctProdutoMaisCaro1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblSubtotalProdutoMaisBarato)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ctProdutoMaisCaro1Layout.setVerticalGroup(
            ctProdutoMaisCaro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctProdutoMaisCaro1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProdutoMaisCaro)
                .addGap(18, 18, 18)
                .addComponent(lblNomeProdutoMaisBarato)
                .addGap(34, 34, 34)
                .addComponent(lblTipoProdutoMaisBarato)
                .addGap(31, 31, 31)
                .addComponent(lblValorProdutoMaisBarato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(lblValorRecomendadoProdutoMaisBarato)
                .addGap(18, 18, 18)
                .addComponent(lblSubtotalProdutoMaisBarato)
                .addGap(26, 26, 26))
        );

        ctProdutoMaisCaro2.setBackground(new java.awt.Color(204, 204, 204));
        ctProdutoMaisCaro2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ctProdutoMaisCaro2.setPreferredSize(new java.awt.Dimension(500, 350));

        lblProdutoFabricacaoMaisBarato.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblProdutoFabricacaoMaisBarato.setText("Produto Fabricação Mais Barato");

        lblNomeProdutoFabricacaoMaisBarato.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNomeProdutoFabricacaoMaisBarato.setText("Produto");

        lblValorProdutoFabricacaoMaisBarato.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblValorProdutoFabricacaoMaisBarato.setText("Valor");

        lblTipoProdutoFabricacaoMaisBarato.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblTipoProdutoFabricacaoMaisBarato.setText("Tipo");

        lblValorRecomendadoProdutoFabricacaoMaisBarato.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblValorRecomendadoProdutoFabricacaoMaisBarato.setText("Valor Recomendado");

        lblSubtotalProdutoFabricacaoMaisBarato.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblSubtotalProdutoFabricacaoMaisBarato.setText("Subtotal");

        javax.swing.GroupLayout ctProdutoMaisCaro2Layout = new javax.swing.GroupLayout(ctProdutoMaisCaro2);
        ctProdutoMaisCaro2.setLayout(ctProdutoMaisCaro2Layout);
        ctProdutoMaisCaro2Layout.setHorizontalGroup(
            ctProdutoMaisCaro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctProdutoMaisCaro2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ctProdutoMaisCaro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctProdutoMaisCaro2Layout.createSequentialGroup()
                        .addComponent(lblProdutoFabricacaoMaisBarato)
                        .addContainerGap(204, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctProdutoMaisCaro2Layout.createSequentialGroup()
                        .addGroup(ctProdutoMaisCaro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeProdutoFabricacaoMaisBarato, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTipoProdutoFabricacaoMaisBarato, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorProdutoFabricacaoMaisBarato, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorRecomendadoProdutoFabricacaoMaisBarato, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(44, 44, 44))))
            .addGroup(ctProdutoMaisCaro2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblSubtotalProdutoFabricacaoMaisBarato)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ctProdutoMaisCaro2Layout.setVerticalGroup(
            ctProdutoMaisCaro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctProdutoMaisCaro2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProdutoFabricacaoMaisBarato)
                .addGap(18, 18, 18)
                .addComponent(lblNomeProdutoFabricacaoMaisBarato)
                .addGap(34, 34, 34)
                .addComponent(lblTipoProdutoFabricacaoMaisBarato)
                .addGap(31, 31, 31)
                .addComponent(lblValorProdutoFabricacaoMaisBarato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(lblValorRecomendadoProdutoFabricacaoMaisBarato)
                .addGap(18, 18, 18)
                .addComponent(lblSubtotalProdutoFabricacaoMaisBarato)
                .addGap(26, 26, 26))
        );

        ctProdutoMaisCaro3.setBackground(new java.awt.Color(204, 204, 204));
        ctProdutoMaisCaro3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ctProdutoMaisCaro3.setPreferredSize(new java.awt.Dimension(500, 350));

        lblProdutoFabricacaoMaisCaro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblProdutoFabricacaoMaisCaro.setText("Produto Fabricação Mais Caro");

        lblNomeProdutoFabricacaoMaisCaro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNomeProdutoFabricacaoMaisCaro.setText("Produto");

        lblValorProdutoFabricacaoMaisCaro.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblValorProdutoFabricacaoMaisCaro.setText("Valor");

        lblTipoProdutoFabricacaoMaisCaro.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblTipoProdutoFabricacaoMaisCaro.setText("Tipo");

        lblValorRecomendadoProdutoFabricacaoMaisCaro.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblValorRecomendadoProdutoFabricacaoMaisCaro.setText("Valor Recomendado");

        lblSubtotalProdutoFabricacaoMaisCaro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblSubtotalProdutoFabricacaoMaisCaro.setText("Subtotal");

        javax.swing.GroupLayout ctProdutoMaisCaro3Layout = new javax.swing.GroupLayout(ctProdutoMaisCaro3);
        ctProdutoMaisCaro3.setLayout(ctProdutoMaisCaro3Layout);
        ctProdutoMaisCaro3Layout.setHorizontalGroup(
            ctProdutoMaisCaro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctProdutoMaisCaro3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ctProdutoMaisCaro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ctProdutoMaisCaro3Layout.createSequentialGroup()
                        .addComponent(lblProdutoFabricacaoMaisCaro)
                        .addContainerGap(238, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctProdutoMaisCaro3Layout.createSequentialGroup()
                        .addGroup(ctProdutoMaisCaro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeProdutoFabricacaoMaisCaro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTipoProdutoFabricacaoMaisCaro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorProdutoFabricacaoMaisCaro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorRecomendadoProdutoFabricacaoMaisCaro, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(44, 44, 44))))
            .addGroup(ctProdutoMaisCaro3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblSubtotalProdutoFabricacaoMaisCaro)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ctProdutoMaisCaro3Layout.setVerticalGroup(
            ctProdutoMaisCaro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctProdutoMaisCaro3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProdutoFabricacaoMaisCaro)
                .addGap(18, 18, 18)
                .addComponent(lblNomeProdutoFabricacaoMaisCaro)
                .addGap(34, 34, 34)
                .addComponent(lblTipoProdutoFabricacaoMaisCaro)
                .addGap(31, 31, 31)
                .addComponent(lblValorProdutoFabricacaoMaisCaro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValorRecomendadoProdutoFabricacaoMaisCaro)
                .addGap(18, 18, 18)
                .addComponent(lblSubtotalProdutoFabricacaoMaisCaro)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ctProdutoMaisCaro1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ctProdutoMaisCaro3, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ctProdutoMaisCaro, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ctProdutoMaisCaro2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ctProdutoMaisCaro2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(ctProdutoMaisCaro, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctProdutoMaisCaro1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(ctProdutoMaisCaro3, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        var produtoMaisCaro = relatorioProdutoService.buscarMaisCaro();
        var produtoMaisBarato = relatorioProdutoService.buscarMaisBarato();
        var produtoFabricaoMaisCaro = relatorioProdutoService.buscarFabricacaoMaisCara();
        var produtoFabricacaoMaisBarata = relatorioProdutoService.buscarFabricacaoMaisBarata();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        lblNomeProdutoMaisCaro.setText(produtoMaisCaro.getNome());
        lblTipoProdutoMaisCaro.setText("Tipo: " + produtoMaisCaro.getTipo());
        lblValorProdutoMaisCaro.setText("Valor: R$ " + produtoMaisCaro.getValorVenda());
        lblValorRecomendadoProdutoMaisCaro.setText("Valor Recomendado: R$ " + produtoMaisCaro.getValorRecomendado());
        lblSubtotalProdutoMaisCaro.setText("FABRICAÇÃO: R$ " + produtoMaisCaro.getSubtotal());

        lblNomeProdutoFabricacaoMaisCaro.setText(produtoFabricaoMaisCaro.getNome());
        lblTipoProdutoFabricacaoMaisCaro.setText("Tipo: " + produtoFabricaoMaisCaro.getTipo());
        lblValorProdutoFabricacaoMaisCaro.setText("Valor: R$ " + produtoFabricaoMaisCaro.getValorVenda());
        lblValorRecomendadoProdutoFabricacaoMaisCaro
                .setText("Valor Recomendado: R$ " + produtoFabricaoMaisCaro.getValorRecomendado());
        lblSubtotalProdutoFabricacaoMaisCaro.setText("FABRICAÇÃO: R$ " + produtoFabricaoMaisCaro.getSubtotal());

        lblNomeProdutoMaisBarato.setText(produtoMaisBarato.getNome());
        lblTipoProdutoMaisBarato.setText("Tipo: " + produtoMaisBarato.getTipo());
        lblValorProdutoMaisBarato.setText("Valor: R$ " + produtoMaisBarato.getValorVenda());
        lblValorRecomendadoProdutoMaisBarato
                .setText("Valor Recomendado: R$ " + produtoMaisBarato.getValorRecomendado());
        lblSubtotalProdutoMaisBarato.setText("FABRICAÇÃO: R$ " + produtoMaisBarato.getSubtotal());

        lblNomeProdutoFabricacaoMaisBarato.setText(produtoFabricacaoMaisBarata.getNome());
        lblTipoProdutoFabricacaoMaisBarato.setText("Tipo: " + produtoFabricacaoMaisBarata.getTipo());
        lblValorProdutoFabricacaoMaisBarato.setText("Valor: R$ " + produtoFabricacaoMaisBarata.getValorVenda());
        lblValorRecomendadoProdutoFabricacaoMaisBarato
                .setText("Valor Recomendado: R$ " + produtoFabricacaoMaisBarata.getValorRecomendado());
        lblSubtotalProdutoFabricacaoMaisBarato.setText("FABRICAÇÃO: R$ " + produtoFabricacaoMaisBarata.getSubtotal());
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
            java.util.logging.Logger.getLogger(RelatorioView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ctProdutoMaisCaro;
    private javax.swing.JPanel ctProdutoMaisCaro1;
    private javax.swing.JPanel ctProdutoMaisCaro2;
    private javax.swing.JPanel ctProdutoMaisCaro3;
    private javax.swing.JLabel lblNomeProdutoFabricacaoMaisBarato;
    private javax.swing.JLabel lblNomeProdutoFabricacaoMaisCaro;
    private javax.swing.JLabel lblNomeProdutoMaisBarato;
    private javax.swing.JLabel lblNomeProdutoMaisCaro;
    private javax.swing.JLabel lblProdutoFabricacaoMaisBarato;
    private javax.swing.JLabel lblProdutoFabricacaoMaisCaro;
    private javax.swing.JLabel lblProdutoMaisBarato;
    private javax.swing.JLabel lblProdutoMaisCaro;
    private javax.swing.JLabel lblSubtotalProdutoFabricacaoMaisBarato;
    private javax.swing.JLabel lblSubtotalProdutoFabricacaoMaisCaro;
    private javax.swing.JLabel lblSubtotalProdutoMaisBarato;
    private javax.swing.JLabel lblSubtotalProdutoMaisCaro;
    private javax.swing.JLabel lblTipoProdutoFabricacaoMaisBarato;
    private javax.swing.JLabel lblTipoProdutoFabricacaoMaisCaro;
    private javax.swing.JLabel lblTipoProdutoMaisBarato;
    private javax.swing.JLabel lblTipoProdutoMaisCaro;
    private javax.swing.JLabel lblValorProdutoFabricacaoMaisBarato;
    private javax.swing.JLabel lblValorProdutoFabricacaoMaisCaro;
    private javax.swing.JLabel lblValorProdutoMaisBarato;
    private javax.swing.JLabel lblValorProdutoMaisCaro;
    private javax.swing.JLabel lblValorRecomendadoProdutoFabricacaoMaisBarato;
    private javax.swing.JLabel lblValorRecomendadoProdutoFabricacaoMaisCaro;
    private javax.swing.JLabel lblValorRecomendadoProdutoMaisBarato;
    private javax.swing.JLabel lblValorRecomendadoProdutoMaisCaro;
    // End of variables declaration//GEN-END:variables
}
