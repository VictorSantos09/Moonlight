package com.moonlight.moonlightapp.services.processos;

import com.moonlight.moonlightapp.converters.ProcessoConverter;
import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.processos.ProcessoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.validators.dtos.ProcessoDTOValidator;
import com.moonlight.moonlightapp.validators.models.ProcessoValidator;

public class CriarProcessoService {
    private final ProcessoDAO processoDAO;
    private final ProcessoValidator processoValidator;
    private final ProcessoConverter processoConverter;
    private final ProcessoDTOValidator processoDTOValidator;
    

    public CriarProcessoService() {
        processoDAO = new ProcessoDAO();
        processoConverter = new ProcessoConverter();
        processoValidator = new ProcessoValidator();
        processoDTOValidator = new ProcessoDTOValidator();
    }

    public BaseDTO criar(ProcessoDTO dto) {
        var ResultadoValidacao = processoDTOValidator.validar(dto);
        if(ResultadoValidacao.isValido() == false ) {
            return BaseDTO.buildFalha("Processo inválido", ResultadoValidacao);
        }
        
        var processo = processoConverter.converterFrom(dto);
        var resultadoGravacao = processoDAO.criar(processo); 
        if(resultadoGravacao.getSucesso() == false ){
            return BaseDTO.buildFalha("Não foi possível gravar o processo", resultadoGravacao.getMensagem());
        }
        return BaseDTO.buildSucesso("Processo gravado com sucesso");
    }
}

