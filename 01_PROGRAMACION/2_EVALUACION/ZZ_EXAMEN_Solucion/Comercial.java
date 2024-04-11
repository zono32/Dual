/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZZ_EXAMEN;

import java.util.HashMap;

/**
 *
 * @author nccasares
 */
public class Comercial {
    private String nombre;
    private String apellidos;
    private int edad;
    private String zona;
    private HashMap<Integer, Producto> ventas;

    public Comercial(String nombre, String apellidos, int edad, String zona, HashMap<Integer, Producto> ventas) {
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

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
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
        return "Comercial{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", zona=" + zona + ", ventas=" + ventas + '}';
    }
}
