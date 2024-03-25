package ExamenSegundaEva;

public class Bazar extends Producto{
    private String tipo;

    public Bazar(double precio, String nombre, String categoria, String tipo) {
        super(precio, nombre, categoria);
        this.tipo = tipo;
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
