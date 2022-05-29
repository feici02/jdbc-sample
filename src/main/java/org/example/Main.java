package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (final Connection connection = getConnection()) {
            CrudOperation.run(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done.");
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager
                .getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:create.sql';");
    }
}