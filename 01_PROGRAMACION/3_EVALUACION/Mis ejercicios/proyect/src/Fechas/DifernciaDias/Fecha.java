package Fechas.DifernciaDias;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Fecha {

    public static void main(String[] args) {
        String fechaInicio = "01-08-2023";
        String fechaFinal = "10-08-2023";
        String format = "dd-MM-yyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        try{
            Date fechaIni = simpleDateFormat.parse(fechaInicio);
            Date fechaFin = simpleDateFormat.parse(fechaFinal);

            long dif = fechaFin.getTime()-fechaIni.getTime();
            long dias = TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS);

            System.out.println("hay "+dias+" entre las fechas "+ fechaInicio + " / "+ fechaFinal);
        }catch (Exception e){

        }
    }
}
