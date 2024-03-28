package RepasoExamen2Eva.Products;

public abstract class Producto {
    private double precio;
    private String nombre;

    public Producto(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }
    public  Producto(){
        this.precio = 0;
        this.nombre = "";
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
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
        return "Producto{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}