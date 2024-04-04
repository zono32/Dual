package org.programacion.unidad_11.Actividades.BoletinFicheros;

//A partir de un array con nombres de persona, escribir en un fichero denominado
// “datos.txt”dichos nombres, cada uno en una línea.
// A continuación, leer los datos de nuevo del fichero ymostrarlos por pantalla,
// indicando el índice de la posición que ocupa. Ejemplo de ejecución

import java.io.*;
import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) {


            String[] nombres = {"Juan", "Maria", "Pedro", "Ana"};

            // Escribir los nombres en el archivo datos.txt
            try {
                FileWriter fileWriter = new FileWriter("datos.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (String nombre : nombres) {
                    bufferedWriter.write(nombre);
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Leer los nombres del archivo y mostrarlos por pantalla
            try {
                FileReader fileReader = new FileReader("datos.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                int index = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println("Nombre en la posición " + index + ": " + line);
                    index++;
                }

                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
