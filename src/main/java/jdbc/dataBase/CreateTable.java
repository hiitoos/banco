package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public CreateTable(Connection connection, Statement stmt) {
        try {
            System.out.println("Creating table...");
            stmt.executeUpdate(" CREATE TABLE IF NOT EXISTS Employees (" +
                    " id INT NOT NULL AUTO_INCREMENT," +
                    " age INT NOT NULL," +
                    " first VARCHAR(255)," +
                    " last VARCHAR(255)," +
                    " PRIMARY KEY (id))");
            System.out.println("table Employees created successfully...");
        } catch (
                SQLException exception) {
            System.out.println("Error create DB " + exception);
        }
    }
}
