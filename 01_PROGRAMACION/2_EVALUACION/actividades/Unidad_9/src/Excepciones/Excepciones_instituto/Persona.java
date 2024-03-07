package Excepciones.Excepciones_instituto;

import java.time.LocalTime;
import java.util.Date;

public abstract class Persona {
    private String dni;
    private String nombre;
    private int edad;
    private String direccion;
    private Date fechaIncorporacion;

    public Persona(String dni, String nombre, int edad, String direccion, Date fechaIncorporacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.fechaIncorporacion = fechaIncorporacion;
    }
    public Persona(){
        this.dni = "00000000A";
        this.nombre = "nombre";
        this.edad = 0;
        this.direccion = "direccion";
        this.fechaIncorporacion = new Date();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {

        this.fechaIncorporacion = fechaIncorporacion;
    }
}
