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
        int id = logica.validacionPersona(identificacion);
        out.println("Digite la dirrecion del cliente: ");
        dirrecion = in.readLine();
        out.println("Digite el dia del nacimiento del cliente: ");
        dia = Integer.parseInt(in.readLine());
        out.println("Digite el mes del nacimiento del cliente: ");
        mes = Integer.parseInt(in.readLine());
        out.println("Digite el a;o del nacimiento del cliente: ");
        anno = Integer.parseInt(in.readLine());
        if (id == 0) {
            System.out.println("El usuario ya existe");
        } else {
            logica.ingresarCliente(nombre, identificacion, anno, mes, dia, dirrecion);
            System.out.println("Usuario registrado");
        }
    }

    public static void crearCuenta() throws IOException {
        int codigo, saldo, identificacion;
        out.println("\nDigite la identificacion del cliente: ");
        identificacion = Integer.parseInt(in.readLine());
        out.println("Digite los 7 numeros de la cuenta: ");
        codigo = Integer.parseInt(in.readLine());
        int id = logica.validacionCodigo(codigo);
        int cod = logica.modificarCodigo(codigo);
        out.println("Deposito de 50 mil colones obligatorio: ");
        saldo = Integer.parseInt(in.readLine());
        int sald = logica.modificarSaldo(saldo);
        if (id == 1) {
            if (cod == 1) {
                if (sald == 1) {
                    logica.crearCuenta(identificacion, codigo, saldo);
                    System.out.println("Cuenta Creada");
                }
            }
        } else {
            System.out.println("picha mama malparido me debe un 8cho");
        }
        if (cod == 0) {
            out.println("son 7 numeros de la cuenta");
        }
        if (sald == 0) {
            out.println("debe ser mayor a 50000");
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
//        PERDIR CODIGO EN VES DE ESTO REVISAR TODOS LOS METODOS RELACIONADOS MAMADOR
        identificacion = Integer.parseInt(in.readLine());
        System.out.println("Digite el deposito que desea realizar: ");
        saldo = Integer.parseInt(in.readLine());
        int sald = logica.verificarDeposito(saldo);
        if (sald == 0) {
            System.out.println("tiene que ser mayor que 0");
        }
        if (sald == 1) {
            logica.depositoCuenta(identificacion, saldo);
            System.out.println("deposito exitoso");
        }
    }

    public static void realizarRetiro() throws IOException {
        int saldo, identificacion;
        out.println("\nDigite la identificacion del cliente: ");
        //        PERDIR CODIGO EN VES DE ESTO REVISAR TODOS LOS METODOS RELACIONADOS MAMADOR
        identificacion = Integer.parseInt(in.readLine());
        System.out.println("Digite el retiro que desea realizar: ");
        saldo = Integer.parseInt(in.readLine());
        int sald = logica.verificarRetiro(saldo);
        if (sald == 0) {
            logica.retiroCuenta(identificacion, saldo);
            System.out.println("Retiro exitoso");
        }
        if (sald == 2) {
            System.out.println("debe de ser mayor que 0");
        }
        if (sald == 1) {
            System.out.println("no puede hacer retiros mayor de lo que hay en la cuenta");
        }
    }


    public static void mostrarSaldo() throws IOException {
        int identificacion;
        out.println("\nDigite la identificacion del cliente para mostrar la cuenta: ");
        identificacion = Integer.parseInt(in.readLine());
        ArrayList<String> Cuenta = logica.listarCuentaCliente(identificacion);
        for (int i = 0; i < Cuenta.size(); i++) {
            System.out.println();
            System.out.println(Cuenta.get(i));
        }
        Cuenta = null;
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
}