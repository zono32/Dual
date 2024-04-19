package Clinica;

import java.time.LocalDate;
import java.time.Period;

public class Mascota implements Coste{
    private String nombre;
    private String especie;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;

    public Mascota(String nombre, String especie, LocalDate fechaNacimiento, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }

    @Override
    public double calcularCoste() {

        double coste = 0;
        LocalDate ahora = LocalDate.now();
        int anios = Period.between(this.fechaRegistro, ahora).getYears();

        coste = 150*anios;
        return coste;
    }
}
