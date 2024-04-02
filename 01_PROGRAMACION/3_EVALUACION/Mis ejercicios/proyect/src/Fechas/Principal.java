package Fechas;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Dime una fecha con el siguente formato dd-MM-yyy");
        String fecha = sc.next();

        System.out.println(validarFecha(fecha));

    }
    public static String validarFecha(String fecha){
        Scanner sc =new Scanner(System.in);
        do{

            try{
                Pattern pat = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$");
                Matcher mat = pat.matcher(fecha);

                if(!mat.matches()){
                    throw new Excep(Excep.FECHA_MAL);
                }
                return fecha;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Por favor introduzca una fecha con el formato correcto");
                fecha = sc.next();
            }
        }
        while (true);

    }

}
