package org.programacion.unidad_11.Actividades.BoletinFicheros;

//A partir del ejercicio anterior, implementa un método que solicite un nombre de producto alusuario
// y lo elimine del listado (del fichero). Deberá mostrar también su información porpantalla
// (nombre y precio)

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        String[] productos = {"Producto1", "Producto2", "Producto3"};
        double[] precios = {10.5, 20.0, 15.75};

        // Escribir los datos en el archivo productos.txt
        try {
            FileWriter fileWriter = new FileWriter("productos.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < productos.length; i++) {
                bufferedWriter.write(productos[i] + " " + precios[i]);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Solicitar nombre de producto a eliminar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del producto a eliminar: ");
        String productoAEliminar = scanner.nextLine();

        // Eliminar producto del listado y mostrar su información
        try {
            FileReader fileReader = new FileReader("productos.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(productoAEliminar)) {
                    System.out.println("Producto eliminado: " + line);
                } else {
                    lines.add(line);
                }
            }

            bufferedReader.close();

            FileWriter fileWriter = new FileWriter("productos.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String item : lines) {
                bufferedWriter.write(item);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}