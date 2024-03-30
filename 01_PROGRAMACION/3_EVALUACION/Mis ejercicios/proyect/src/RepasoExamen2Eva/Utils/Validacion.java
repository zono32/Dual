package RepasoExamen2Eva.Utils;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validacion {

    public static boolean validarPrecioPositivo(double precio){
       return (precio > 0);
    }

    public static boolean validarPrecioNumero(Object input) {
        return input instanceof Double;
    }


    public static boolean ValidarFecha (LocalDate fechaCaducidad){
        LocalDate fechaActual = LocalDate.now();
        return (fechaActual.isBefore(fechaCaducidad));
    }

    public static boolean ValidarFormatoFecha (LocalDate fechaCaducidad){
        Pattern p = Pattern.compile()

    }

}
