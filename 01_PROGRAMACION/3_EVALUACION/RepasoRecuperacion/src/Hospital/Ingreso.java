package Hospital;

import java.time.LocalDate;

public class Ingreso {

    private LocalDate ingreso;
    private LocalDate salida;
    private Area area;

    public Ingreso(LocalDate ingreso, LocalDate salida, Area area) {
        this.ingreso = ingreso;
        this.salida = salida;
        this.area = area;
    }

    public LocalDate getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalDate ingreso) {
        this.ingreso = ingreso;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Ingreso{" +
                "ingreso=" + ingreso +
                ", salida=" + salida +
                ", area=" + area +
                '}';
    }
}
