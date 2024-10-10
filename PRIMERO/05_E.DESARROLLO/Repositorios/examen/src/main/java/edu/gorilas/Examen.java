package edu.gorilas;

import java.util.ArrayList;
import java.util.Scanner;

public class Examen {

    public static void main( String[] args ){

        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos a hacer una ecuación de segundo grado. \nPara ello introduce los coeficientes de la ecuación del modo ax^2 + bx + c = 0");

        System.out.println("Dime el primer número (a):");
        int a = sc.nextInt();

        System.out.println("Dime el segundo número (b):");
        int b = sc.nextInt();

        System.out.println("Dime el tercer número (c):");
        int c = sc.nextInt();

        ArrayList<Double> soluciones = Ecuacion.ecuacionSegundoGrado(a, b, c);

        if (soluciones.isEmpty()) {
            System.out.println("La ecuación no tiene soluciones reales.");

        } else {
            System.out.println("Las soluciones son:");
            for (Double solucion : soluciones) {
                System.out.println(solucion);
            }
        }
    }
}