package Fechas;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Localdate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);

        // Si necesitas volver a tener un objeto LocalDate a partir de la fecha formateada
        LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
        System.out.println(parsedDate);
    }
}
