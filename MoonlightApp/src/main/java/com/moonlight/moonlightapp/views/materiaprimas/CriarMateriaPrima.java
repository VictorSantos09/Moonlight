package com.moonlight.moonlightapp.views.materiaprimas;

import com.moonlight.moonlightapp.converters.MateriaPrimaConverter;
import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.TipoMateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.materiasprimas.MateriaPrimaDTO;
import com.moonlight.moonlightapp.dtos.unidadesmedidas.UnidadeMedidaDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.validators.dtos.MateriaPrimaDTOValidator;
import com.moonlight.moonlightapp.validators.models.MateriaPrimaValidator;

public class CriarMateriaPrima {

    private UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();
    private TipoMateriaPrimaDAO tipoMateriaPrimaDAO = new TipoMateriaPrimaDAO();
    private MateriaPrimaConverter materiaPrimaConverter = new MateriaPrimaConverter();
    private MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
    private MateriaPrimaValidator materiaPrimaValidator = new MateriaPrimaValidator();
    private MateriaPrimaDTOValidator materiaPrimaDTOValidator = new MateriaPrimaDTOValidator();

    public BaseDTO CriarMateriaPrima(MateriaPrimaDTO dto) {
        var resultadoValidacaoEntrada = validarEntrada(dto);

        if (!resultadoValidacaoEntrada.getIsSucesso()) {
            return resultadoValidacaoEntrada;
        }

        if (!unidadeMedidaDAO.isCadastradoPorNome(dto.getSiglaUnidadeMedida())) {
            return BaseDTO.buildFalha("'unidade de medida não encontrado");
        }

        if (!tipoMateriaPrimaDAO.isCadastrado(dto.getTipo())) {
            return BaseDTO.buildFalha("tipo da matéria-prima não encontrado");
        }

        MateriaPrimaModel novaMateriaPrima = materiaPrimaConverter.converterFrom(dto);

        var resultadoValidacaoDados = validarDados(novaMateriaPrima);
        if (!resultadoValidacaoDados.getIsSucesso()) {
            return resultadoValidacaoDados;
        }

        if (materiaPrimaDAO.isCadastrado(dto.getNome())) {
            return BaseDTO.buildFalha("matéria prima já cadastrado ", dto.getNome() + " já foi cadastrado");
        }

        BaseDTO resultadoGravacaoMateriaPrima = materiaPrimaDAO.criar(novaMateriaPrima);
        
        if (!resultadoGravacaoMateriaPrima.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível salvar a matéria prima",
                    resultadoGravacaoMateriaPrima.getMensagem());
        }
        
        return BaseDTO.buildSucesso("matéria prima gravada com sucesso");

    }
    
        private BaseDTO validarDados(MateriaPrimaModel materiaPrima) {
        var resultadoValidacaoMateriaPrima = materiaPrimaValidator.validar(materiaPrima);

        if (!resultadoValidacaoMateriaPrima.isValido()) {
            return BaseDTO.buildFalha("matéria prima inválido", resultadoValidacaoMateriaPrima.getFalhas());
        }

        return BaseDTO.buildSucesso("dados válidos");
    }

    private BaseDTO validarEntrada(MateriaPrimaDTO dto) {
        var resultadoValidacao = materiaPrimaDTOValidator.validar(dto);

        if (resultadoValidacao.isValido()) {
            return BaseDTO.buildSucesso("dados de entrada válidos");
        }

        return BaseDTO.buildFalha("dados de entrada inválidos", resultadoValidacao);
    }

}
