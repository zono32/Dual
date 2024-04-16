package Instituto;

import java.time.LocalDate;
import java.time.Period;

public class Alumno extends Miembro {

    private String ciclo;
    private double mediaNotas;
    private double precioMatricula;

    public Alumno(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion, String ciclo, double mediaNotas, double precioMatricula) {
        super(dni, nombre, edad, direccion, fechaIncorporacion);
        this.ciclo = ciclo;
        this.mediaNotas = mediaNotas;
        this.precioMatricula = precioMatricula;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public double getPrecioMatricula() {
        return precioMatricula;
    }

    public void setPrecioMatricula(double precioMatricula) {
        this.precioMatricula = precioMatricula;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "ciclo='" + ciclo + '\'' +
                ", mediaNotas=" + mediaNotas +
                ", precioMatricula=" + precioMatricula +
                '}';
    }

    public void aplicarBonificacion(){

        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaActual, getFechaIncorporacion());
        int antiguedad = periodo.getYears();

        if ( antiguedad > 2){
            this.setPrecioMatricula(precioMatricula/1.1);
        }
    }


}


