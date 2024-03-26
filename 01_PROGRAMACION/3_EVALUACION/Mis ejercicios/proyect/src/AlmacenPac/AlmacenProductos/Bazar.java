package AlmacenPac.AlmacenProductos;

public class Bazar extends Producto {
    private String tipo;

    public Bazar(double precio, String nombre, String tipo) {
        super(precio, nombre);
        this.tipo = tipo;
    }
    public Bazar(){
        super();
        this.tipo="";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bazar{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
