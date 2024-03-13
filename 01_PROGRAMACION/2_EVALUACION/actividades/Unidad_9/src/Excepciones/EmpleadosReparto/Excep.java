package Excepciones.EmpleadosReparto;

import javax.swing.*;
import java.security.PublicKey;

public class Excep extends Exception {

static final int ERROR1 =1;



    private String fallo;

    public Excep (){}

    public Excep(String s) {
       super(s);
    }

    public Excep(int f){
        switch (f){
            case 1:
                fallo = "1";
                break;
            default:
                fallo = "2";
                break;
        }
    }
    public String getMessage(){
        return fallo;
    }
}

