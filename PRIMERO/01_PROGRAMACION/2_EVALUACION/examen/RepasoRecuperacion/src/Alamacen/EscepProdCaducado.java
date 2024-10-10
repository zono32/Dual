package Alamacen;

public class EscepProdCaducado extends Exception{

    public EscepProdCaducado() {
    }

    public EscepProdCaducado(String message) {
        super(message);
    }
}
