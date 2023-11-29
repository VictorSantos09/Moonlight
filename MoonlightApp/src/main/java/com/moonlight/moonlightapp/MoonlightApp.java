/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.moonlight.moonlightapp;

import com.moonlight.moonlightapp.daos.ConexaoBanco;
import com.moonlight.moonlightapp.views.principal.MenuPrincipalView;
import com.moonlight.moonlightapp.views.produtos.CriarProdutoView;

import javax.swing.*;

/**
 * @author amanda.medeiros1
 */
public class MoonlightApp {

    public static void main(String[] args) {
        try {
            boolean isConexaoOk = ConexaoBanco.testConnection();
            if (!isConexaoOk) {
                JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados");
            }

            MenuPrincipalView view = new MenuPrincipalView();
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "um erro ocorreu. Erro: " + e.getMessage());
        }
    }

}
