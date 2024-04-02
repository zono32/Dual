package AlmacenPac.Excepciones;

import com.sun.jdi.PrimitiveValue;

public class ExceepcionNumeroNegativo extends Exception {
     private String fallo;

    public ExceepcionNumeroNegativo(){
        this.fallo = "Error: El número introducido es negativo";
    }

    public ExceepcionNumeroNegativo(String s){
        super(s);
    }

    public String getMessage(){
         return fallo;
     }
}
