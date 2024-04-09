package org.programacion.unidad_11.Actividades.BoletinFicheros;
//A partir del ejercicio anterior, implementa un método que solicite un nombre de producto alusuario
// y lo elimine del listado (del fichero). Deberá mostrar también su información porpantalla
// (nombre y precio)

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej3 {


    public static void añadirProducto(){
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.txt"))){
            String[] productos = {"Agua", "Leche", "Jabón", "Yogur"};
            double[] precios = {0.75, 0.95, 2.15, 1.50};

            for( int i = 0; i< productos.length;i++){
                dos.writeUTF(productos[i] + " " + precios[i]+"\n");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void eliminarProducto(String nombre){

    }

    public static void main(String[] args){

    }

}
