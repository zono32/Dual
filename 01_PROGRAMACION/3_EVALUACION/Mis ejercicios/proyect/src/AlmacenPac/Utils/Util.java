package AlmacenPac.Utils;

import java.time.LocalDate;
import java.util.Scanner;

public class Util {

    public static boolean validarPrecio(double precio){
        return precio > 0 ? true : false ;
    }

    public static boolean validarfecha(LocalDate fecha){
        return true;
    }
}
