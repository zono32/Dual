package org.programacion.unidad_11.Actividades.BoletinFicheros;

//Desarrolla un programa que lea datos de 2 arrays, uno con nombres de productos y el otrocon sus precios.
// Almacenar dicho contenido en un fichero, donde cada línea constará denombre de producto y precio.

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Ej2 {
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
    }
}