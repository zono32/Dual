/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

/**
 *
 * @author nccasares
 */
public class Comercial extends Empleado {
 
    //Atributos
    private double comision;
 
    //Constructores
    public Comercial(double comision, String nombre,String dni, int edad, double salario) {
        super(nombre,dni, edad, salario);
        this.comision = comision;
    }
 
    //Metodos
    public double getComision() {
        return comision;
    }
 
    public void setComision(double comision) {
        this.comision = comision;
    }
 
    /**
     * Devuelve el estado del objeto, llama primero al toString de la clase
     * padre
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " comision=" + comision;
    }
 
    /**
     * Si tiene mas de 30 años y la comision es mayor que 200, aumentamos el
     * sueldo al empleado
     *
     * @return
     */
    @Override
    public boolean plus() {
 
        if (super.getEdad() > 30 && this.comision > 200) {
            //Con super. llamo a un metodo de la clase padre
            double nuevoSalario = super.getSalario()+ super.plus;
            super.setSalario(nuevoSalario);
            System.out.println("Se le añadido el plus, al empleado " + super.getNombre());
            return true;
        }
 
        return false;
 
    }
 
}
