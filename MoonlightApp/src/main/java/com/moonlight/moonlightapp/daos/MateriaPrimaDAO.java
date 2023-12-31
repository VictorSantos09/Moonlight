package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.daos.contracts.IsCadastrado;
import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.models.TipoMateriaPrimaModel;
import com.moonlight.moonlightapp.models.UnidadeMedidaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaPrimaDAO extends ConexaoBanco
        implements ModelDAO<MateriaPrimaModel>, BuscarPorNomeDAO<MateriaPrimaModel>, IsCadastrado<String> {

    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoMateriaPrimaDAO tipoMateriaPrimaDAO;

    public MateriaPrimaDAO() {
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoMateriaPrimaDAO = new TipoMateriaPrimaDAO();

    }

    @Override
    public MateriaPrimaModel buscarPorNome(String name) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM materias_primas WHERE NOME = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar matéria-prima por nome: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<MateriaPrimaModel> buscarTodos() throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM materias_primas");
            ResultSet rs = ps.executeQuery();

            return buildList(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar matéria-prima por nome: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO criar(MateriaPrimaModel model) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao
                    .prepareStatement(
                            "INSERT INTO materias_primas (nome, descricao, quantidade, valor, ID_UNIDADE_MEDIDA, ID_TIPO_MATERIA_PRIMA) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, model.getNome());
            ps.setString(2, model.getDescricao());
            ps.setInt(3, model.getQuantidade());
            ps.setDouble(4, model.getValor());
            ps.setInt(5, model.getUnidadeMedida().getId());
            ps.setInt(6, model.getTipoMateriaPrima().getId());

            ps.execute();
            return BaseDTO.buildSucesso("Matéria-prima criada com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar matéria-prima: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO atualizar(MateriaPrimaModel modelAtualizado) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao
                    .prepareStatement(
                            "UPDATE materias_primas SET nome = ?, descricao = ?, quantidade = ?, valor = ?, id_unidade_medida = ?, id_tipo_materia_prima = ? WHERE ID_MATERIA_PRIMA = ?");
            ps.setString(1, modelAtualizado.getNome());
            ps.setString(2, modelAtualizado.getDescricao());
            ps.setInt(3, modelAtualizado.getQuantidade());
            ps.setDouble(4, modelAtualizado.getValor());
            ps.setInt(5, modelAtualizado.getUnidadeMedida().getId());
            ps.setInt(6, modelAtualizado.getTipoMateriaPrima().getId());
            ps.setInt(7, modelAtualizado.getId());

            ps.executeUpdate();

            return BaseDTO.buildSucesso("Matéria-prima atualizada com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar matéria-prima: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public BaseDTO deletar(MateriaPrimaModel model) throws RuntimeException {
        try {
            if (isUtilizado(model.getId())) {
                return BaseDTO.buildFalha("matéria-prima sendo utilizada por 1 ou mais produtos");
            }

            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM materias_primas WHERE ID_MATERIA_PRIMA = ?");
            ps.setInt(1, model.getId());
            ps.execute();

            return BaseDTO.buildSucesso("Matéria-prima deletada com sucesso", null);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar matéria-prima: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public Boolean isCadastrado(String nome) throws RuntimeException {
        return buscarPorNome(nome) != null;
    }

    @Override
    public MateriaPrimaModel buscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM materias_primas WHERE ID_MATERIA_PRIMA = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar matéria-prima por id: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private MateriaPrimaModel build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            int id = rs.getInt(1);
            String nome = rs.getString(2);
            String descricao = rs.getString(3);
            double valor = rs.getDouble(4);
            int quantidade = rs.getInt(5);
            int idUnidadeMedida = rs.getInt(6);
            int idTipoMateriaPrima = rs.getInt(7);

            UnidadeMedidaModel unidadeMedida = buscarUnidadeMedidaPorId(idUnidadeMedida);
            TipoMateriaPrimaModel tipoMateriaPrima = buscarTipoMateriaPrimaPorId(idTipoMateriaPrima);

            MateriaPrimaModel materiaPrima = new MateriaPrimaModel(nome, descricao, valor, quantidade, unidadeMedida,
                    tipoMateriaPrima);
            materiaPrima.setId(id);

            return materiaPrima;
        } else {
            return null;
        }
    }

    private List<MateriaPrimaModel> buildList(ResultSet rs) throws SQLException {
        List<MateriaPrimaModel> output = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String nome = rs.getString(2);
            String descricao = rs.getString(3);
            double valor = rs.getDouble(4);
            int quantidade = rs.getInt(5);
            int idUnidadeMedida = rs.getInt(6);
            int idTipoMateriaPrima = rs.getInt(7);

            UnidadeMedidaModel unidadeMedida = buscarUnidadeMedidaPorId(idUnidadeMedida);
            TipoMateriaPrimaModel tipoMateriaPrima = buscarTipoMateriaPrimaPorId(idTipoMateriaPrima);

            MateriaPrimaModel materiaPrima = new MateriaPrimaModel(nome, descricao, valor, quantidade, unidadeMedida,
                    tipoMateriaPrima);
            materiaPrima.setId(id);

            output.add(materiaPrima);
        }

        return output.isEmpty() ? List.of() : output;
    }

    private UnidadeMedidaModel buscarUnidadeMedidaPorId(int id) {
        return unidadeMedidaDAO.buscarPorId(id);
    }

    private TipoMateriaPrimaModel buscarTipoMateriaPrimaPorId(int id) {
        return tipoMateriaPrimaDAO.buscarPorId(id);
    }

    public Boolean isUtilizado(Integer id) throws SQLException {
        var conexao = connect();
        var ps = conexao.prepareStatement("SELECT * FROM itens_produtos WHERE ID_MATERIA_PRIMA = ? LIMIT 1");
        ps.setInt(1, id);
        var rs = ps.executeQuery();

        return rs.next();
    }
}