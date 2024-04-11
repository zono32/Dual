package ExamenRepaso;

import java.util.HashMap;

public class Comercial {

    String nombre;
    String apellidos;
    int edad;
    int zona;
    HashMap< Integer, Producto > ventas;

    public Comercial(String nombre, String apellidos, int edad, int zona, HashMap<Integer, Producto> ventas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.zona = zona;
        this.ventas = ventas;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public HashMap<Integer, Producto> getVentas() {
        return ventas;
    }

    public void setVentas(HashMap<Integer, Producto> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", zona=" + zona +
                ", ventas=" + ventas +
                '}';
    }
}
