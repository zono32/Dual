package AlmacenPac.Utils;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static boolean validarPrecio(double precio){
        return precio > 0 ? true : false ;
    }

    public static boolean validarfecha(String fecha){

        boolean fechaValida = false;

        Pattern pat = Pattern.compile("^([0][1-9]|[12][0-9]|3[01])(\\/|-)([0][1-9]|[1][0-2])\\2(\\d{4})(\\s)([0-1][1-9]|[2][0-3])(:)([0-5][0-9])$");
        Matcher mat = pat.matcher(fecha);
        if(mat.matches()){
            fechaValida= true;
        }
        return fechaValida;
    }





}
