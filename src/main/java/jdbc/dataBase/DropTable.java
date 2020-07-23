package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {
    public DropTable(Connection connection , Statement stmt){
        try {
            System.out.println("Creating table...");
            stmt.executeUpdate(" DROP TABLE employees");
            System.out.println("Database removed successfully...");
        } catch (
        SQLException exception) {
            System.out.println("Error drop DB " + exception);
        }
    }
}
