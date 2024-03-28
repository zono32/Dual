package RepasoExamen2Eva.Exceptions;

import java.util.PrimitiveIterator;

public class ExcepNum extends Exception{
    static final int NUMERO_INVALIDO = 1;
    static final int NUMERO_NEGATIVO = 2;

    private String fallo;

    public ExcepNum(){

    }
    public ExcepNum(String s){
        super(s);
    }

    public ExcepNum(int f){
        switch (f){
            case 1 :
                fallo = "ERROR: por favor introduzca un número válido";
            break;
            case 2 :
                fallo = "ERROR: por favor introduzca un número positivo";
                break;
            default:
                fallo= "ERROR DESCONOCIDO";
                break;
        }
    }
    public String getMessage(){
        return fallo;
    }
}
