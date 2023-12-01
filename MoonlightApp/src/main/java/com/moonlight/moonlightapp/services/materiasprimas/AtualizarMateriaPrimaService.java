package com.moonlight.moonlightapp.services.materiasprimas;

import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.TipoMateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.materiasprimas.AtualizarMateriaPrimaDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.validators.DefaultValidator;

/**
 *
 * @author amanda.medeiros1
 */
public class AtualizarMateriaPrimaService {
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoMateriaPrimaDAO tipoMateriaPrimaDAO;

    public AtualizarMateriaPrimaService() {
        materiaPrimaDAO = new MateriaPrimaDAO();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoMateriaPrimaDAO = new TipoMateriaPrimaDAO();
    }

    public BaseDTO atualizar(AtualizarMateriaPrimaDTO dto) {
        var resultadoValidacaoEntrada = validarEntrada(dto);
        if (!resultadoValidacaoEntrada.getIsSucesso()) {
            return resultadoValidacaoEntrada;
        }

        if (!materiaPrimaDAO.isCadastrado(dto.getNomeOriginal())) {
            return BaseDTO.buildFalha("matéria-prima não encontrado");
        }

        if (!unidadeMedidaDAO.isCadastrado(dto.getSiglaUnidadeMedida())) {
            return BaseDTO.buildFalha("unidade de medida não encontrada");
        }

        if (!tipoMateriaPrimaDAO.isCadastrado(dto.getTipo())) {
            return BaseDTO.buildFalha("tipo da matéria-prima não encontrado");
        }

        var materiaPrimaOriginal = materiaPrimaDAO.buscarPorNome(dto.getNomeOriginal());
        var unidadeMedida = unidadeMedidaDAO.buscarPorSigla(dto.getSiglaUnidadeMedida());
        var tipo = tipoMateriaPrimaDAO.buscarPorNome(dto.getTipo());

        var materiaPrimaAtualizada = new MateriaPrimaModel(dto.getNomeNovo(), dto.getDescricao(),
                dto.getValor(), dto.getQuantidade(), unidadeMedida, tipo);

        materiaPrimaAtualizada.setId(materiaPrimaOriginal.getId());

        var resultadoAtualizacao = materiaPrimaDAO.atualizar(materiaPrimaAtualizada);

        if (!resultadoAtualizacao.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível atualizar as informações do matéria-prima",
                    resultadoAtualizacao.getMensagem());
        }

        return BaseDTO.buildSucesso("informações da matéria-prima atualizadas com sucesso");
    }

    private BaseDTO validarEntrada(AtualizarMateriaPrimaDTO dto) {
        if (DefaultValidator.isBlankOrEmpty(dto.getDescricao())) {
            return BaseDTO.buildFalha("descrição inválida");
        }

        if (DefaultValidator.isBlankOrEmpty(dto.getNomeOriginal())) {
            return BaseDTO.buildFalha("nome da matéria-prima original inválido");
        }

        if (DefaultValidator.isBlankOrEmpty((dto.getNomeNovo()))) {
            return BaseDTO.buildFalha("nome do novo produto inválido");
        }
        if (DefaultValidator.isBlankOrEmpty(dto.getSiglaUnidadeMedida())) {
            return BaseDTO.buildFalha("unidade de medida inválida");
        }

        if (DefaultValidator.isBlankOrEmpty(dto.getTipo())) {
            return BaseDTO.buildFalha("tipo do produto inválido");
        }

        if(DefaultValidator.isZeroOrNegative(dto.getQuantidade())){
            return BaseDTO.buildFalha("quantidade inválida");
        }

        if(DefaultValidator.isZeroOrNegative(dto.getValor())){
            return BaseDTO.buildFalha("valor inválido");
        }

        return BaseDTO.buildSucesso("dados inválidos");
    }
}
