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
    public InsertData(Connection conn, Statement stmt, String dni, String concepto, boolean accion, int cantidad){
        try{
            String SQL="insert into transacciones (saldo, fecha, concepto, accion, idCliente) values ((SELECT saldo from cuentas left join clientes on cuentas.idCliente = clientes.idCliente where clientes.dni='"+
                    dni +"'), FROM_UNIXTIME(UNIX_TIMESTAMP('1973-01-01 14:53:27') + FLOOR(0 + (RAND() * 63072000))), '"+
                    concepto + "', " + accion + ", (Select idCliente from clientes where dni='" + dni + "'))";

            stmt.executeUpdate(SQL);
        }catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }
    }
}
