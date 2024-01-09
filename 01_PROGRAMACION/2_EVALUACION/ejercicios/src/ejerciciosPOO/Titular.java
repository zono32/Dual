package ejerciciosPOO;
import java.time.LocalDate;
import java.util.Date;

public class Titular {
    private String nombre = "nombre";
    private LocalDate fechaNacimiento = LocalDate.parse("00/00/0000");
    private String dni = "00000000A";
    private String sexo = "Hombre";
    private String direccion = "direccion";

    public Titular(String nombre, LocalDate fechaNacimiento, String sexo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public Titular(String nombre, LocalDate fechaNacimiento, String dni, String sexo, String direccion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.sexo = sexo;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public boolean esMayorDeEdad(){

        return true;

    };
}
