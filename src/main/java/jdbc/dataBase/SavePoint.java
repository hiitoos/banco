package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePoint {

    public SavePoint(Connection conn, Statement stmt) throws SQLException {
        Savepoint svpoint = conn.setSavepoint();

        try {
            conn.setAutoCommit(false);
            String SQL = "INSERT INTO employees VALUES (DEFAULT, 20, 'Orellana', 'point')";
            stmt.executeUpdate(SQL);
            svpoint = conn.setSavepoint();

            String SQL2 = "INSERTED IN Employees VALUES (DEFAULT, 22, 'Sita', 'Tez')";
            stmt.executeUpdate(SQL2);
            conn.commit();

        } catch (SQLException exception) {
            conn.rollback(svpoint);
            conn.commit();
            System.out.println("Error al rollback and save point" + exception);
        }

    }
}
