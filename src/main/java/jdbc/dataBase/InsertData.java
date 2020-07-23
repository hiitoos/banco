package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public InsertData(Connection conn, Statement stmt) {
        try {
            String SQL = "INSERT INTO employees " +
                    "VALUES (108, 20, 'save', 'point')";
            stmt.executeUpdate(SQL);

        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }
    }
}
