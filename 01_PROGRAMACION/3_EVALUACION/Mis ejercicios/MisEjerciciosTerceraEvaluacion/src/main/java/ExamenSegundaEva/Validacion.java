package ExamenSegundaEva;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

    public static double validarPrecio( double precio){
        Scanner sc = new Scanner(System.in);

        do {
            try {
                Pattern pat = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
                Matcher mat = pat.matcher(String.valueOf(precio));

                if(!mat.matches()){
                    throw new Excep(Excep.NUMERO_NO_VALIDO);
                }
                return  precio;

            }catch (Excep e){
                e.getMessage();
                System.out.printf("El precio es incorrecto");
                precio = sc.nextDouble();
            }

        }
        while (true);
    }
    public static String opcionComestibleBazar( String opcion){
        Scanner sc = new Scanner(System.in);

        do {
            try {
                if(opcion.equalsIgnoreCase("B") || (opcion.equalsIgnoreCase("C")) ){
                    throw new Excep(Excep.OPCION_NO_VALIDA);
                }
                return  opcion;

            }catch (Excep e){
                e.getMessage();
                System.out.printf("La opción no es correcta");
                opcion = sc.next();
            }

        }
        while (true);


    }
}
