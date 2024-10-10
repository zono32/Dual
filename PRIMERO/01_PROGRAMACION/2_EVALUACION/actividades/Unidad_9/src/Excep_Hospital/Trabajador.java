package Excep_Hospital;

public class Trabajador extends Persona{
    
    private String fechaIncorporacion, areaSanitaria, cargo;
    private double salario;


    public Trabajador(String dni, String nombre, String direccion, int edad, String fechaIncorporacion, String areaSanitaria, String cargo, double salario) {
        super(dni, nombre, direccion, edad);
        this.fechaIncorporacion = fechaIncorporacion;
        this.areaSanitaria = areaSanitaria;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(String fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public String getAreaSanitaria() {
        return areaSanitaria;
    }

    public void setAreaSanitaria(String areaSanitaria) {
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
                "fechaIncorporacion='" + fechaIncorporacion + '\'' +
                ", areaSanitaria='" + areaSanitaria + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
