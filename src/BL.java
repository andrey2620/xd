import java.time.LocalDate;
import java.util.ArrayList;

public class BL {

    private final DL data = new DL();

    public BL() {
    }

    public void ingresarCliente(String nombre, String identificacion, int anno, int mes, int dia, String dirrecion) {

        LocalDate fechaNacimiento = LocalDate.of(anno, mes, dia);
        Cliente c = new Cliente(nombre, identificacion, fechaNacimiento, dirrecion);
        data.almacenarCliente(c);

    }

    public ArrayList<String> listarCliente() {

        return data.getCliente();

    }

    public ArrayList<String> listarCuenta() {

        return data.getCuenta();

    }

    public void crearCuenta(String identificacion, int codigo, int saldo) {

        modificarCodigo(codigo);
        modificarSaldo(saldo);
        Cuenta p = new Cuenta(identificacion, codigo, saldo);
        data.almacenarCuenta(p);

    }

    public String modificarSaldo(int saldo){

        if (saldo != 50000){
            System.out.println("error");
            System.exit(1);
        }else if(saldo == 50000){
            System.out.println("Ta bien");
        }
        return null;

    }

    public void modificarCodigo(int codigo){

        if (codigo == 7){
            System.out.println("ta bien2222");
        }else{
            System.out.println("error2222");
            System.exit(1);
        }

    }

    public void depositoCuenta(String identificacion, int saldo){

        for (int i = 0; i < listarCuenta().size(); i++){
            if (listarCuenta().get(i).getIdentificacion() == identificacion){
                listarCuenta().get(i).setSaldo(saldo);
            }
        }

    }

    public void retiroCuenta(String identificacion, int saldo){

        for (int i = 0; i < listarCuenta().size(); i++){
            if (listarCuenta().get(i).getIdentificacion() == identificacion){
                listarCuenta().get(i).setSaldo(saldo);
            }
        }

    }

}
