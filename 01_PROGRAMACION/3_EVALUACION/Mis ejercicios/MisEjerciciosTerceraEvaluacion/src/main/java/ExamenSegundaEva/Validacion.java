package ExamenSegundaEva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

    public static double validarPrecio( double precio){
        Scanner sc = new Scanner(System.in);

        do {
            try {
                if(precio < 0){
                    throw new Excep(Excep.NUMERO_NO_VALIDO);
                }
                if(String.valueOf(precio).contains("."))

             return  precio;

            }catch (Excep e){
                System.out.println(e.getMessage());
                System.out.println("Por favor introduzca un número correcto");
                precio = sc.nextDouble();
            }
        }
        while (true);
    }

    public static String validarNombre( String nombre){
        Scanner sc = new Scanner(System.in);

        do {
            try {
                Pattern pat = Pattern.compile("[a-zA-z]{1,20}");
                Matcher mat = pat.matcher(nombre);

                if(!mat.matches()){
                    throw new Excep(Excep.NOMBRE_NO_VALIDO);
                }
                return  nombre;

            }catch (Excep e){
                System.out.println(e.getMessage());;
                System.out.printf("Por favor introduzca un nombre correcto");
                nombre = sc.next();
            }

        }
        while (true);
    }
    public static String opcionComestibleBazar( String opcion){
        Scanner sc = new Scanner(System.in);

        do {
            try {
                Pattern pat = Pattern.compile("[b-cB-C]");
                Matcher mat = pat.matcher(opcion);

                if(!mat.matches()){
                    throw new Excep(Excep.OPCION_NO_VALIDA);
                }
                return  opcion;

            }catch (Excep e){
                System.out.println(e.getMessage());;
                System.out.println("Por favor introduzca una opción correcta (Comestible C /Bazar B)");
                opcion = sc.next();
            }
        }
        while (true);
    }
    public static String caducidad( String fecha){
        Scanner sc = new Scanner(System.in);
        Calendar fechaActual = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        /*
        int  dateYear = fechaActual.get(fechaActual.YEAR);
        int  dateMonth = fechaActual.get(fechaActual.MONTH);
        int  dateDay = fechaActual.get(fechaActual.DAY);
        */
        do{
            try{
                Date caduco = sdf.parse(fecha);

                if(caduco.after(new Date())){
                    throw new Excep(Excep.PRODUCTO_CADUCADO);
                }
                return fecha;
            }catch (Excep | ParseException e){
                e.getMessage();
                System.out.println("Por favor inserte otro producto este está caducado");
                fecha = sc.next();
            }
        }while (true);
    }


}
