import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.util.ArrayList;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    static BL logica = new BL();

    public static void main(String[] args) throws IOException {

        int opcion = -1;

        do {
            mostrarMenu();
            opcion = seleccionarOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);

    }

    public static void ingresarCliente() throws IOException {

        int dia, mes, anno, identificacion;

        String nombre, dirrecion;

        out.println("\nDigite el nombre del cliente: ");
        nombre = in.readLine();
        out.println("Digite la identificacion del cliente: ");
        identificacion = Integer.parseInt(in.readLine());
        out.println("Digite la dirrecion del cliente: ");
        dirrecion = in.readLine();
        out.println("Digite el dia del nacimiento del cliente: ");
        dia = Integer.parseInt(in.readLine());
        out.println("Digite el mes del nacimiento del cliente: ");
        mes = Integer.parseInt(in.readLine());
        out.println("Digite el a;o del nacimiento del cliente: ");
        anno = Integer.parseInt(in.readLine());
        if (!(logica.validacionPersona(identificacion))) {
            logica.ingresarCliente(nombre, identificacion, anno, mes, dia, dirrecion);

        }
        if (logica.validacionPersona(identificacion)) {
            System.out.println("ya existe ese usuario");
        }
    }

    public static void crearCuenta() throws IOException {
        int codigo, saldo, identificacion;
        out.println("\nDigite la identificacion del cliente: ");
        identificacion = Integer.parseInt(in.readLine());
        out.println("Digite los 7 numeros de la cuenta: ");
        codigo = Integer.parseInt(in.readLine());
        out.println("Deposito de 50 mil colones obligatorio: ");
        saldo = Integer.parseInt(in.readLine());
        logica.crearCuenta(identificacion, codigo, saldo);
    }

    static int seleccionarOpcion() throws IOException {

        out.print("\nDigite la opcion que desea: ");
        return Integer.parseInt(in.readLine());

    }

    static void mostrarMenu() {
        out.println("\nMENÚ PRINCIPAL");
        out.println("1.Registrar clientes.");
        out.println("2.Listar clientes.");
        out.println("3.Crear cuentas.");
        out.println("4.Listar cuentas.");
        out.println("5.Realizar deposito.");
        out.println("6.Realizar retiro.");
        out.println("7.Mostrar saldo de cuenta.");
        out.println("0.Salir del programa");
    }

    public static void procesarOpcion(int pOpcion) throws IOException {
        switch (pOpcion) {
            case 1:
                ingresarCliente();
                break;
            case 2:
                listarCliente();
                break;
            case 3:
                crearCuenta();
                break;
            case 4:
                listarCuenta();
                break;
            case 5:
                realizarDeposito();
                break;
            case 6:
                realizarRetiro();
                break;
            case 7:
                mostrarSaldo();
                break;
            case 0:
                out.println("\nGracias por usar el programa");
                break;
            default:
                out.println("\nOpcion invalida");
                break;
        }
    }


    public static void listarCliente() {

        ArrayList<String> Cliente = logica.listarCliente();

        for (int i = 0; i < Cliente.size(); i++) {
            System.out.println(Cliente.get(i));
        }

        Cliente = null;
    }

    public static void listarCuenta() {

        ArrayList<Cuenta> Cuenta = logica.listarCuenta();

        for (int i = 0; i < Cuenta.size(); i++) {
            out.println(Cuenta.get(i));
        }

        Cuenta = null;

    }

    public static void realizarDeposito() throws IOException {

        int identificacion;

        int saldo;

        out.println("\nDigite la identificacion del cliente: ");
        identificacion = Integer.parseInt(in.readLine());
        System.out.println("Digite el deposito que desea realizar: ");
        saldo = Integer.parseInt(in.readLine());

        logica.depositoCuenta(identificacion, saldo);

    }

    public static void realizarRetiro() throws IOException {
        int saldo, identificacion;

        out.println("\nDigite la identificacion del cliente: ");
        identificacion = Integer.parseInt(in.readLine());
        System.out.println("Digite el retiro que desea realizar: ");
        saldo = Integer.parseInt(in.readLine());

        logica.retiroCuenta(identificacion, saldo);
    }

    public static void mostrarSaldo() throws IOException {

        int identificacion;
        out.println("\nDigite la identificacion del cliente para mostrar la cuenta: ");
        identificacion = Integer.parseInt(in.readLine());

        ArrayList<String> Cuenta = logica.listarCuentaCliente(identificacion);


        for (int i = 0; i < Cuenta.size(); i++) {
            System.out.println(Cuenta.get(i));
        }
        Cuenta = null;
    }
}
