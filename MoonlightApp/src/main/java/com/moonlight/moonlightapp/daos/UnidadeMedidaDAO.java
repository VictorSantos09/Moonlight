package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorIdDAO;
import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadeMedidaDAO extends ConexaoBanco
        implements BuscarPorNomeDAO<UnidadeMedidaModel>, BuscarPorIdDAO<UnidadeMedidaModel> {

    @Override
    public UnidadeMedidaModel buscarPorNome(String name) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM unidades_medidas WHERE NOME = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException(
                    "um erro ocorreu ao buscar a unidade de medida por nome. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public UnidadeMedidaModel buscarPorSigla(String sigla) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM unidades_medidas WHERE SIGLA = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, sigla);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException(
                    "um erro ocorreu ao buscar a unidade de medida por sigla. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public UnidadeMedidaModel buscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM unidades_medidas WHERE ID_UNIDADE_MEDIDA = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("um erro ocorreu ao buscar a unidade de medida por id. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<UnidadeMedidaModel> buscarTodos() {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM unidades_medidas";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            return buildList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(
                    "um erro ocorreu ao buscar todas as unidades de medida. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public Boolean isCadastrado(String sigla) {
        return buscarPorSigla(sigla) != null;
    }

    public Boolean isCadastradoPorNome(String nome) {
        return buscarPorNome(nome) != null;
    }

    private UnidadeMedidaModel build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            var id = rs.getInt(1);
            String nome = rs.getString(2);
            String sigla = rs.getString(3);

            var unidadeMedida = new UnidadeMedidaModel(nome, sigla);
            unidadeMedida.setId(id);

            return unidadeMedida;
        } else {
            return null;
        }
    }

    private List<UnidadeMedidaModel> buildList(ResultSet rs) throws SQLException {
        List<UnidadeMedidaModel> unidadesMedidas = new ArrayList<>();
        while (rs.next()) {

            var unidadeMedida = build(rs);
            unidadesMedidas.add(unidadeMedida);

        }
        return unidadesMedidas.isEmpty() ? List.of() : unidadesMedidas;
    }
}
