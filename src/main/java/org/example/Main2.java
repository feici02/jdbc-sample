package org.example;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        try (final Connection connection = getConnection()) {
            CrudOperation.run(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done.");
    }

    private static Connection getConnection() throws SQLException {
        // get connection from a data source (connection pool)
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:create.sql';");
        return ds.getConnection();
    }
}
