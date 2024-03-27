package AlmacenPac.Utils;

import AlmacenPac.Excepciones.ExceepcionNumeroNegativo;
import AlmacenPac.Excepciones.ExcepcionFecha;
import Fechas.Excep;
import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static double validarPrecio(double precio){
        Scanner sc =new Scanner(System.in);

        do{
            try{

                if (precio < 0){
                    throw new ExceepcionNumeroNegativo();
                }
                return precio;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("por favor introduzca un preso correcto");
                precio = sc.nextDouble();
            }
        }while (true);

    }

    public static String validarFecha(String fecha){
        Scanner sc =new Scanner(System.in);
        do{

            try{
                Pattern pat = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
                Matcher mat = pat.matcher(fecha);

                if(!mat.matches()){
                    throw new ExcepcionFecha();
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
