package Hospital;

import java.time.LocalDate;

public class Trabajador extends Persona{
    private LocalDate fechaIncorporación;
    private Area areaSanitaria;
    private String cargo;
    private double salario;

    public Trabajador(String dni, String nombre, String direccion, int edad, LocalDate fechaIncorporación, Area areaSanitaria, String cargo, double salario) {
        super(dni, nombre, direccion, edad);
        this.fechaIncorporación = fechaIncorporación;
        this.areaSanitaria = areaSanitaria;
        this.cargo = cargo;
        this.salario = salario;
    }

    public LocalDate getFechaIncorporación() {
        return fechaIncorporación;
    }

    public void setFechaIncorporación(LocalDate fechaIncorporación) {
        this.fechaIncorporación = fechaIncorporación;
    }

    public Area getAreaSanitaria() {
        return areaSanitaria;
    }

    public void setAreaSanitaria(Area areaSanitaria) {
        this.areaSanitaria = areaSanitaria;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "fechaIncorporación=" + fechaIncorporación +
                ", areaSanitaria='" + areaSanitaria + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
