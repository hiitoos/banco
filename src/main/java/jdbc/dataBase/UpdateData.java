package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public UpdateData(Connection conn, Statement stmt){
        try {
            String SQL = "UPDATE employees SET first = 'Perez' WHERE ('id' = '108');";
            stmt.executeUpdate(SQL);

        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }
    }
}
