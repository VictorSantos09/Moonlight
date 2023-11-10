/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.moonlight.moonlightapp.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author victor.santos8
 */
public class ConexaoBanco {
    private static Connection Connection;
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String Url = "jdbc:mysql://localhost:3306/moonlight";

    protected static final Connection Connect() {
        try {
            Class.forName(Driver);
            Connection = DriverManager.getConnection(Url, "root",
                    "root");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao conectar ao banco de dados.Erro: " + e.toString());
        }
        return Connection;
    }

    protected static final void Disconnect() {
        try {
            Connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao desconectar do banco de dados.Erro: " + e.getMessage());
        }
    }

    public static final boolean TestConnection() {
        try {
            Connect();
            Disconnect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
