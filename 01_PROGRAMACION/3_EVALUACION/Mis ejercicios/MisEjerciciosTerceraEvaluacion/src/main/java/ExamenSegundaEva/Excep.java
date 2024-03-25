package ExamenSegundaEva;

import java.security.PublicKey;

public class Excep extends Exception{

    static final int NUMERO_NO_VALIDO = 1;
    static final int OPCION_NO_VALIDA = 3;

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
            case 3:
                fallo = "ERROR: No estas introduciendo una opción válida";
            default:
                fallo = "ERROR DESCONOCIDO";
                break;
            }
    }

    public String getMessage(){
        return fallo;
    }

}
