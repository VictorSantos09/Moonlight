package com.moonlight.moonlightapp.services.processos;

import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.processos.AtualizarProcessoDTO;
import com.moonlight.moonlightapp.models.ProcessoModel;
import com.moonlight.moonlightapp.validators.DefaultValidator;
import com.moonlight.moonlightapp.validators.models.ProcessoValidator;

public class AtualizarProcessoService {
    private final ProcessoDAO processoDAO;
    private final ProcessoValidator processoValidator;

    public AtualizarProcessoService() {
        processoDAO = new ProcessoDAO();
        processoValidator = new ProcessoValidator();
    }

    public BaseDTO atualizar(AtualizarProcessoDTO dto) {
        var resultadoValidacaoEntrada = validarEntrada(dto);
        if (!resultadoValidacaoEntrada.getIsSucesso()) {
            return resultadoValidacaoEntrada;
        }

        var processoOriginal = processoDAO.buscarPorEtapa(dto.getEtapaOriginal());

        if (processoOriginal == null) {
            return BaseDTO.buildFalha("Não foi possível encontrar o processo original.");
        }

        var processoAtualizado = new ProcessoModel(dto.getEtapaNova(), dto.getCusto());
        processoAtualizado.setId(processoOriginal.getId());

        var resultadoValidacao = processoValidator.validar(processoAtualizado);
        if (!resultadoValidacao.isValido()) {
            return BaseDTO.buildFalha("processo inválido", resultadoValidacao.getFalhas());
        }

        var resultadoGravacao = processoDAO.atualizar(processoAtualizado);
        if (!resultadoGravacao.getIsSucesso()) {
            return BaseDTO.buildFalha("Não foi possível atualizar o processo", resultadoGravacao.getMensagem());
        }

        return BaseDTO.buildSucesso("Processo atualizado com sucesso");
    }

    private BaseDTO validarEntrada(AtualizarProcessoDTO dto) {
        if (DefaultValidator.isBlankOrEmpty(dto.getEtapaNova())) {
            return BaseDTO.buildFalha("Etapa nova não pode ser vazia");
        }
        if (DefaultValidator.isBlankOrEmpty(dto.getEtapaOriginal())) {
            return BaseDTO.buildFalha("Etapa original não pode ser vazia");
        }
        if (DefaultValidator.isZeroOrNegative(dto.getCusto())) {
            return BaseDTO.buildFalha("Custo não pode ser negativo ou zero");
        }

        return BaseDTO.buildSucesso("dados válidos");
    }
}
