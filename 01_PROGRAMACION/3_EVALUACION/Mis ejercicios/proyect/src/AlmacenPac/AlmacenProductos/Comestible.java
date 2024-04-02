package AlmacenPac.AlmacenProductos;

import java.time.LocalDate;

public class Comestible extends Producto {
    private String fechaCaducidad;

    public Comestible(double precio, String nombre, String fechaCaducidad) {
        super(precio, nombre);
        this.fechaCaducidad = fechaCaducidad;
    }
    public Comestible(){
        super();
        this.fechaCaducidad = "";
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Comestible{" +
                "fechaCaducidad=" + fechaCaducidad +
                '}';
    }
}
