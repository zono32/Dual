package ZZ_EXAMEN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validar {


    public static double validarPrecio (double precio){
        Scanner sc = new Scanner(System.in);
        do{
            try{
                if(precio<0){
                    throw new Excep(Excep.NUMERO_NEGATIVO);
                }
                return precio;
            }catch (Excep e){
                e.getMessage();
                    System.out.println("Por favor inserte un número válido");
                precio = sc.nextInt();
            }
        }while (true);

    }

    public static String productoCaducado(String caducidad){
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
                Date caduco = sdf.parse(caducidad);

                if(caduco.after(new Date())){
                    throw new Excep(Excep.PRODUCTO_CADUCADO);
                }
                return caducidad;
            }catch (Excep | ParseException e){
                e.getMessage();
                System.out.println("Por favor inserte otro producto este está caducado");
                caducidad = sc.nextLine();
            }
        }while (true);

    }

}
