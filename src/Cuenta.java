public class Cuenta {

    private int identificacion;

    private int codigo;

    private int saldo;

    public Cuenta(){

    }

    public Cuenta(int identificacion, int codigo, int saldo) {
        this.identificacion = identificacion;
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nCuenta{" +
                "identificacion='" + identificacion + '\'' +
                ", codigo=" + codigo +
                ", saldo=" + saldo +
                '}';
    }
}
