/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.moonlight.moonlightapp;

import javax.swing.JOptionPane;

import com.moonlight.moonlightapp.daos.ConexaoBanco;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.ValorProdutoDAO;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.ValorProdutoModel;

/**
 * @author amanda.medeiros1
 */
public class MoonlightApp {

    public static void main(String[] args) {
        boolean isConexaoOk = ConexaoBanco.testConnection();
        if (!isConexaoOk) {
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados");
        }
    }
}
