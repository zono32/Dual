package ActividadesStreams.Boletin;

import java.io.*;
//A partir de un array con nombres de persona, escribir en un fichero denominado
// “datos.txt”dichos nombres, cada uno en una línea.
// A continuación, leer los datos de nuevo del fichero y mostrarlos por pantalla,
// indicando el índice de la posición que ocupa. Ejemplo de ejecución

public class Ejercicio1 {
    public static void main(String[] args) {
        String[] nombres = {"Andrés", "Juan", "Marta", "Ana"};
        try (FileWriter fw = new FileWriter("datos.txt")){
            for (String n : nombres) {
                fw.write(n + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader fr = new FileReader("datos.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String s;
            int i = 1;
            while ((s = br.readLine()) != null) {
                System.out.println(i + ". " + s);
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
