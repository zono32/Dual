/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActividadesStreams.Boletin.Ejercicio4_Obj;

import java.io.*;
import java.util.Scanner;

/**
 * @author nccasares
 */
public class Ejercicio4 {

    static Scanner teclado = new Scanner(System.in);


    // A CONTINUACIÓN SE CREA UN STREAM DE OBJETOS ÚNICO PARA UNA EJECUCIÓN DEL PROGRAMA.
    // SE DEBE TENER EN CUENTA QUE, CADA VEZ QUE SE ABRE UN FICHERO CON OBJECTOUTPUTSTREAM Y SE AÑADEN DATOS,
    // SE INCORPORAN UNAS CABECERAS AL FICHERO ÚNICAS, POR LO QUE, SI EN LA SIGUIENTE EJECUCIÓN LO VOLVEMOS A ABRIR E INTENTAMOS
    // AÑADIR MÁS DATOS, DARÁ ERROR DICIENDO QUE LA CABECERA NO LA RECONOCE
    // LA SOLUCION A ESTO ES CREAR UNA NUEVA CLASE "MIOBJECTOUTPUTSTREAM", QUE HEREDE DE OBJECTOUTPUTSTREAM, Y QUE SOBREESCRIBA
    // EL MÉTODO writeHeaders, PERO CON EL CUERPO DEL MÉTODO VACÍO.
    static FileOutputStream fos;
    static ObjectOutputStream registroSalida;

    static {
        try {
            fos = new FileOutputStream("Registro.txt", true);
            registroSalida = new ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ejercicio4();
    }

    public static void ejercicio4() {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    anhadirRegistro();
                    break;
                case 2:
                    listarRegistro();
                    break;
                case 3:
                    buscarPorNombre();
                    break;
                case 4:
                    try {
                        borrarRegistro();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

            }
        } while (opcion != 0);
        try {
            registroSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int menu() {
        System.out.println("-- Registro --");
        System.out.println("1-- Añadir registro");
        System.out.println("2-- Listar");
        System.out.println("3-- Buscar registro");
        System.out.println("4-- Borrar registro");
        System.out.println("0-- Salir");
        return Integer.parseInt(teclado.nextLine());
    }

    private static void anhadirRegistro() {
        System.out.println("Introduzca nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca direccion: ");
        String direccion = teclado.nextLine();
        System.out.println("Introduzca telefono: ");
        String telefono = teclado.nextLine();

        try {
            registroSalida.writeObject(new Contacto(nombre, direccion, telefono));
        } catch (IOException ex) {
            System.out.println("Error al manipular");
        }
        System.out.println("Persona añadida correctamente");
    }

    private static void listarRegistro() {
        try (FileInputStream fis = new FileInputStream("Registro.txt");
             ObjectInputStream registroEntrada = new ObjectInputStream(fis)) {

            int i = 1;
            Contacto c;
            while ((c = (Contacto) registroEntrada.readObject()) != null) {
                System.out.println("----------");
                System.out.println("Nº Registro " + i);
                System.out.println("----------");
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Direccion: " + c.getDireccion());
                System.out.println("Telefono: " + c.getTelefono());
                i++;
            }
        } catch (EOFException ex) {
            System.err.println("Fin de fichero");
        } catch (IOException ex) {
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void buscarPorNombre() {
        System.out.println("Ingresa el nombre de la persona: ");
        String nombre = teclado.nextLine();
        try (ObjectInputStream registroEntrada = new ObjectInputStream(new FileInputStream("Registro.txt"))) {

            int i = 1;
            Contacto c;
            while ((c = (Contacto) registroEntrada.readObject()) != null) {
                if (nombre.equals(c.getNombre())) {
                    System.out.println("----------");
                    System.out.println("Nº Registro " + i);
                    System.out.println("----------");
                    System.out.println("Nombre: " + c.getNombre());
                    System.out.println("Direccion: " + c.getDireccion());
                    System.out.println("Telefono: " + c.getTelefono());
                    i++;
                }
            }

        } catch (IOException ex) {
            System.out.println("Error con el fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void borrarRegistro() throws IOException {
        System.out.println("Ingresa el nombre de la persona que quieres borrar del registro: ");
        String nombre = teclado.nextLine();
        File temp = File.createTempFile("Temp", ".txt");

        // ESCRIBO EN TEMPORAL LOS ELEMENTOS DISTINTOS AL ELIMINADO
        try (ObjectInputStream registroLectura = new ObjectInputStream(new FileInputStream("Registro.txt"));
             ObjectOutputStream temporalEscritura = new ObjectOutputStream(new FileOutputStream(temp, true))) {

            Contacto c;
            while (true) {
                c = (Contacto) registroLectura.readObject();
                if (!nombre.equals(c.getNombre())) {
                    temporalEscritura.writeObject(c);
                }
            }

        } catch (EOFException e) {
            System.err.println("Fin de fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // VUELCO LOS DATOS EN EL FICHERO ORIGINAL
        try (ObjectInputStream temporalLectura = new ObjectInputStream(new FileInputStream(temp));
             ObjectOutputStream resSalida = new ObjectOutputStream(new FileOutputStream("Registro.txt"))) {
            Contacto c;
            while (true) {
                c = (Contacto) temporalLectura.readObject();
                resSalida.writeObject(c);
            }
        } catch (EOFException e) {
            System.err.println("Fin de fichero. Copia realizada");
        } catch (IOException ex) {
            System.out.println("Error con el fichero");
        } catch (
                ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
