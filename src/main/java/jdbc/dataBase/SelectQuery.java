package jdbc.dataBase;

import java.sql.*;

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
                System.out.println("Cliente: " + nombre + ", Saldo: " + saldo + "€, Nº Cuenta: " + idCuenta);
            }

        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point" + exception);
        }
        System.out.println("");
    }
    public SelectQuery(Connection conn, Statement stmt, String dni, String a){
        try {
            String SQL = "SELECT clientes.nombre, transacciones.* FROM transacciones left join clientes on (clientes.idCliente = transacciones.idCliente) WHERE clientes.dni='" + dni + "';";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                int idTransaccion = rs.getInt("idTransacciones");
                String nombre = rs.getString("nombre");
                int saldo = rs.getInt("transacciones.saldo");
                Date date = rs.getDate("fecha");
                String concepto = rs.getString("concepto");
                int accion = rs.getInt("accion");
                System.out.println("Cliente: " + nombre +
                        ", ID-Transaccion: " +
                        idTransaccion + ", Saldo: " +
                        saldo + "€, Fecha: " + date +
                        ", Concepto: " + concepto);
            }

        } catch (SQLException exception) {
            System.out.println("Error al rollback and save point SELECTDATA" + exception);
        }
        System.out.println("");
    }
}
