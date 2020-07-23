package jdbc.dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {
    public SelectQuery(Connection conn, Statement stmt, String dni){
        try {
            String SQL = "SELECT clientes.*, cuentas.* FROM cuentas left join clientes on (clientes.idCliente = cuentas.idCliente) WHERE clientes.dni='" + dni + "';";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int idCuenta = rs.getInt("idCuenta");
                int idCliente = rs.getInt("idCliente");
                String nombre = rs.getString("nombre");
                int saldo = rs.getInt("saldo");
                System.out.println("Cliente: " + nombre + ", Saldo: " + saldo + "€");
            }

        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }
        System.out.println("");
    }
}
