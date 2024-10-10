package Ficheros;

//A partir de un array con nombres de persona, escribir en un fichero denominado
// “datos.txt”dichos nombres, cada uno en una línea.
// A continuación, leer los datos de nuevo del fichero y mostrarlos por pantalla,
// indicando el índice de la posición que ocupa. Ejemplo de ejecución

import java.io.*;

public class Ejercicio_1 {

    static String[] nombres = {"Kinso", "Ana", "Zoe", "Noel"};

   private static void escribirFichero(){

       try (FileWriter fw = new FileWriter("datos.txt")) {
           for (String n : nombres){
               fw.write(n + "\n");
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
   private static void leerFichero(){

       String s;
       int i = 1;
       try ( FileReader fr = new FileReader("datos.txt");
             BufferedReader br = new BufferedReader(fr)){

           while ((s = br.readLine()) != null) {
               System.out.println( i+". " +s);
               i++;
           }

       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

    public static void main(String[] args) {
        escribirFichero();
        leerFichero();
    }

}

