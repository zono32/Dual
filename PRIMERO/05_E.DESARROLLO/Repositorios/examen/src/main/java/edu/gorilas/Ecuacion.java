package edu.gorilas;

import java.util.ArrayList;

public class Ecuacion {

    public static ArrayList<Double> ecuacionSegundoGrado(int a, int b,int c){

        ArrayList<Double> soluciones = new ArrayList<>();
        double result1 = 0;
        double result2 = 0;

        double d =( Math.pow(b,2)-(4*a*c));
        result1 = (-b +Math.sqrt(d))/(2*a);

        result2 = (-b -Math.sqrt(d))/(2*a);

        try{
            if(d != 0){
                soluciones.add(result1);
                soluciones.add(result2);
            }

        }catch (Exception e){
            System.out.println("ha habido un error");
        }

        return soluciones;
    }
}
