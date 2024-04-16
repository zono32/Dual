package Hospital;

import java.time.LocalDate;
import java.util.HashMap;

public class Paciente extends Persona {

    private LocalDate fechaIngreso;
    private String PatologiaActual;
    private HashMap<Integer,Ingreso>historial;

    public Paciente(String dni, String nombre, String direccion, int edad, LocalDate fechaIngreso, String patologiaActual, HashMap<Integer, Ingreso> historial) {
        super(dni, nombre, direccion, edad);
        this.fechaIngreso = fechaIngreso;
        PatologiaActual = patologiaActual;
        this.historial = historial;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPatologiaActual() {
        return PatologiaActual;
    }

    public void setPatologiaActual(String patologiaActual) {
        PatologiaActual = patologiaActual;
    }

    public HashMap<Integer, Ingreso> getHistorial() {
        return historial;
    }

    public void setHistorial(HashMap<Integer, Ingreso> historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "fechaIngreso=" + fechaIngreso +
                ", PatologiaActual='" + PatologiaActual + '\'' +
                ", historial=" + historial +
                '}';
    }
}
