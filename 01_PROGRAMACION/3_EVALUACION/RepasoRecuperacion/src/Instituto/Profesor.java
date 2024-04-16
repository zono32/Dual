package Instituto;

import java.time.LocalDate;
import java.time.Period;

public class Profesor extends Miembro{

    private String tipoJornada;
    private double sueldo;
    private String  especialidad;

    public Profesor(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion, String tipoJornada, double sueldo, String especialidad) {
        super(dni, nombre, edad, direccion, fechaIncorporacion);
        this.tipoJornada = tipoJornada;
        this.sueldo = sueldo;
        this.especialidad = especialidad;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "tipoJornada='" + tipoJornada + '\'' +
                ", sueldo=" + sueldo +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }

    public void aplicarBonificacion(){

        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaActual, getFechaIncorporacion());
        int antiguedad = periodo.getYears();

        if(antiguedad > 3){
            this.setSueldo(sueldo * 1.15) ;
        }




    }
}
