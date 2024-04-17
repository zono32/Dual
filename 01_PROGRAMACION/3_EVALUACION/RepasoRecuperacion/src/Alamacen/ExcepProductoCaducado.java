package Alamacen;

public class ExcepProductoCaducado extends Exception{

    public ExcepProductoCaducado() {
    }

    public ExcepProductoCaducado(String message) {
        super(message);
    }
}
