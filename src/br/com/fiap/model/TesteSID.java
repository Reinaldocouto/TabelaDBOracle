package br.com.fiap.model;

import java.sql.*;

public class TesteSID {

    public static void main(String[] args) throws SQLException {
        // Obtém o SID especificado no código Java
        String SID = "gemco";

        // Obtém o SID configurado no listener do banco de dados
        String listenerSID = getListenerSID();

        // Verifica se os SIDs são iguais
        if (SID.equals(listenerSID)) {
            System.out.println("Os SIDs são iguais.");
        } else {
            System.out.println("Os SIDs são diferentes.");
        }
    }

    private static String getListenerSID() throws SQLException {
        // Conecta ao listener do banco de dados
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm94330", "fiap");

        // Obtém o SID configurado no listener do banco de dados
        String listenerSID = connection.getMetaData().getDatabaseProductName();

        // Fecha a conexão
        connection.close();

        return listenerSID;
    }
}
