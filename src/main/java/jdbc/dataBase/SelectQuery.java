package jdbc.dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {
    public SelectQuery(Connection conn, Statement stmt){
        try {
            String SQL = "SELECT * FROM Employees";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                System.out.println("ID: " + id + ", Age: " + age + ", First: " + first + ", Last: " + last);
            }

        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }

    }
}
