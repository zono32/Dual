package AlmacenPac.Excepciones;

public class ExcepcionFecha extends Exception {

    private String fallo;

    public ExcepcionFecha(){
        this.fallo = "Error: El producto ya está caducado";
    }

    public ExcepcionFecha(String s){
        super(s);
    }

    public String getMessage(){
        return fallo;
    }
}


