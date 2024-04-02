package ExamenSegundaEva;

import java.security.PublicKey;

public class Excep extends Exception{

    static final int NUMERO_NO_VALIDO = 1;
    static final int NOMBRE_NO_VALIDO = 2;
    static final int OPCION_NO_VALIDA = 3;
    static  final int PRODUCTO_CADUCADO = 4;

    private String fallo;

    public Excep(){};

    public Excep(String s){
        super(s);
    }
    public Excep(int f){

        switch (f){
            case 1:
                fallo = "Error: no estas introduciendo un precio válido";
                break;
            case 2:
                fallo = "Error: no estas introduciendo un nombre válido";
                break;
            case 3:
                fallo = "ERROR: No estas introduciendo una opción válida";
                break;
            case 4:
                fallo = "ERROR: El producto está caducado";
                break;
            default:
                fallo = "ERROR DESCONOCIDO";
                break;
            }
    }

    public String getMessage(){
        return fallo;
    }

}
