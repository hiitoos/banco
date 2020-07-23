package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

    public DeleteData(Connection conn, Statement stmt) {
        try {
            String SQL = "DELETE FROM employees WHERE id='108'";
            stmt.executeUpdate(SQL);
        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point\n" + exception);
        }
    }
}
