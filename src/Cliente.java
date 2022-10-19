import java.time.LocalDate;
import java.time.Period;

public class Cliente {

    private String nombre;
    private String identificacion;
    private LocalDate FechaNacimiento;
    private int edad;
    private String direccion;

    public Cliente(){

    }

    public Cliente(String nombre, String identificacion, LocalDate fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.FechaNacimiento = fechaNacimiento;
        LocalDate fechaActual = LocalDate.now();
        this.edad = Period.between(fechaNacimiento, fechaActual).getYears();
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "\nCliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", FechaNacimiento=" + FechaNacimiento +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                '}';
    }

}

