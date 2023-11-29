package com.moonlight.moonlightapp.services.materiasprimas;

import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.TipoMateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.validators.dtos.UnidadeMedidaDTOValidator;
import com.moonlight.moonlightapp.validators.models.UnidadeMedidaValidator;

public class AtualizarMateriaPrimaService {
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoMateriaPrimaDAO tipoMateriaPrimaDAO;
    private final UnidadeMedidaDTOValidator unidadeMedidaDTOValidator;
    
    public AtualizarMateriaPrimaService(){
        materiaPrimaDAO = new MateriaPrimaDAO();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoMateriaPrimaDAO = new TipoMateriaPrimaDAO();
        unidadeMedidaDTOValidator = new UnidadeMedidaDTOValidator();
    }

    public BaseDTO atualizar(AtualizarMateriaPrimaDTO dto){
        var resultadoValidacaoEntrada = validarEntrada(dto);
        if (!resultadoValidacaoEntrada.getIsSucesso()) {
            return resultadoValidacaoEntrada;
        }

        if (!materiaPrimaDAO.isCadastrado(dto.getNomeOriginal())) {
            return BaseDTO.buildFalha("Materia Prima não encontrada.")
        }

        if (!tipoMateriaPrimaDAO.isCadastrado(dto.getNomeOriginal())) {
            return BaseDTO.buildFalha("Tipo de Materia Prima não encontrada")
        }

        var materiaPrimaOriginal = materiaPrimaDAO.buscarPorNome(dto.getNomeOriginal());
        var unidadeMedida = unidadeMedidaDAO.buscarPorNome(dto.getUnidadeMedida().getNome());
        var tipo = tipoMateriaPrimaDAO.buscarPorNome(dto.getNome());

        var materiaPrimaAtualizada = new MateriaPrimaModel(dto.getNomeNovo(), dto.getDescricao(), materiaPrimaOriginal.getValor(), 
                                                                materiaPrimaOriginal.getQuantidade(), unidadeMedida, tipo);
                materiaPrimaAtualizada.setId(materiaPrimaOriginal.getId());

                var resultadoAtualizacao = materiaPrimaDAO.atualizar(materiaPrimaAtualizada);
    }

}
