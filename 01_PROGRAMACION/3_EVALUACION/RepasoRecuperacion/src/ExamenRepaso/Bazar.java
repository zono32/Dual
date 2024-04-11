package ExamenRepaso;

public class Bazar extends Producto{

    private String tipo;

    public Bazar(String nombre, Double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }
    public Bazar() {
        super("", 0.0);
        this.tipo = "";
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
