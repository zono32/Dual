package ZZ_EXAMEN;

public class Excep  extends Exception{

    static final int NUMERO_NEGATIVO = 1;
    static final int PRODUCTO_CADUCADO = 1;


    private String fallo;

    public  Excep(){}

    public Excep(String s){
        super(s);
    }
    public Excep(int f){
        switch (f){
            case 1:
                fallo = "Error: El número introducido es negativo";
                break;
            case 2:
                fallo = "Error: El producto ya está caducado";
                break;
            default:
                fallo = "ERROR: error indeterminado";
            break;
        }
    }

    public String getMessage(){
        return fallo;
    }


}
