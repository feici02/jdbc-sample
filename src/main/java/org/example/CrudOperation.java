package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOperation {

    static void run(Connection connection) throws SQLException {
        // C: create
        final PreparedStatement insertPs = connection.prepareStatement("insert into users(name) values(?)");
        insertPs.setString(1, "Hermione");
        final int insertCount = insertPs.executeUpdate();
        System.out.println("insertCount = " + insertCount);

        // R: select
        final PreparedStatement ps = connection.prepareStatement("select * from users where name = ?");
        ps.setString(1, "Harry");
        final ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println((resultSet.getInt("id") + ": " + resultSet.getString("name")));
        }

        // U: update
        final PreparedStatement updatePs = connection.prepareStatement("update users set name = ? where name = ?");
        updatePs.setString(1, "Harry Potter");
        updatePs.setString(2, "Harry");
        final int updateCount = updatePs.executeUpdate();
        System.out.println("updateCount = " + updateCount);

        // D: delete
        final PreparedStatement deletePs = connection.prepareStatement("delete from users where name = ?");
        deletePs.setString(1, "Ron");
        final int deleteCount = deletePs.executeUpdate();
        System.out.println("deleteCount = " + deleteCount);
    }
}
