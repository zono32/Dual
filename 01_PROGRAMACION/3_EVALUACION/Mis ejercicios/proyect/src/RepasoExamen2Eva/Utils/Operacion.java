package RepasoExamen2Eva.Utils;

import RepasoExamen2Eva.Exceptions.ExcepFecha;
import RepasoExamen2Eva.Exceptions.ExcepNum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static RepasoExamen2Eva.Utils.Validacion.validarPrecioNumero;
import static RepasoExamen2Eva.Utils.Validacion.validarPrecioPositivo;
import static RepasoExamen2Eva.Utils.Validacion.ValidarFecha;
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

    public static LocalDate devuelveFechaCorrecta(LocalDate fecha){
        Scanner sc = new Scanner(System.in);
        do {
            try{
                if(!ValidarFecha(fecha)){
                    throw new ExcepFecha(ExcepFecha.PRODUCTO_CADUCADO);
                }
                return fecha;
            }catch (ExcepFecha e){
                System.out.println(e.getMessage());
                System.out.printf("Desea introducir una nueva fecha? s/n");
                String resp = sc.next();
                if (resp.equalsIgnoreCase("s")){

                }else{
                    break;
                }

            }
        }while (true);
        return fecha;

    }
}
