import java.util.ArrayList;

public class DL {

    private final ArrayList<Cuenta> Cuenta = new ArrayList<>();

    private final ArrayList<Cliente> Cliente = new ArrayList<>();

    public DL() {
    }

    public ArrayList<Cuenta> getCuenta() {
        return Cuenta;
    }

    public ArrayList<String> getCliente() {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < Cliente.size(); i++) {
            Cliente k = Cliente.get(i);
            data.add(k.toString());
        }
        return data;
    }

    public ArrayList<String> getTarjetasCliente(int identificacion) {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < Cuenta.size(); i++) {
            if (Cuenta.get(i).getIdentificacion() == identificacion) {
                if (Cuenta.get(i).getSaldo() < 1) {
                    System.out.println("Cuenta no tiene fondos");
                    break;
                }
                Cuenta t = Cuenta.get(i);
                data.add(t.toString());
            }
        }
        return data;
    }


    public boolean validarCliente(int identificacion) {
        boolean validacion = false;
        for (int i = 0; i < Cuenta.size(); i++) {
            if (Cuenta.get(i).getIdentificacion() == identificacion ) {
                validacion = true;
            }
        }
        return validacion;
    }

    public void almacenarCliente(Cliente c) {
        Cliente.add(c);
    }
    public void almacenarCuenta(Cuenta p) {
        Cuenta.add(p);
    }
}