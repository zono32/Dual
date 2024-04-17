package Alamacen;

import java.io.StringReader;
import java.util.HashMap;

public class Comercial {
    private String nombre, apellidos,zona;
    private int edad;

    private HashMap<Integer, Producto> ventas;

    public Comercial(String nombre, String apellidos, int edad, String zona, HashMap<Integer, Producto> ventas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.zona = zona;
        this.edad = edad;
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
                ", zona='" + zona + '\'' +
                ", edad=" + edad +
                ", ventas=" + ventas +
                '}';
    }
}
