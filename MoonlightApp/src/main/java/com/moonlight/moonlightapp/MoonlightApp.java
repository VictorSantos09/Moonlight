/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.moonlight.moonlightapp;

import com.moonlight.moonlightapp.daos.ConexaoBanco;
import com.moonlight.moonlightapp.views.produtos.CriarProdutoView;
import com.moonlight.moonlightapp.views.produtos.ProdutoPrincipalView;

import javax.swing.*;

/**
 * @author amanda.medeiros1
 */
public class MoonlightApp {

    public static void main(String[] args) {
        boolean isConexaoOk = ConexaoBanco.testConnection();
        if (!isConexaoOk) {
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados");
        }
        ProdutoPrincipalView view = new ProdutoPrincipalView();
        view.setVisible(true);
    }
}
