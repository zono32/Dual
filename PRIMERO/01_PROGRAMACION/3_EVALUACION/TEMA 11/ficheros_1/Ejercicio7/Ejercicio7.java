package ActividadesStreams.Boletin.Ejercicio7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Ejercicio7 {
    static Scanner teclado = new Scanner(System.in);

    static File fic = new File("Alumnos.txt");

    // A CONTINUACIÓN SE CREA UN STREAM DE OBJETOS ÚNICO PARA UNA EJECUCIÓN DEL PROGRAMA.
    // SE DEBE TENER EN CUENTA QUE, CADA VEZ QUE SE ABRE UN FICHERO CON OBJECTOUTPUTSTREAM Y SE AÑADEN DATOS,
    // SE INCORPORAN UNAS CABECERAS AL FICHERO ÚNICAS, POR LO QUE, SI EN LA SIGUIENTE EJECUCIÓN LO VOLVEMOS A ABRIR E INTENTAMOS
    // AÑADIR MÁS DATOS, DARÁ ERROR DICIENDO QUE LA CABECERA NO LA RECONOCE
    // LA SOLUCION A ESTO ES CREAR UNA NUEVA CLASE "MIOBJECTOUTPUTSTREAM", QUE HEREDE DE OBJECTOUTPUTSTREAM, Y QUE SOBREESCRIBA
    // EL MÉTODO writeHeaders, PERO CON EL CUERPO DEL MÉTODO VACÍO.
    static FileOutputStream fos;
    static ObjectOutputStream listadoAlumnos;

    static {
        try {
            fos = new FileOutputStream(fic, true);
            listadoAlumnos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int opcion;
        try {
            do {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        anhadirAlumno();
                        break;
                    case 2:
                        listarAlumnos();
                        break;
                    case 3:
                        consultarDatosAlumno();
                        break;
                    case 4:

                        modificarAlumno();
                        break;
                    case 5:
                        eliminarAlumno();
                        break;
                }
            } while (opcion != 0);

            listadoAlumnos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int menu() {
        System.out.println("-- Registro --");
        System.out.println("1-- Añadir alumnos");
        System.out.println("2-- Listar alumnos");
        System.out.println("3-- Consultar datos alumno");
        System.out.println("4-- Modificar alumno");
        System.out.println("5-- Eliminar alumno");
        System.out.println("0-- Salir");
        return Integer.parseInt(teclado.nextLine());
    }

    private static void anhadirAlumno() {
        System.out.println("Introduzca nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca apellidos: ");
        String apellidos = teclado.nextLine();

        System.out.println("Introduzca edad: ");
        int edad = teclado.nextInt();

        teclado = new Scanner(System.in);

        try {
            listadoAlumnos.writeObject(new Alumno(nombre, apellidos, edad));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void consultarDatosAlumno() {
        System.out.println("Introduzca la posición del elemento a consultar:");
        int pos = teclado.nextInt();

        teclado = new Scanner(System.in);
        try (FileInputStream fis = new FileInputStream(fic);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            int cont = 1;
            while (true) {
                Alumno a = (Alumno) ois.readObject();
                if (cont == pos) {
                    System.out.println(a.getNombre() + " " + a.getApellidos() + " " + a.getEdad());
                }
                cont++;
            }
        } catch (EOFException e) {
            System.err.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void modificarAlumno() throws IOException {
        System.out.println("Introduzca la posición del elemento a modificar:");
        int pos = teclado.nextInt();

        teclado = new Scanner(System.in);
        File temp = File.createTempFile("Temp", ".txt");
        try (FileInputStream fis = new FileInputStream(fic);
             ObjectInputStream ois = new ObjectInputStream(fis);
             FileOutputStream fos = new FileOutputStream(temp, true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            int cont = 1;
            while (true) {
                if (cont == pos) {
                    Alumno a = (Alumno) ois.readObject();
                    System.out.println("Nuevo nombre: ");
                    a.setNombre(teclado.nextLine());
                    System.out.println("Nuevos apellidos:");
                    a.setApellidos(teclado.nextLine());
                    System.out.println("Nueva edad:");
                    a.setEdad(teclado.nextInt());
                    teclado = new Scanner(System.in);
                    System.out.println(a.getNombre() + " " + a.getApellidos() + " " + a.getEdad());
                    oos.writeObject(a);
                } else {
                    oos.writeObject(ois.readObject());
                }
                cont++;
            }
        } catch (EOFException e) {
            System.err.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        volcadoFichero(temp);
    }
    private static void eliminarAlumno() throws IOException {
        System.out.println("Introduzca la posición del elemento a eliminar:");
        int pos = teclado.nextInt();
        teclado = new Scanner(System.in);
        File ficTemp = File.createTempFile("Temp", "txt");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fic));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficTemp))) {
            int cont = 1;
            while (true) {
                Alumno a = (Alumno) ois.readObject();
                if (cont != pos) {
                    oos.writeObject(a);
                } else {
                    System.out.println(a.getNombre() + " " + a.getApellidos() + " " + a.getEdad());
                    System.out.println("Elemento eliminado");
                }
                cont++;
            }
        } catch (EOFException e) {
            System.err.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        volcadoFichero(ficTemp);
    }

    private static void listarAlumnos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fic))) {
            int cont = 1;
            while (true) {
                Alumno a = (Alumno) ois.readObject();
                System.out.println("----------");
                System.out.println("Nº Alumno " + cont);
                System.out.println("----------");
                System.out.println("Nombre: " + a.getNombre());
                System.out.println("Apellidos: " + a.getApellidos());
                System.out.println("Edad: " + a.getEdad());
                cont++;
            }
        } catch (EOFException e) {
            System.err.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void volcadoFichero(File ficOrigen) throws IOException {
        try (FileInputStream fis = new FileInputStream(ficOrigen);
             ObjectInputStream ois = new ObjectInputStream(fis);
             FileOutputStream fos = new FileOutputStream("Alumnos.txt");
             ObjectOutputStream resSalida = new ObjectOutputStream(fos)) {
            while (true) {
                resSalida.writeObject(ois.readObject());
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
