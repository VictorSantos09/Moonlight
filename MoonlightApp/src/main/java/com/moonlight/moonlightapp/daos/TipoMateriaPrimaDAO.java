package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorIdDAO;
import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.models.TipoMateriaPrimaModel;
import com.moonlight.moonlightapp.models.TipoProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoMateriaPrimaDAO extends ConexaoBanco
        implements BuscarPorNomeDAO<TipoMateriaPrimaModel>, BuscarPorIdDAO<TipoMateriaPrimaModel> {

    @Override
    public TipoMateriaPrimaModel buscarPorNome(String name) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM tipos_materias_primas WHERE NOME = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException(
                    "um erro ocorreu ao buscar o tipo de materia prima por nome. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    @Override
    public TipoMateriaPrimaModel buscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM tipos_materias_primas WHERE ID_TIPO_MATERIA_PRIMA = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return build(rs);
        } catch (SQLException e) {
            throw new RuntimeException(
                    "um erro ocorreu ao buscar o tipo de materia prima por id. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<TipoMateriaPrimaModel> buscarTodos() {
        try {
            Connection conexao = connect();

            String sql = "SELECT * FROM tipos_materias_primas";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            return buildList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(
                    "um erro ocorreu ao buscar o tipo de materia prima por id. Erro: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private TipoMateriaPrimaModel build(ResultSet rs) throws SQLException {
        if (rs.next()) {
            var id = rs.getInt(1);
            String nome = rs.getString(2);

            var tipoMateriaPrima = new TipoMateriaPrimaModel(nome);
            tipoMateriaPrima.setId(id);

            return tipoMateriaPrima;
        } else {
            return null;
        }
    }

    private List<TipoMateriaPrimaModel> buildList(ResultSet rs) throws SQLException {
        List<TipoMateriaPrimaModel> output = new ArrayList<>();

        while (rs.next()) {
            var id = rs.getInt(1);
            String nome = rs.getString(2);

            var tipoMateriaPrima = new TipoMateriaPrimaModel(nome);
            tipoMateriaPrima.setId(id);

            output.add(tipoMateriaPrima);
        }

        return output;
    }

    public  Boolean isCadastrado(TipoMateriaPrimaModel model){
        return  buscarPorNome(model.getNome()) != null;
     }
    
    public Boolean isCadastrado(String nome){
        return buscarPorNome(nome) != null;
    }
}
