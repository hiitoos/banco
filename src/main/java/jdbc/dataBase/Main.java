package jdbc.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int choice = 0;
    static SelectDatabase dataBase;
    static Connection conn2;
    static java.sql.Statement stmt;

    public static void main(String[] args) throws SQLException {
        //Seleccionamos la BBDD
        dataBase = new SelectDatabase();
        //Creamos la conexión y el statement para elegir si queremos SELECTs or UPDATEs
        conn2 = dataBase.getConnection();
        stmt = conn2.createStatement();

        muestraMenu();

        //Cerramos statement y conexión
        stmt.close();
        conn2.close();
    }

    public static void muestraMenu() {
        do {
            System.out.println("Selecciona una opción:\n1.- Crear cliente\n2.- Consultar saldo\n3.- Retirar efectivo\n4.- Ingresar efectivo\n5.- Listar transacciones\n0.- Salir");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> crearCliente();
                case 2 -> consultarSaldo();
                case 3 -> retirarEfectivo();
                case 4 -> ingresarEfectivo();
                case 5 -> listarTransacciones();
                case 0 -> System.exit(1);
                default -> System.out.println("Opción incorrecta");
            }
        } while (choice != 0);
    }

    public static void crearCliente() {
        String dni;
        Cliente cliente = new Cliente();
        System.out.println("------ Creación de cliente ------");
        do {
            System.out.println("Introduzca el DNI");
            dni = scanner.next();
            if (validarDni(dni))
                cliente.setDni(dni);
            else
                System.out.println("DNI no válido");
        }while (!validarDni(dni));

        System.out.println("Introduzca el nombre");
        cliente.setNombre(scanner.next());
        System.out.println("Introduzca el primer apellido");
        cliente.setApellido1(scanner.next());
        System.out.println("Introduzca el segundo apellido");
        cliente.setApellido2(scanner.next());
        new InsertData(conn2, stmt, cliente);
    }

    public static boolean validarDni(String nif) {
        boolean correcto = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(nif);
        if (matcher.matches()) {
            String letra = matcher.group(2);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = letras.substring(index, index + 1);
            if (reference.equalsIgnoreCase(letra)) {
                correcto = true;
            } else {
                correcto = false;
            }
        } else {
            correcto = false;
        }
        return correcto;
    }


    public static void consultarSaldo() {
        String dni;
        System.out.println("Introduzca el DNI del titular de la cuenta");
        dni = scanner.next();
        new SelectQuery(conn2,stmt,dni);
    }

    public static void retirarEfectivo() {

    }

    public static void ingresarEfectivo() {

    }

    public static void listarTransacciones() {

    }
}
