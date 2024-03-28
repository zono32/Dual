package RepasoExamen2Eva.Empleados;

import RepasoExamen2Eva.Products.Producto;

import java.util.HashMap;

public class Comercial {
    private String nombre, apellidos, zona;
    private int  edad;
    private HashMap<Integer,Producto> registro = new HashMap<>();


    public Comercial(String nombre, String apellidos, int edad, String zona, HashMap registro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.zona = zona;
        this.edad = edad;
        this.registro = registro;

    }

    public Comercial(){
        this.nombre ="";
        this.apellidos = "";
        this.zona = "";
        this.edad = 0;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", zona='" + zona + '\'' +
                ", edad=" + edad +
                '}';
    }
}
