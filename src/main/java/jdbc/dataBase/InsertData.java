package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public InsertData(Connection conn, Statement stmt, Cliente cliente) {
        try {
            String SQL = "INSERT INTO clientes (dni, nombre, apellido1, apellido2) VALUES ('" +
                    cliente.getDni() + "','" +
                    cliente.getNombre() +"','" +
                    cliente.getApellido1() + "','" +
                    cliente.getApellido2()+"')";
            stmt.executeUpdate(SQL);


        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }
    }
}
