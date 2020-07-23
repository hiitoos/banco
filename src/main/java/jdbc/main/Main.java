package jdbc.main;

import jdbc.dataBase.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hola mundo");
        SelectDatabase dataBase = new SelectDatabase();

        Connection conn2 = dataBase.getConnection();
        java.sql.Statement stmt = conn2.createStatement();

        //new CreateDatabase(conn2);  //Esto en caso que no tengamos que crear la BBDD (schema)
        //new CreateTable(conn2, stmt);  //Crea una tabla
        //new DropTable(conn2, stmt); //Drop table
        //new InsertData(conn2, stmt);
        //new TransactionsDatabase(conn2, stmt); //Tiene rollback
        //new SavePoint(conn2, stmt); //Tiene rollback a savepoint
        //new SelectQuery(conn2, stmt);
        //new UpdateData(conn2, stmt);
        new DeleteData(conn2,stmt);

        stmt.close();
        conn2.close();
    }
}
