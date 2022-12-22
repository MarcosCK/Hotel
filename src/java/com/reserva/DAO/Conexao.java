










package com.reserva.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Classe para abertura de conexão
public class Conexao {

    private String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/reservascom";
    private final String usuario = "postgres";
    private final String senha = "Churkin3112#";
    Connection conexao;

    public Connection getConexao() {

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao realizada com sucesso!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro de SQL: " + ex.getMessage());
        }
        return conexao;
    }

}

