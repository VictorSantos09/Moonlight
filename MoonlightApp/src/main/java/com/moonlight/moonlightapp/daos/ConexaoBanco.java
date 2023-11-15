package com.moonlight.moonlightapp.daos;

import com.moonlight.moonlightapp.models.ItemProdutoModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe responsável por estabelecer a conexão com o banco de dados MySQL.
 *
 * @author victor
 */
public abstract class ConexaoBanco {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/moonlight";
    private static Connection connection;

    protected static Connection connect() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, "root",
                    "root");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao conectar ao banco de dados.Erro: " + e);
        }
        return connection;
    }

    protected static void disconnect() {
        try {
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao desconectar do banco de dados.Erro: " + e.getMessage());
        }
    }

    public static boolean testConnection() {
        try {
            connect();
            disconnect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
