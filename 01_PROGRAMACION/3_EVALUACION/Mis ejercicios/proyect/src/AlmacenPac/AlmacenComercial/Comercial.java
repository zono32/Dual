package AlmacenPac.AlmacenComercial;

import AlmacenPac.AlmacenComercial.Persona;

public class Comercial extends Persona {

    private String zona;

    public Comercial(String nombre, String apellidos, int edad, String zona) {
        super(nombre, apellidos, edad);
        this.zona = zona;
    }
    public Comercial(){
     super();
     this.zona="1";
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "zona='" + zona + '\'' +
                '}';
    }
}
