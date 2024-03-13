package ZZ_EXAMEN;

public class Comercial {

    private String nombre;
    private String apellidos;
    private int edad;
    private String zonaAsignada;

    public Comercial(String nombre, String apellidos, int edad, String zonaAsignada) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.zonaAsignada = zonaAsignada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getZonaAsignada() {
        return zonaAsignada;
    }

    public void setZonaAsignada(String zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }

    @Override
    public String toString() {
        return "Comerciales{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", zonaAsignada='" + zonaAsignada + '\'' +
                '}';
    }
}
