package AlmacenPac.AlmacenProductos;

import java.time.LocalDate;

public class Comestible extends Producto {
    private LocalDate fechaCaducidad;

    public Comestible(double precio, String nombre, LocalDate fechaCaducidad) {
        super(precio, nombre);
        this.fechaCaducidad = fechaCaducidad;
    }
    public Comestible(){
        super();
        this.fechaCaducidad = LocalDate.now();
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
                '}';
    }
}
