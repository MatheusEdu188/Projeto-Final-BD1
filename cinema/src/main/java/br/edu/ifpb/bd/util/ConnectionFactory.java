package br.edu.ifpb.bd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/bancoCinema";
    private static final String USER = "postgres";
    private static final String PASSWORD = "050905";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao Conectar ao Banco.", e);
        }
    }
}
