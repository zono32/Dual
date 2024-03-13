package ZZ_EXAMEN;

public class Comestible extends Producto2 {

    private String fechaDeCaducidad;

    public Comestible(double precio, String nombre, String fechaDeCaducidad) {
        super(precio, nombre);
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    public String getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public void setFechaDeCaducidad(String fechaDeCaducidad) {
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    @Override
    public String toString() {
        return "Comestibles{" +
                "fechaDeCaducidad='" + fechaDeCaducidad + '\'' +
                '}';
    }
}
