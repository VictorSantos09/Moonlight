package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.models.relatorios.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioDAO extends ConexaoBanco {
    public ProdutoMaisCaroRelatorio buscarMaisCaro() throws RuntimeException {
        try {
            var conexao = connect();
            var rs = conexao.prepareStatement("SELECT * FROM moonlight.vw_relatorio ORDER BY VALOR LIMIT 1;")
                    .executeQuery();

            var resultado = build(rs);

            if (resultado == null) {
                throw new RuntimeException("relatório não encontrado");
            }

            return ProdutoMaisCaroRelatorio.buildFromBase(resultado);
        } catch (Exception e) {
            throw new RuntimeException("um erro ocorreu ao buscar o relatório. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public ProdutoMaisBaratoRelatorio buscarMaisBarato() throws RuntimeException {
        try {
            var conexao = connect();
            var rs = conexao.prepareStatement("SELECT * FROM moonlight.vw_relatorio ORDER BY VALOR DESC LIMIT 1;")
                    .executeQuery();

            var resultado = build(rs);

            if (resultado == null) {
                throw new RuntimeException("relatório não encontrado");
            }

            return ProdutoMaisBaratoRelatorio.buildFromBase(resultado);

        } catch (Exception e) {
            throw new RuntimeException("um erro ocorreu ao buscar o relatório. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public ProdutoFabricacaoMaisBaratoRelatorio buscarFabricacaoMaisBarata() throws RuntimeException {
        try {
            var conexao = connect();
            var rs = conexao.prepareStatement("SELECT * FROM moonlight.vw_relatorio ORDER BY SUBTOTAL LIMIT 1;")
                    .executeQuery();

            var resultado = build(rs);

            if (resultado == null) {
                throw new RuntimeException("relatório não encontrado");
            }

            return ProdutoFabricacaoMaisBaratoRelatorio.buildFromBase(resultado);

        } catch (Exception e) {
            throw new RuntimeException("um erro ocorreu ao buscar o relatório. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public ProdutoFabricacaoMaisCaroRelatorio buscarFabricacaoMaisCara() throws RuntimeException {
        try {
            var conexao = connect();
            var rs = conexao.prepareStatement("SELECT * FROM moonlight.vw_relatorio ORDER BY SUBTOTAL DESC LIMIT 1;")
                    .executeQuery();

            var resultado = build(rs);

            if (resultado == null) {
                throw new RuntimeException("relatório não encontrado");
            }

            return ProdutoFabricacaoMaisCaroRelatorio.buildFromBase(resultado);

        } catch (Exception e) {
            throw new RuntimeException("um erro ocorreu ao buscar o relatório. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private BaseProdutoRelatorio build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            var nomeProduto = rs.getString(1);
            var tipoProduto = rs.getString(2);
            var valorvenda = rs.getDouble(3);
            var valorRecomendado = rs.getDouble(4);
            var subtotal = rs.getDouble(5);

            return new BaseProdutoRelatorio(nomeProduto, tipoProduto, valorvenda, valorRecomendado, subtotal);
        } else {
            return null;
        }
    }
}
