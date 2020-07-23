package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionsDatabase {
    public TransactionsDatabase(Connection conn, Statement stmt) throws SQLException {
        try {
            conn.setAutoCommit(false);
            String SQL = "INSERT INTO Employees  VALUES (106, 20, 'Rita', 'Pascual')";
            stmt.executeUpdate(SQL);

            String SQL2 = "INSERTED IN Employees  VALUES (107, 22, 'Marta', 'Molto')";
            stmt.executeUpdate(SQL2);

            conn.commit();

            stmt.close();
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Error, haciendo rollback: \n" + exception);

        }
    }

}
