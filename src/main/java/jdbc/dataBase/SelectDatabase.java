package jdbc.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SelectDatabase {
    Connection connection;

    public SelectDatabase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el driver de MySQL: " + e);
        }

        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/banco",
                    "root",
                    "secret1234"
            );
            boolean valid = connection.isValid(50000);
            if (valid) System.out.println("Conectado a la BBDD correctamente");
        } catch (SQLException exception) {
            System.out.println("Error: " + exception);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
}
