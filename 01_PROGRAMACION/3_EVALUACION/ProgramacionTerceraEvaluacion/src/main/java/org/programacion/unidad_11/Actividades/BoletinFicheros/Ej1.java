package org.programacion.unidad_11.Actividades.BoletinFicheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String ruta = sc.next();
        ruta= ruta+"datos.txt";
        System.out.println("dame la ruta del fichero: ");
        String[] nombres = new String[3];

        try {
            FileWriter fw = new FileWriter(ruta);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }





}
