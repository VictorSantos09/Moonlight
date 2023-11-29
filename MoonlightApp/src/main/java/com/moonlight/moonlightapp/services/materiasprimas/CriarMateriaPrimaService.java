package com.moonlight.moonlightapp.services.materiasprimas;

import com.moonlight.moonlightapp.converters.ProdutoConverter;
import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.daos.ProdutoDAO;
import com.moonlight.moonlightapp.daos.TipoProdutoDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.daos.ValorProdutoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;
import com.moonlight.moonlightapp.validators.dtos.ProdutoDTOValidator;
import com.moonlight.moonlightapp.validators.models.MateriaPrimaValidator;
import com.moonlight.moonlightapp.validators.models.ProcessoValidator;
import com.moonlight.moonlightapp.validators.models.ProdutoValidator;

public final class CriarMateriaPrimaService {
    public final class CriarProdutoService {
    private final ProcessoDAO processoDAO;
    private final ProdutoDAO produtoDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final ValorProdutoDAO valorProdutoDAO;
    private final ProdutoConverter produtoConverter;
    private final ProdutoValidator produtoValidator;
    private final ProcessoValidator processoValidator;
    private final MateriaPrimaValidator materiaPrimaValidator;
    private final ProdutoDTOValidator produtoDTOValidator;

    public CriarProdutoService() {
        processoDAO = new ProcessoDAO();
        produtoDAO = new ProdutoDAO();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
        materiaPrimaDAO = new MateriaPrimaDAO();
        valorProdutoDAO = new ValorProdutoDAO();
        produtoConverter = new ProdutoConverter();
        produtoValidator = new ProdutoValidator();
        processoValidator = new ProcessoValidator();
        materiaPrimaValidator = new MateriaPrimaValidator();
        produtoDTOValidator = new ProdutoDTOValidator();
    }

    public BaseDTO criar(MateriaPrimaDTO dto){
        var resultadoValidacaoEntrada = validarEntrada(dto);

        if (!resultadoValidacaoEntrada.getIsSucesso()){
            return resultadoValidacaoEntrada;
        }

        var unidadeMedidasModels = buscarUnidadeMedida(dto);
            if (unidadeMedidasModels.isEmpty()){
                return BaseDTO.buildFalha("Unidade de Medida não encontrada.");
            }

            var tipoMateriaPrimaModels = buscarTipoMateriaPrima(dto);
                if (tipoMateriaPrimaModels.isEmpty()) {
                    return BaseDTO.buildFalha("Tipo de Matéria Prima não encontrada.");
                }
            
        
    }
    
}
