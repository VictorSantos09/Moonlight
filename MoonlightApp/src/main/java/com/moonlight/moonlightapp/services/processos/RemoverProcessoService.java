package com.moonlight.moonlightapp.services.processos;

import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.validators.DefaultValidator;

public class RemoverProcessoService {
    private final ProcessoDAO processoDAO;

    public RemoverProcessoService() {
        processoDAO = new ProcessoDAO();
    }

    public BaseDTO remover(String etapa) {

        if (DefaultValidator.isBlankOrEmpty(etapa)) {
            return BaseDTO.buildFalha("etapa inválida");
        }

        if (!processoDAO.isCadastrado(etapa)) {
            return BaseDTO.buildFalha("processo não encontrado");
        }

        var processo = processoDAO.buscarPorEtapa(etapa);

        var resultadoRemocao = processoDAO.deletar(processo);

        if (!resultadoRemocao.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível remover o processo");
        }

        return BaseDTO.buildSucesso("processo removido com sucesso");
    }
}
