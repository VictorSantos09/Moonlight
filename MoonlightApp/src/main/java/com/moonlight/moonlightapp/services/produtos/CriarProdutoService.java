package com.moonlight.moonlightapp.services.produtos;

import com.moonlight.moonlightapp.converters.ProdutoConverter;
import com.moonlight.moonlightapp.daos.*;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.produtos.ItemProdutoDTO;
import com.moonlight.moonlightapp.dtos.produtos.ProdutoDTO;
import com.moonlight.moonlightapp.models.ItemProdutoModel;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.ProcessoModel;
import com.moonlight.moonlightapp.models.ProdutoModel;
import com.moonlight.moonlightapp.services.CalcularValorRecomendadoProdutoService;
import com.moonlight.moonlightapp.validators.MateriaPrimaValidator;
import com.moonlight.moonlightapp.validators.ProcessoValidator;
import com.moonlight.moonlightapp.validators.ProdutoValidator;
import com.moonlight.moonlightapp.validators.dtos.ProdutoDTOValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CriarProdutoService {
    private final ProcessoDAO processoDAO;
    private final ProdutoDAO produtoDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoProdutoDAO tipoProdutoDAO;
    private final MateriaPrimaDAO materiaPrimaDAO;
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
        produtoConverter = new ProdutoConverter();
        produtoValidator = new ProdutoValidator();
        processoValidator = new ProcessoValidator();
        materiaPrimaValidator = new MateriaPrimaValidator();
        produtoDTOValidator = new ProdutoDTOValidator();
    }

    public BaseDTO criar(ProdutoDTO dto) {
        var resultadoValidacaoEntrada = validarEntrada(dto);

        if (!resultadoValidacaoEntrada.getIsSucesso()) {
            return resultadoValidacaoEntrada;
        }

        var processosModels = buscarProcessos(dto);
        if (processosModels.isEmpty()) {
            return BaseDTO.buildFalha("processo(s) não encontrado(s)");
        }

        var materiaPrimaModels = buscarMateriasPrimas(dto);
        if (materiaPrimaModels.isEmpty()) {
            return BaseDTO.buildFalha("matéria(s) prima(s) não encontrada(s)");
        }

        if (!isUnidadeMedidaCadastrada(dto)) {
            return BaseDTO.buildFalha("unidade de medida não cadastrada");
        }

        if (!isTipoProdutoCadastrado(dto)) {
            return BaseDTO.buildFalha("tipo do produto não cadastrado");
        }

        ProdutoModel novoProduto = produtoConverter.converterFrom(dto);

        var resultadoValidacaoDados = validarDados(novoProduto, processosModels, materiaPrimaModels);
        if (!resultadoValidacaoDados.getIsSucesso()) {
            return resultadoValidacaoDados;
        }

        var valorRecomendado = CalcularValorRecomendadoProdutoService.calcular(processosModels, materiaPrimaModels);

        novoProduto.getValorProduto().setValorRecomendado(valorRecomendado);

        var isProdutoCadastrado = isProdutoCadastrado(dto);
        if (isProdutoCadastrado) {
            return BaseDTO.buildFalha("produto já cadastrado", dto.getNome() + "já foi cadastrado");
        }

        BaseDTO resultadoGravacaoProduto = produtoDAO.criar(novoProduto);

        if (!resultadoGravacaoProduto.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível salvar o produto",
                    resultadoGravacaoProduto.getMensagem());
        }

        var itensProdutosModels = criarItensProdutos(dto);
        if (itensProdutosModels.isEmpty()) {
            return BaseDTO.buildFalha("não foi possível criar os itens do produto");
        }

        var idProduto = produtoDAO.buscarPorNome(novoProduto.getNome()).getId();

        if (idProduto <= 0) {
            return BaseDTO.buildFalha("não foi possível encontrar o produto salvo");
        }

        BaseDTO resultadoGravacaoDetalhes = produtoDAO.criarDetalhes(processosModels, itensProdutosModels, idProduto);

        if (!resultadoGravacaoDetalhes.getIsSucesso()) {
            return BaseDTO.buildFalha("não foi possível gravar os processos e matérias primas do produto",
                    novoProduto.getNome() + " foi cadastrado");
        }

        return BaseDTO.buildSucesso("produto e detalhes gravados com sucesso");
    }

    private BaseDTO validarDados(ProdutoModel produto, List<ProcessoModel> processos,
                                 List<MateriaPrimaModel> materiasPrimas) {
        var resultadoValidacaoProduto = produtoValidator.validar(produto);
        var resultadoValidacaoProcessos = validarProcessos(processos);
        var resultadoValidacaoMateriasPrimas = validarMateriasPrimas(materiasPrimas);

        if (!resultadoValidacaoProcessos.getIsSucesso()) {
            return BaseDTO.buildFalha("um processo ou mais inválidos", resultadoValidacaoProcessos.getData());
        }

        if (!resultadoValidacaoMateriasPrimas.getIsSucesso()) {
            return BaseDTO.buildFalha("uma ou mais matérias primas inválidas",
                    resultadoValidacaoMateriasPrimas.getData());
        }

        if (!resultadoValidacaoProduto.isValido()) {
            return BaseDTO.buildFalha("produto inválido", resultadoValidacaoProduto.getFalhas());
        }

        return BaseDTO.buildSucesso("dados válidos");
    }

    private BaseDTO validarProcessos(List<ProcessoModel> processos) {
        List<String> falhas = new ArrayList<>();

        processos.forEach(p -> {
            var resultado = processoValidator.validar(p);

            if (!resultado.isValido()) {
                falhas.addAll(resultado.getFalhas());
            }
        });

        if (!falhas.isEmpty()) {
            return BaseDTO.buildFalha("Processo(s) inválido(s)", falhas);
        }

        return BaseDTO.buildSucesso("Todos os processos são válidos");
    }

    private BaseDTO validarMateriasPrimas(List<MateriaPrimaModel> materiasPrimas) {
        List<String> falhas = materiasPrimas.stream()
                .map(materiaPrimaValidator::validar)
                .filter(resultado -> !resultado.isValido())
                .flatMap(resultado -> resultado.getFalhas().stream())
                .collect(Collectors.toList());

        if (!falhas.isEmpty()) {
            return BaseDTO.buildFalha("matérias primas(s) inválida(s)", falhas);
        }

        return BaseDTO.buildSucesso("Todas as matérias primas são válidas");
    }

    private List<ProcessoModel> buscarProcessos(ProdutoDTO dto) {
        return dto.getProcessos().stream()
                .map(p -> processoDAO.buscarPorEtapa(p.getEtapa()))
                .collect(Collectors.toList());
    }

    private List<MateriaPrimaModel> buscarMateriasPrimas(ProdutoDTO dto) {
        return dto.getItensProdutos().stream()
                .map(ip -> materiaPrimaDAO.buscarPorNome(ip.getNomeMateriaPrima()))
                .collect(Collectors.toList());
    }

    private double calcularSubtotalMateriaPrima(MateriaPrimaModel materiaPrima, ItemProdutoDTO dto) {
        return materiaPrima.getValor() * dto.getQuantidade();
    }

    private List<ItemProdutoModel> criarItensProdutos(ProdutoDTO dto) throws RuntimeException {
        List<ItemProdutoModel> output = new ArrayList<>();

        dto.getItensProdutos().forEach(ip -> {
            var produto = produtoDAO.buscarPorNome(ip.getNomeProduto());

            if (produto == null) {
                throw new RuntimeException("não foi possível encontrar o produto " + ip.getNomeProduto());
            }

            var materiaPrima = materiaPrimaDAO.buscarPorNome(ip.getNomeMateriaPrima());

            if (materiaPrima == null) {
                throw new RuntimeException("não foi possível encontrar a matéria-prima " + ip.getNomeMateriaPrima());
            }

            var subTotal = calcularSubtotalMateriaPrima(materiaPrima, ip);

            var itemProduto = new ItemProdutoModel(ip.getQuantidade(), produto, subTotal, materiaPrima);
            output.add(itemProduto);
        });

        return output;
    }

    private boolean isProdutoCadastrado(ProdutoDTO dto) {
        var produtoEncontrado = produtoDAO.buscarPorNome(dto.getNome());
        return produtoEncontrado != null;
    }

    private boolean isUnidadeMedidaCadastrada(ProdutoDTO dto) {
        return unidadeMedidaDAO.buscarPorSigla(dto.getUnidadeMedida().getSigla()) != null;
    }

    private boolean isTipoProdutoCadastrado(ProdutoDTO dto) {
        return tipoProdutoDAO.buscarPorNome(dto.getTipoProduto().getNome()) != null;
    }

    private BaseDTO validarEntrada(ProdutoDTO dto) {
        var resultadoValidacao = produtoDTOValidator.validar(dto);

        if (resultadoValidacao.isValido()) {
            return BaseDTO.buildSucesso("dados de entrada válidos");
        }

        return BaseDTO.buildFalha("dados de entrada inválidos", resultadoValidacao);
    }
}