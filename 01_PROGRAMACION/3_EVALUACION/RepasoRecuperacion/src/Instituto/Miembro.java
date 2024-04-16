package Instituto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public abstract class Miembro extends Persona{

    private LocalDate fechaIncorporacion;

    public Miembro(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion) {
        super(dni, nombre, edad, direccion);
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public abstract void aplicarBonificacion();

    @Override
    public String toString() {
        DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        return "Miembro{" +
                "fechaIncorporacion=" + dateformat.format(fechaIncorporacion);

    }
}
