package com.moonlight.moonlightapp.services.produtos;

import java.util.ArrayList;
import java.util.List;

import com.moonlight.moonlightapp.converters.ProcessoConverter;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ItemProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.ItemProdutoModel;
import com.moonlight.moonlightapp.models.ProcessoModel;
import com.moonlight.moonlightapp.models.ProdutoModel;

public class CriarProdutoService {
    private final ProdutoDAO produtoDAO;
    private final ProcessoConverter processoConverter;

    public CriarProdutoService() {
        produtoDAO = new ProdutoDAO();
        processoConverter = new ProcessoConverter();
    }

    public BaseDTO criar(ProdutoDTO dto) {
        var processosDtos = dto.getProcessos();
        var itensProdutosDtos = dto.getItensProdutos();
        var unidadeMedida = dto.getUnidadeMedida();
        var tipoProduto = dto.getTipoProduto();

        
        ProdutoModel produto = new ProdutoModel(dto.getNome(), dto.getDescricao(), unidadeMedida, 
        tipoProduto, 0, dto.getValor());

        var processosModels = converterProcessosParaModel(processosDtos);
        var itensProdutosModels = converterItensProdutosParaModel(itensProdutosDtos);
        return produtoDAO.criar(produto, processosModels, itensProdutosModels);
    }

    private List<ProcessoModel> converterProcessosParaModel(List<ProcessoDTO> dtos){
        List<ProcessoModel> processos = new ArrayList<>();
        for (ProcessoDTO dto : dtos) {
            processos.add(processoConverter.converterParaModel(dto));
        }

        return processos;
    }

    private List<ItemProdutoModel> converterItensProdutosParaModel(List<ItemProdutoDTO> dtos){
        List<ItemProdutoModel> itensProdutos = new ArrayList<>();
        for (ItemProdutoDTO dto : dtos) {
            itensProdutos.add(new ItemProdutoModel(dto.getNome(), dto.getDescricao(), dto.getValor()));
        }

        return itensProdutos;
    }
    
}
