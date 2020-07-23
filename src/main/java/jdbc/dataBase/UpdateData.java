package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public UpdateData(Connection conn, Statement stmt, String dni, int cantidad, boolean accion){
        try {
            new SelectQuery(conn, stmt, dni);
            String SQL;
            if (accion) {
                SQL = "UPDATE cuentas cu JOIN clientes cl ON cl.idCliente = cu.idCliente SET cu.saldo = cu.saldo" + (+cantidad) + " where cl.dni = '" + dni + "'";
            }
            else {
                SQL = "UPDATE cuentas cu JOIN clientes cl ON cl.idCliente = cu.idCliente SET cu.saldo = cu.saldo" + (-cantidad)  +" where cl.dni = '"+ dni + "'";
            }

            stmt.executeUpdate(SQL);

        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }
    }
}
