/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZZ_EXAMEN;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author nccasares
 */
public class Comestible extends Producto {
    private LocalDate fechaCaducidad;

    public Comestible(LocalDate fechaCaducidad, String nombre, double precio) {
        super(nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return super.toString() + " Comestible{" + "fechaCaducidad=" + fechaCaducidad + '}';
    }
}
