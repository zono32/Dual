package ExamenSegundaEva;

import java.util.Collection;

public class Comercial {
    private int edad;
    private String nombre, apellidos, zona;

    public Comercial(String nombre, String apellidos, int edad, String zona){//, Collection collection) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.zona = zona;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", zona='" + zona + '\'' +
                '}';
    }
}
