package RepasoExamen2Eva.Utils;

import Fechas.DifernciaDias.Fecha;
import RepasoExamen2Eva.Exceptions.ExcepFecha;
import RepasoExamen2Eva.Exceptions.ExcepNum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static RepasoExamen2Eva.Utils.Validacion.*;

public class Operacion {

    public static double devuelvePrecioValidado(double precio){

        do {
            try {
                if (!validarPrecioPositivo(precio)) {
                    throw new ExcepNum(ExcepNum.NUMERO_NEGATIVO);
                }
                if (!validarPrecioNumero(precio)) {
                    throw new ExcepNum(ExcepNum.NUMERO_INVALIDO);
                }
                return precio;
            } catch (ExcepNum e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, ingresa un número válido:");
            }
        } while (true);
    }

    public static LocalDate devuelveFechaCorrecta(String fecha){
        Scanner sc = new Scanner(System.in);
        LocalDate hoy = LocalDate.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechanew = null;
        String hoyString = hoy.format(formato);

        do {
            try{
                fechanew = LocalDate.parse(fecha, formato);
                if(!ValidarFecha(fechanew)){
                    throw new ExcepFecha(ExcepFecha.PRODUCTO_CADUCADO);
                }
                if(!ValidarFormatoFecha(fechanew)){
                    throw new ExcepFecha(ExcepFecha.FECHA_FORMATO_INCORRECTO);
                }
                return fechanew;
            }catch (ExcepFecha e){
                System.out.println(e.getMessage());

                System.out.printf("Desea introducir una nueva fecha? s/n");
                String resp = sc.next();

                if (resp.equalsIgnoreCase("s")){
                    System.out.printf("por favor indique una fecha posterior a " + hoyString + "\nCon el formato dd-MM-yyyy");
                    fechanew = LocalDate.parse(sc.next(), formato);

                }else{
                    break;
                }

            }
        }while (true);
        return fechanew;

    }
}
