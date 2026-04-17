package com.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.1.123:5432/postgres";
        String user = "postgres";
        String password = "daniel"; // troca aqui se a tua senha for diferente

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("✅ Conexão estabelecida com sucesso!");

            ResultSet rs = stmt.executeQuery("SELECT version();");
            if (rs.next()) {
                System.out.println("Versão do PostgreSQL: " + rs.getString(1));
            }

        } catch (Exception e) {
            System.err.println("❌ Erro ao conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
