package ZZ_EXAMEN;

public class Bazar extends Producto2 {

    private String tipo;

    public Bazar(double precio, String nombre, String tipo) {
        super(precio, nombre);
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
