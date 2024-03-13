package ZZ_EXAMEN;

public class Producto2 {
    private double precio;
    private String nombre;

    public Producto2(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
