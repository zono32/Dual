/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZZ_EXAMEN;

/**
 *
 * @author nccasares
 */
public class Bazar extends Producto{
    private String tipo;

    public Bazar(String tipo, String nombre, double precio) {
        super(nombre, precio);
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " Bazar{" + "tipo=" + tipo + '}';
    }
}
