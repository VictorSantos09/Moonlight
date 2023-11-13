/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.moonlight.moonlightapp;

import com.moonlight.moonlightapp.daos.ConexaoBanco;
import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.ProdutoProcessosDAO;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.models.ProcessoModel;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.models.ProdutoProcessoModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amanda.medeiros1
 */
public class MoonlightApp {

    public static void main(String[] args) {
        boolean isConexaoOk = ConexaoBanco.testConnection();
        if (!isConexaoOk) {
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados");
        }

        var unidadeMedida = new UnidadeMedidaDAO().buscarPorId(1);
        var tipo = new TipoProdutoDAO().buscarPorId(1);

        ProdutoModel model = new ProdutoModel("bolo de vodka", "MT DOIDO", unidadeMedida, tipo, 500, 100);

        var processosDB = new ProcessoDAO().buscarTodos();
        List<ProcessoModel> processos = new ArrayList<>();

        processosDB.forEach(processo -> {
            processos.add(processo);
        });

        ProdutoDAO produtoDAO = new ProdutoDAO();
        var resultado = produtoDAO.criar(model);

        ProdutoProcessosDAO produtoProcessosDAO = new ProdutoProcessosDAO();
        processos.forEach(processo -> {
            var produtoProcesso = new ProdutoProcessoModel(processo, model);
            produtoProcessosDAO.criar(produtoProcesso);
        });

        JOptionPane.showMessageDialog(null, resultado.getMensagem());
    }
}
