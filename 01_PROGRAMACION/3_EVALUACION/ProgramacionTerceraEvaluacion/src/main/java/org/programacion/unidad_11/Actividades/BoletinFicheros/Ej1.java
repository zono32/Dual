package org.programacion.unidad_11.Actividades.BoletinFicheros;

//A partir de un array con nombres de persona, escribir en un fichero denominado
// “datos.txt”dichos nombres, cada uno en una línea.
// A continuación, leer los datos de nuevo del fichero ymostrarlos por pantalla,
// indicando el índice de la posición que ocupa. Ejemplo de ejecución

//"Pepe", "William", "James", "John", "William"

import java.io.*;
public class Ej1 {

    public static void main(String[] args) {

       String [] nombres = {"Pepe", "William", "James", "John", "William"};

        try(FileWriter fw = new FileWriter("datos.txt")){
            for( String n : nombres){
                fw.write(n +"\n");
            }
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileReader fr = new FileReader("datos.txt");
            BufferedReader br = new BufferedReader(fr)) {
            String s;
            int i = 1;
            while ((s = br.readLine())!=null){
                System.out.println(i +". " + s );
                i++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
