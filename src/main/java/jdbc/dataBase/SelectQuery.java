package jdbc.dataBase;

import java.sql.*;

public class SelectQuery {
    public SelectQuery(Statement stmt, String dni, String var){
        try {
            if (var.equals("cliente")) {
                String SQL = "SELECT clientes.*, cuentas.* FROM cuentas left join clientes on (clientes.idCliente = cuentas.idCliente) WHERE clientes.dni='" + dni + "';";
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    int idCuenta = rs.getInt("idCuenta");
                    int idCliente = rs.getInt("idCliente");
                    String nombre = rs.getString("nombre");
                    int saldo = rs.getInt("saldo");
                    System.out.println("Cliente: " + nombre + ", Saldo: " + saldo + "€, Nº Cuenta: " + idCuenta);
                }
            }
            if (var.equals("transaccion")) {
                String SQL = "SELECT clientes.nombre, transacciones.* FROM transacciones left join clientes on (clientes.idCliente = transacciones.idCliente) WHERE clientes.dni='" + dni + "' ORDER BY fecha ASC;";
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    int idCliente = rs.getInt("idCliente");
                    int idCuenta = rs.getInt("idCuenta");
                    //int idTransaccion = rs.getInt("idTransacciones");
                    String nombre = rs.getString("nombre");
                    int saldo = rs.getInt("transacciones.saldo");
                    Date date = rs.getDate("fecha");
                    String concepto = rs.getString("concepto");
                    int accion = rs.getInt("accion");
                    System.out.println("Cliente: " + nombre +
                           // ", ID-Transaccion: " + idTransaccion +
                            ", Saldo: " + saldo +
                            "€, Fecha: " + date +
                            ", Cuenta: " + idCuenta +
                            ", Concepto: " + concepto);
                }
            }
            if (var.equals("cuentas")){
                String SQL = "SELECT clientes.nombre, cuentas.idCuenta FROM cuentas left join clientes on (clientes.idCliente = cuentas.idCliente) WHERE clientes.dni='" + dni + "';";
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    int idCuenta = rs.getInt("idCuenta");
                    String nombre = rs.getString("nombre");
                    System.out.println("Cliente: " + nombre +
                            // ", ID-Transaccion: " + idTransaccion +
                            ", Numero de cuenta: " + idCuenta);
                }
            }
            System.out.println("");
            } catch (SQLException exception) {
                System.out.println("Error al rollback and save point" + exception);
            }
    }
}
