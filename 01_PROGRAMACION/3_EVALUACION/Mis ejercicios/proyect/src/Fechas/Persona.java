package Fechas;

import java.time.LocalDate;

public class Persona {
    private LocalDate cumpleaños;

    public Persona(LocalDate cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public LocalDate getCumpleaños() {
        return cumpleaños;
    }

    public void setCumpleaños(LocalDate cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "cumpleaños=" + cumpleaños +
                '}';
    }
}
