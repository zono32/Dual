/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema_10_excepciones.Empleados;

/**
 *
 * @author nccasares
 */

public class Repartidor extends Empleado {
 
    //Atributos
    private String zona;
 
    //Constructores
    public Repartidor(String zona, String nombre,String dni, int edad, double salario) {
        super(nombre,dni, edad, salario);
        this.zona = zona;
    }
 
    //Metodos
    public String getZona() {
        return zona;
    }
 
    public void setZona(String zona) {
        this.zona = zona;
    }
 
    @Override
    public String toString() {
        return super.toString() + " zona=" + zona;
    }
 
    /**
     * Si tiene menos de 25 años y la zona es "zona 3",
     * aumentamos el sueldo al empleado
     * @return 
     */
    @Override
    public boolean plus() {
 
        if (super.getEdad() < 25 && this.zona.equalsIgnoreCase("zona 3")) {
            //Con super. llamo a un metodo de la clase padre
            double nuevoSalario = super.getSalario() + super.plus;
            super.setSalario(nuevoSalario);
            System.out.println("Se le añadido el plus, al empleado "+super.getNombre());
            return true;
        }
 
        return false;
    }
}