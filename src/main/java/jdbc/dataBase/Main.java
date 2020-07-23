package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int choice = 0;


    public static void main(String[] args) throws SQLException {
        //Seleccionamos la BBDD
        SelectDatabase dataBase = new SelectDatabase();
        //Creamos la conexión y el statement para elegir si queremos SELECTs or UPDATEs
        Connection conn2 = dataBase.getConnection();
        java.sql.Statement stmt = conn2.createStatement();

        muestraMenu();

        //Cerramos statement y conexión
        stmt.close();
        conn2.close();
    }

    public static void muestraMenu() {
        do {
            System.out.println("Selecciona una opción:\n1.- Crear cliente\n2.- Consultar saldo\n3.- Retirar efectivo\n4.- Ingresar efectivo\n5.- Listar transacciones\n0.- Salir");
            choice = scanner.nextInt();
            switch (choice){
                case 1-> crearCliente();
                case 2-> consultarSaldo();
                case 3-> retirarEfectivo();
                case 4-> ingresarEfectivo();
                case 5-> listarTransacciones();
                case 0-> System.exit(1);
                default-> System.out.println("Opción incorrecta");
            }
        }while (choice!=0);
    }

    public static void crearCliente(){
        Cliente cliente = new Cliente();
        System.out.println("------ Creación de cliente ------");
        System.out.println("Introduzca el nombre");
        cliente.setNombre(scanner.nextLine());
        System.out.println("Introduzca el nombre");
        cliente.setNombre(scanner.nextLine());
        System.out.println("Introduzca el nombre");
        cliente.setNombre(scanner.nextLine());
    }

    public static void consultarSaldo(){

    }

    public static void retirarEfectivo(){

    }

    public static void ingresarEfectivo(){

    }

    public static void listarTransacciones(){

    }
}
