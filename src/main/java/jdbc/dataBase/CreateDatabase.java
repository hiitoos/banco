package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public CreateDatabase(Connection connection, Statement stmt){
        try {
            System.out.println("Creating database...");
            stmt.executeUpdate("CREATE SCHEMA RDBMS");
            System.out.println("Database created successfully...");
        }catch (SQLException exception){
            System.out.println("Error create DB " + exception);
        }

    }
}
