package RepasoExamen2Eva.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

    public static boolean validarPrecioPositivo(double precio){
       return (precio > 0);
    }

    public static boolean validarPrecioNumero(double precio) {
        return true;
    }
    public static boolean ValidarFecha (LocalDate fechaCaducidad){
        LocalDate fechaActual = LocalDate.now();
        return (fechaActual.isBefore(fechaCaducidad));
    }

    public static boolean ValidarFormatoFecha (LocalDate fechaCaducidad){
        String caducidad = fechaCaducidad.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$");
        Matcher mat = p.matcher(caducidad);
        return mat.matches();
    }

}
