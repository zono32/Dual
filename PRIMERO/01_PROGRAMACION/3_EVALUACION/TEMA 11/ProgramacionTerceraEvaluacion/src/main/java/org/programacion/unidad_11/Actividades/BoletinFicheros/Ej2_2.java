package org.programacion.unidad_11.Actividades.BoletinFicheros;



import java.io.*;

public class Ej2_2 {

    private static void cargarFichero(){
        String[] productos = {"Agua", "Leche", "Jabón", "Yogur"};
        Double[] precios = {0.75, 0.95, 2.15, 1.50};

        try ( FileWriter fw = new FileWriter("datos.txt")){
            for ( int i = 0 ; i< productos.length; i++){
                fw.write(productos[i]+ " "+ precios[i]+ "\n");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerFichero(){
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




    public static void main(String[] args) {
        cargarFichero();
        leerFichero();
    }
}

