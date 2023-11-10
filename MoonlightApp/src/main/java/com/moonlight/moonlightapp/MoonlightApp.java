/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.moonlight.moonlightapp;

import javax.swing.JOptionPane;

import com.moonlight.moonlightapp.daos.ConexaoBanco;

/**
 *
 * @author amanda.medeiros1
 */
public class MoonlightApp {

    public static void main(String[] args) {
        boolean isConexaoOk = ConexaoBanco.TestConnection();
        JOptionPane.showMessageDialog(null, "Conexão com o banco de dados: " + (isConexaoOk ? "OK" : "FALHA"));
        System.out.println("Hello World!");
    }
}
