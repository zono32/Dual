package Fechas;

public class Excep extends Exception{
    static final int FECHA_MAL = 1;

    private String fallo;

    public Excep(){}

    public Excep(String s){
        super(s);
    }
    public Excep(int f) {
    switch (f){
        case 1:
            fallo = "Error: el formato intoducido no es correcto";
            break;
        default:
            fallo = "Error desconocido";
             break;
        }
    }

    public String getMessage(){
        return fallo;
    }
}
