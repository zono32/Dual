package ExamenSegundaEva;

import java.util.Date;

public class Comestibles extends Producto{
    private Date fechaCaducidad;

    public Comestibles(double precio, String nombre, String categoria, Date fechaCaducidad) {
        super(precio, nombre, categoria);
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Comestibles{" +
                "fechaCaducidad=" + fechaCaducidad +
                '}';
    }
}
