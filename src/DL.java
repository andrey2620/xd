import java.util.ArrayList;

public class DL {

    public DL(){
    }

    private final ArrayList<Cliente> Cliente = new ArrayList<>();

    public void almacenarCliente(Cliente c) {Cliente.add(c);}

    public ArrayList<String> getCliente() {

        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < Cliente.size(); i++) {
            Cliente k = Cliente.get(i);
            data.add(k.toString());
        }

        return data;

    }

    private final ArrayList<Cuenta> Cuenta = new ArrayList<>();

    public void almacenarCuenta(Cuenta p) {Cuenta.add(p);}

    public ArrayList<String> getCuenta() {

        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < Cuenta.size(); i++) {
            Cuenta n = Cuenta.get(i);
            data.add(n.toString());
        }

        return data;

    }

}
