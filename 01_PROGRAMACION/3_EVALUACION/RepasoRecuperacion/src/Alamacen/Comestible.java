package Alamacen;

import java.time.LocalDate;

public class Comestible extends Producto{

    private LocalDate fechaCaducidad;

    public Comestible(String nombre, double precio, LocalDate fechaCaducidad) {
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
        return "Comestible{" +
                "fechaCaducidad=" + fechaCaducidad +
                "} " + super.toString();
    }
}
