/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.moonlight.moonlightapp;

import com.moonlight.moonlightapp.daos.ConexaoBanco;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ItemProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.services.produtos.CriarProdutoService;

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

        try {
            Executar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getCause());
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }

    private static void Executar() {
        var unidadeMedida = new UnidadeMedidaDAO().buscarPorId(1);
        var tipoProduto = new TipoProdutoDAO().buscarPorId(1);

        List<ProcessoDTO> processosDtos = new ArrayList<>();
        processosDtos.add(new ProcessoDTO("Fermentação", 10d));
        processosDtos.add(new ProcessoDTO("Cozimento", 5d));
        processosDtos.add(new ProcessoDTO("Embalagem", 120d));

        List<ItemProdutoDTO> itensProdutosDtos = new ArrayList<>();
        itensProdutosDtos.add(new ItemProdutoDTO(10, "TOMATE",
                "BOLO DE TOMATE"));

        ProdutoDTO dto = new ProdutoDTO("BOLO DE TOMATE", "MT RUIM", 100, processosDtos,
                itensProdutosDtos, tipoProduto, unidadeMedida);

        CriarProdutoService service = new CriarProdutoService();
        var resultado = service.criar(dto);

        JOptionPane.showMessageDialog(null, resultado.getMensagem());
    }
}
