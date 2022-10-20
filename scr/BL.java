import java.time.LocalDate;
import java.util.ArrayList;

public class BL {

    private final DL data = new DL();

    public BL() {
    }

    public void ingresarCliente(String nombre, int identificacion, int anno, int mes, int dia, String dirrecion) {
        LocalDate fechaNacimiento = LocalDate.of(anno, mes, dia);
        Cliente c = new Cliente(nombre, identificacion, fechaNacimiento, dirrecion);
        data.almacenarCliente(c);
    }

    public void crearCuenta(int identificacion, int codigo, int saldo) {
        Cuenta p = new Cuenta(identificacion, codigo, saldo);
        data.almacenarCuenta(p);
    }

    public void depositoCuenta(int identificacion, int saldo) {
        for (int i = 0; i < listarCuenta().size(); i++) {
            if (listarCuenta().get(i).getIdentificacion() == identificacion) {
                int saldoActual = listarCuenta().get(i).getSaldo();
                data.getCuenta().get(i).setSaldo(saldoActual + saldo);
            }
        }
    }

    public void retiroCuenta(int identificacion, int saldo) {
        for (int i = 0; i < listarCuenta().size(); i++) {
            if (listarCuenta().get(i).getIdentificacion() == identificacion) {
                int saldoActual = listarCuenta().get(i).getSaldo();
                data.getCuenta().get(i).setSaldo(saldoActual - saldo);
            }
        }
    }

    public int validacionPersona(int identificacion) {
        return data.validarCliente(identificacion);
    }

    public int validacionCodigo(int identificacion) {
        return data.validarCodigo(identificacion);
    }


    public ArrayList<String> listarCliente() {
        return data.getCliente();
    }

    public ArrayList<Cuenta> listarCuenta() {
        return data.getCuenta();
    }

    public ArrayList<String> listarCuentaCliente(int identificacion) {
        return data.getTarjetasCliente(identificacion);
    }

    public int modificarSaldo(int saldo) {
        int validacion = 0;
        if (saldo >= 50000) {
            validacion = 1;
        }
        return validacion;
    }

    public int modificarCodigo(int codigo) {
        int validacion = 0;
        if (codigo > 999999 && codigo <= 9999999) {
            validacion = 1;
        }
        return validacion;
    }

    public int verificarDeposito(int saldo) {
        int validacion = 0;
        if (saldo > 0) {
            validacion = 1;
        }
        return validacion;
    }

    public int verificarRetiro(int saldo) {
        int validacion = 0;
        for (int i = 0; i < listarCuenta().size(); i++) {
            if (listarCuenta().get(i).getSaldo() < saldo) {
                validacion = 1;
                break;
            }
            if (saldo <= 0) {
                validacion = 2;
                break;
            }
        }
        return validacion;
    }


}
