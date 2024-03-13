package Excep_Hospital;

public class Paciente extends Persona{

    private String fechaIngreso, patologia, areasIngresos;

    public Paciente(String dni, String nombre, String direccion, int edad, String fechaIngreso, String patologia, String areasIngresos) {
        super(dni, nombre, direccion, edad);
        this.fechaIngreso = fechaIngreso;
        this.patologia = patologia;
        this.areasIngresos = areasIngresos;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getAreasIngresos() {
        return areasIngresos;
    }

    public void setAreasIngresos(String areasIngresos) {
        this.areasIngresos = areasIngresos;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "fechaIngreso='" + fechaIngreso + '\'' +
                ", patologia='" + patologia + '\'' +
                ", areasIngresos='" + areasIngresos + '\'' +
                '}';
    }
}
