package com.moonlight.moonlightapp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.moonlight.moonlightapp.daos.contracts.BuscarPorNomeDAO;
import com.moonlight.moonlightapp.daos.contracts.ModelDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.models.ProdutoModel;

public final class ProdutoDAO extends ConexaoBanco
        implements ModelDAO<ProdutoModel>, BuscarPorNomeDAO<ProdutoModel> {

    @Override
    public final BaseDTO criar(ProdutoModel model) {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO produtos (NOME, DESCRICAO) VALUES (?, ?)");
            ps.setString(1, model.getNome());
            ps.setString(2, model.getDescricao());
            ps.execute();

            return BaseDTO.BuildSucesso("Produto criado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        }
        finally {
            disconnect();
        }
    }

    @Override
    public final BaseDTO atualizar(ProdutoModel modelAtualizado) {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("UPDATE produtos SET NOME = ?, DESCRICAO = ? WHERE ID = ?");
            ps.setString(1, modelAtualizado.getNome());
            ps.setString(2, modelAtualizado.getDescricao());
            ps.setInt(3, modelAtualizado.getId());
            ps.executeUpdate();

            return BaseDTO.BuildSucesso("Produto atualizado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        }
        finally {
            disconnect();
        }
    }

    @Override
    public final BaseDTO deletar(ProdutoModel model) {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM produtos WHERE ID = ?");
            ps.setInt(1, model.getId());
            ps.executeUpdate();

            return BaseDTO.BuildSucesso("Produto deletado com sucesso", null);
        } catch (Exception e) {
            return BaseDTO.BuildException(e);
        }
        finally {
            disconnect();
        }
    }

    @Override
    public final ProdutoModel BuscarPorId(int id) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos WHERE ID_PRODUTO = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return Build(rs);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto por ID", e);
        }
        finally {
            disconnect();
        }
    }

    @Override
    public final ProdutoModel buscarPorNome(String name) throws RuntimeException {
        try {
            Connection conexao = connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos WHERE NOME = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            return Build(rs);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto por nome. Erro: ", e);
        }
        finally {
            disconnect();
        }
    }

    private final ProdutoModel Build(ResultSet rs) throws RuntimeException {
        try {
            if (rs.next()) {
                int ProdutoId = rs.getInt("ID_PRODUTO");
                String nome = rs.getString("NOME");
                String descricao = rs.getString("DESCRICAO");
                ProdutoModel produto = new ProdutoModel(nome, descricao);
                produto.setId(ProdutoId);
                return produto;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto por nome. Erro: ", e);
        }
        finally {
            disconnect();
        }
    }
}