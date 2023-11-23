package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.IsCadastrado;
import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ProcessoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessoDAO extends ConexaoBanco
        implements ModelDAO<ProcessoModel>, IsCadastrado<String> {

    public ProcessoModel buscarPorEtapa(String etapa) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM processos WHERE ETAPA = ?");
            ps.setString(1, etapa);
            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar processo por etapa: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public ProcessoModel buscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM processos WHERE ID_PROCESSO = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar processo por id: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO criar(ProcessoModel model) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao
                    .prepareStatement("INSERT INTO processos (ETAPA, CUSTO, ID_PRODUTO) VALUES (?, ?, ?)");
            ps.setString(1, model.getEtapa());
            ps.setDouble(2, model.getCusto());

            ps.execute();
            return BaseDTO.buildSucesso("Processo criado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar processo: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(ProcessoModel modelAtualizado) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao
                    .prepareStatement(
                            "UPDATE processos SET ETAPA = ?, CUSTO = ?, ID_PRODUTO = ? WHERE ID_PROCESSO = ?");

            ps.setString(1, modelAtualizado.getEtapa());
            ps.setDouble(2, modelAtualizado.getCusto());
            ps.setInt(3, modelAtualizado.getId());

            ps.executeUpdate();

            return BaseDTO.buildSucesso("Processo atualizado com sucesso", null);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar processo: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO deletar(ProcessoModel model) throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("DELETE FROM processos WHERE ID_PROCESSO = ?");
            ps.setInt(1, model.getId());

            ps.execute();

            return BaseDTO.buildSucesso("Processo deletado com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar processo: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public Boolean isCadastrado(String etapa) throws RuntimeException {
        return buscarPorEtapa(etapa) != null;
    }

    public List<ProcessoModel> buscarTodos() throws RuntimeException {
        try {
            Connection conexao = connect();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM processos");

            ResultSet rs = ps.executeQuery();

            return buildList(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os processos: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private ProcessoModel build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            int id = rs.getInt(1);
            String etapa = rs.getString(2);
            double custo = rs.getDouble(3);

            ProcessoModel processo = new ProcessoModel(etapa, custo);
            processo.setId(id);
            return processo;
        } else {
            return null;
        }
    }

    private List<ProcessoModel> buildList(ResultSet rs) throws SQLException {
        List<ProcessoModel> processos = new ArrayList<>();
        while (rs.next()) {
            var processo = build(rs);
            processos.add(processo);
        }
        return processos;
    }
}