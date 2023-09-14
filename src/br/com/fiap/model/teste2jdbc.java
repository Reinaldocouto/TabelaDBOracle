package br.com.fiap.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class teste2jdbc {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        
        try {
            // Carregar o driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Conecta ao banco de dados
            connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm94330", "fiap");

            // Verifica se a conexão é válida
            if (connection != null && connection.isValid(0)) {
                System.out.println("Conexão válida!");

                // Executa uma consulta no banco de dados
                // ...

                // Fecha a conexão
                connection.close();
            } else {
                System.out.println("Falha na conexão!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC Oracle não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
