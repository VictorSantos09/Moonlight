package com.moonlight.moonlightapp.services.materiasprimas;

import java.sql.SQLException;

import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.validators.DefaultValidator;

public class DeletarMateriaPrimaService {
    private final MateriaPrimaDAO materiaPrimaDAO;

    public DeletarMateriaPrimaService() {
        materiaPrimaDAO = new MateriaPrimaDAO();
    }

    public BaseDTO deletar(String nome) {
        if (DefaultValidator.isBlankOrEmpty(nome)) {
            return BaseDTO.buildFalha("Nome inválido");
        }

        if (!materiaPrimaDAO.isCadastrado(nome)) {
            return BaseDTO.buildFalha("Matéria Prima não encontrada");
        }

        var materiaPrima = buscarMateriaPrimaPorNome(nome);

        try {
            if (materiaPrimaDAO.isUtilizado(materiaPrima.getId())) {
                return BaseDTO.buildFalha("matéria-prima sendo utilizada por um ou mais produtos");
            }
        } catch (SQLException e) {
            return BaseDTO.buildFalha("não foi possível verificar se matéria-prima está sendo utilizada");
        }

        var resultadoDeletacao = deletarMateriaPrima(materiaPrima);
        if (!resultadoDeletacao.getIsSucesso()) {
            return BaseDTO.buildFalha("Não foi possivel deletar Matéria Prima");
        }
        return BaseDTO.buildSucesso("Matéria Prima deletada com sucesso!", resultadoDeletacao.getData());
    }

    private MateriaPrimaModel buscarMateriaPrimaPorNome(String nome) {
        return materiaPrimaDAO.buscarPorNome(nome);
    }

    private BaseDTO deletarMateriaPrima(MateriaPrimaModel materiaPrima) {
        return materiaPrimaDAO.deletar(materiaPrima);
    }

}
