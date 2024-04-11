package ExamenRepaso;

import java.util.HashMap;

public class Comercial {
    String nombre;
    String apellidos;
    int edad;
    String zona;
    HashMap< Integer, Producto> producto ;

    public Comercial(String nombre, String apellidos, int edad, String zona, HashMap<Integer, Producto> producto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.zona = zona;
        this.producto = producto;
    }
    public Comercial() {
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
        this.zona = "";
        this.producto = null;
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

    public HashMap<Integer, Producto> getProducto() {
        return producto;
    }

    public void setProducto(HashMap<Integer, Producto> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", zona=" + zona +
                ", producto=" + producto +
                '}';
    }
}


