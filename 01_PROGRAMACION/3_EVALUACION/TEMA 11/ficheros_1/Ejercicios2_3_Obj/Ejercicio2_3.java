package ActividadesStreams.Boletin.Ejercicios2_3_Obj;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio2_3 {
    private void cargarFichero() {
        try (ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("datos.txt"))) {
            String[] productos = {"Agua", "Leche", "Jabón", "Yogur"};
            double[] precios = {0.75, 0.95, 2.15, 1.50};

            for (int i = 0; i < productos.length; i++) {
                dos.writeObject(new Producto(productos[i], precios[i]));
            }
            System.out.println("Fichero cargado");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void borrado() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del producto que desea eliminar:");
        String nombre = sc.nextLine();

        File fic = new File("datos.txt");
        File ficAux = new File("Temp.txt");
        try (FileInputStream fis = new FileInputStream(fic);
             ObjectInputStream dis = new ObjectInputStream(fis);
             FileOutputStream fos = new FileOutputStream(ficAux);
             ObjectOutputStream temporalEscritura = new ObjectOutputStream(fos)) {

            Producto p;
            while (true) {
                p = (Producto) dis.readObject();

                if (p.getNombre().equalsIgnoreCase(nombre))
                    System.out.println("Eliminado: " + p.getNombre());
                else
                    temporalEscritura.writeObject(p);
            }
        } catch (EOFException e) {
            System.err.println("Fin de fichero");
            fic.delete();
            Files.move(Paths.get("Temp.txt"), Paths.get("datos.txt"));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Ejercicio2_3 e = new Ejercicio2_3();
        try {
            e.cargarFichero();
            e.borrado();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
