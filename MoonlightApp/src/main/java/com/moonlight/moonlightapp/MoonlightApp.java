/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.moonlight.moonlightapp;

import javax.swing.JOptionPane;

import com.moonlight.moonlightapp.daos.ConexaoBanco;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.ValoresProdutoDAO;
import com.moonlight.moonlightapp.models.ValoresProdutoModel;

/**
 *
 * @author amanda.medeiros1
 */
public class MoonlightApp {

    public static void main(String[] args) {
        boolean isConexaoOk = ConexaoBanco.testConnection();
        JOptionPane.showMessageDialog(null, "Conexão com o banco de dados: " + (isConexaoOk ? "OK" : "FALHA"));
        ValoresProdutoDAO dao = new ValoresProdutoDAO();
        ProdutoDAO pDAO = new ProdutoDAO();
        var product = pDAO.BuscarPorId(1);

        var model = new ValoresProdutoModel(200,100,product);
        var resultado = dao.criar(model);
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
