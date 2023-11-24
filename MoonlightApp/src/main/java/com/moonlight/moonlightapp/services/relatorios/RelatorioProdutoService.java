package com.moonlight.moonlightapp.services.relatorios;

import com.moonlight.moonlightapp.daos.RelatorioDAO;
import com.moonlight.moonlightapp.models.relatorios.ProdutoFabricacaoMaisBaratoRelatorio;
import com.moonlight.moonlightapp.models.relatorios.ProdutoFabricacaoMaisCaroRelatorio;
import com.moonlight.moonlightapp.models.relatorios.ProdutoMaisBaratoRelatorio;
import com.moonlight.moonlightapp.models.relatorios.ProdutoMaisCaroRelatorio;

public class RelatorioProdutoService {
    private final RelatorioDAO relatorioDAO;

    public RelatorioProdutoService() {
        relatorioDAO = new RelatorioDAO();
    }

    public ProdutoMaisBaratoRelatorio buscarMaisBarato() {
        return relatorioDAO.buscarMaisBarato();
    }

    public ProdutoMaisCaroRelatorio buscarMaisCaro() {
        return relatorioDAO.buscarMaisCaro();
    }

    public ProdutoFabricacaoMaisBaratoRelatorio buscarFabricacaoMaisBarata() {
        return relatorioDAO.buscarFabricacaoMaisBarata();
    }

    public ProdutoFabricacaoMaisCaroRelatorio buscarFabricacaoMaisCara() {
        return relatorioDAO.buscarFabricacaoMaisCara();
    }
}
