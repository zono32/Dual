package Clinica;

import java.time.LocalDate;
import java.util.HashMap;

public class Veterinario extends Persona implements Coste{
    private double sueldoMensual;
    private String especialidad;
    private LocalDate fechaContratacion;
    private HashMap<Integer, Mascota>registro;

    public Veterinario(String dni, String nombre, int edad, String direccion, double sueldoMensual, String especialidad,
                       LocalDate fechaContratacion, HashMap<Integer, Mascota> registro) {
        super(dni, nombre, edad, direccion);
        this.sueldoMensual = sueldoMensual;
        this.especialidad = especialidad;
        this.fechaContratacion = fechaContratacion;
        this.registro = registro;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public HashMap<Integer, Mascota> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<Integer, Mascota> registro) {
        this.registro = registro;
    }




    @Override
    public String toString() {
        return "Veterinario{" +
                "sueldoMensual=" + sueldoMensual +
                ", especialidad='" + especialidad + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", registro=" + registro +
                "} " + super.toString();
    }


    @Override
    public double calcularCoste() {
        double coste = 0;

        if (super.getEdad()> 40){
            coste = (this.sueldoMensual*14)*1.10;
        }else{
            coste = this.sueldoMensual*14;
        }
        return coste;
    }
}
