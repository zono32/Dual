package Alamacen;

import java.util.HashMap;

public class Comercial {

   private String nombre;
   private String apellidos;
   private int edad;
   private String zona;
   private HashMap<Integer, Producto> registro;

    public Comercial(String nombre, String apellidos, int edad, String zona, HashMap<Integer, Producto> registro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.zona = zona;
        this.edad = edad;
        this.registro = registro;
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

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public HashMap<Integer, Producto> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<Integer, Producto> registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", zona='" + zona + '\'' +
                ", registro=" + registro +
                '}';
    }
}