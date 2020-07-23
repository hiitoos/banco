package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public UpdateData(Connection conn, Statement stmt, String dni, int cantidad, boolean accion){
        try {
            String SQL;
                //Sentencia SQL comun para ambos casos
            SQL = "UPDATE cuentas cu JOIN clientes cl ON cl.idCliente = cu.idCliente SET cu.saldo = (cu.saldo ";

                //Se añade en funcion del booleano y evitamos repetir codigo
            if (accion)
                SQL+="+";
            else
                SQL+="-";

                //Sentencia SQL comun para ambos casos
            SQL = SQL + cantidad + ") where cl.dni = '" + dni + "'";

            stmt.executeUpdate(SQL);
            new SelectQuery(conn, stmt, dni);
        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }
    }
}
