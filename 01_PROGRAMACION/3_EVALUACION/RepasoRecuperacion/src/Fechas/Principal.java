package Fechas;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);

        System.out.println("dime una fecha");
        String fechaRecibida = cs.next();
        LocalDate ahora = LocalDate.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fr = LocalDate.parse(fechaRecibida, dtf);


        if(fr.isBefore(ahora)){
            System.out.println("la fecha es: " + fr );
        }


    }
}
