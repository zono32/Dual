package Biblioteca;

import java.sql.*;
import java.util.Scanner;

public class main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Statement sentencia = null;
        Connection conexion = null;
        int op = 0;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mariadb://localhost:3306/?user=root&password=";
        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("No hay ningún driver que reconozca la URL especificada");
        } catch (Exception e) {
            System.out.println("Se ha producido algún otro error");
        }

        try {
            sentencia = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error");
        }

        Creacion.crearBase(sentencia);

        do {
           menu();
            op = sc.nextInt();
            switch (op) {
                case 1:
                    nuevoAutor(sentencia);
                    break;
                case 2:
                    nuevoLibro(sentencia);
                    break;
                case 3:
                    borrarLibro(sentencia);
                    break;
                case 4:
                    borrarAutor(sentencia);
                    break;
                case 5:
                    consultarLibroPorTitulo(sentencia);
                    break;
                case 6:
                    consultarLibrosPorAutor(sentencia);
                    break;
                case 7:
                    listarLibros(sentencia);
                    break;
                case 8:
                    listarAutoresConLibros(sentencia);
                    break;
                case 9:
                    modificarLibroPorTitulo(sentencia);
                    break;
                case 10:
                    modificarAutorPorDNI(sentencia);
                    break;
                case 11:
                    System.out.println("Hasta Pronto");
                    break;
                default:
                    System.out.println("Por favor elija una opción correcta");
                    break;
            }

        } while (op != 11);

    }

    private static void menu(){

        System.out.println("**** MENU ****\n");
        System.out.println("[1] Insertar un nuevo Autor/a");
        System.out.println("[2] Insertar un nuevo libro");
        System.out.println("[3] Borrar Libro");
        System.out.println("[4] Borrar autor");
        System.out.println("[5] Consultar datos de un libro");
        System.out.println("[6] Consultar libros de un Autor");
        System.out.println("[7] Listar libros");
        System.out.println("[8] Listar autores con sus libros");
        System.out.println("[9] Modificar libro por título");
        System.out.println("[10] Modificar autor por DNI");
        System.out.println("[11] Salir");

    }

    private static void nuevoAutor(Statement sentencia) {
        System.out.println("Dame el DNI del nuevo autor");
        String dni = sc.next();
        System.out.println("Dame el nuevo nombre del autor");
        String nombre = sc.next();
        System.out.println("Dame la nacionalidad del nuevo autor");
        String nacionalidad = sc.next();
        sc = new Scanner(System.in);

        try {
            sentencia.executeUpdate("INSERT INTO Autores (DNI, Nombre, Nacionalidad) VALUES('" + dni + "', '" + nombre + "', '" + nacionalidad + "')");
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al insertar el nuevo autor");
        }
    }

    private static void nuevoLibro(Statement sentencia) {
        System.out.println("Dame el título del libro");
        String titulo = sc.next();
        System.out.println("Dame el precio del libro");
        float precio = sc.nextFloat();

        sc.nextLine();
        System.out.println("Dame el nombre del autor");
        String autorNombre = sc.next();

        try {
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Autores WHERE Nombre = '" + autorNombre + "'");

            if (resultado.next()) {
                String autorDNI = resultado.getString("DNI");
                sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES('" + titulo + "', " + precio + ", '" + autorDNI + "')");
                System.out.println("Libro insertado correctamente.");
            } else {
                System.out.println("Error: El autor '" + autorNombre + "' no existe en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al insertar el libro.");
            e.printStackTrace();
        }
    }

    private static void borrarLibro(Statement sentencia) {
        System.out.println("Dame nombre del libro que deseas eliminar");
        String nombreLibro = sc.next();

        try {
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Libros WHERE Titulo = '" + nombreLibro + "'");

            if (resultado.next()) {
                System.out.println("¿Seguro que deseas eliminar el libro? (s para sí, n para no)");
                String confirmacion = sc.next();

                if (confirmacion.equalsIgnoreCase("s")) {
                    sentencia.executeUpdate("DELETE FROM Libros WHERE Titulo = '" + nombreLibro + "'");
                    System.out.println("Libro eliminado correctamente.");
                } else {
                    System.out.println("Operación cancelada.");
                }
            } else {
                System.out.println("Error: El libro '" + nombreLibro + "' no existe en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al eliminar el libro.");
            e.printStackTrace();
        }
    }

    private static void borrarAutor(Statement sentencia) {
        System.out.println("Dame el nombre del autor que deseas eliminar");
        String nombreAutor = sc.next();

        try {
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Autores WHERE Nombre = '" + nombreAutor + "'");

            if (resultado.next()) {
                String dniAutor = resultado.getString("DNI");

                sentencia.executeUpdate("DELETE FROM Libros WHERE Autor = '" + dniAutor + "'");
                System.out.println("Libros del autor eliminados correctamente.");

                sentencia.executeUpdate("DELETE FROM Autores WHERE Nombre = '" + nombreAutor + "'");
                System.out.println("Autor eliminado correctamente.");
            } else {
                System.out.println("Error: El autor '" + nombreAutor + "' no existe en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al eliminar el autor.");
            e.printStackTrace();
        }
    }

    private static void consultarLibroPorTitulo(Statement sentencia) {
        System.out.println("Introduce el título del libro que deseas consultar:");
        String tituloLibro = sc.next();

        try {
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Libros WHERE Titulo = '" + tituloLibro + "'");

            if (resultado.next()) {
                String titulo = resultado.getString("Titulo");
                float precio = resultado.getFloat("Precio");
                String autorDNI = resultado.getString("Autor");

                ResultSet resultadoAutor = sentencia.executeQuery("SELECT Nombre FROM Autores WHERE DNI = '" + autorDNI + "'");
                resultadoAutor.next();
                String nombreAutor = resultadoAutor.getString("Nombre");

                System.out.println("Título: " + titulo);
                System.out.println("Precio: " + precio);
                System.out.println("Autor: " + nombreAutor);
            } else {
                System.out.println("No se encontró ningún libro con el título '" + tituloLibro + "'.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al consultar el libro por título.");
            e.printStackTrace();
        }
    }

    private static void consultarLibrosPorAutor(Statement sentencia) {
        System.out.println("Introduce el nombre del autor:");
        String nombreAutor = sc.next();

        try {
            ResultSet resultadoAutor = sentencia.executeQuery("SELECT DNI FROM Autores WHERE Nombre = '" + nombreAutor + "'");

            if (resultadoAutor.next()) {
                String autorDNI = resultadoAutor.getString("DNI");

                ResultSet resultadoLibros = sentencia.executeQuery("SELECT * FROM Libros WHERE Autor = '" + autorDNI + "'");

                if (resultadoLibros.next()) {
                    System.out.println("Libros del autor '" + nombreAutor + "':");
                    do {
                        String titulo = resultadoLibros.getString("Titulo");
                        float precio = resultadoLibros.getFloat("Precio");

                        System.out.println("Título: " + titulo + ", Precio: " + precio);
                    } while (resultadoLibros.next());
                } else {
                    System.out.println("El autor '" + nombreAutor + "' no tiene libros asociados.");
                }
            } else {
                System.out.println("No se encontró ningún autor con el nombre '" + nombreAutor + "'.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al consultar los libros del autor.");
            e.printStackTrace();
        }
    }

    private static void listarLibros(Statement sentencia) {
        try {
            ResultSet resultadoLibros = sentencia.executeQuery("SELECT * FROM Libros");

            if (resultadoLibros.next()) {
                System.out.println("Listado de todos los libros:");

                do {
                    String titulo = resultadoLibros.getString("Titulo");
                    float precio = resultadoLibros.getFloat("Precio");
                    String autorDNI = resultadoLibros.getString("Autor");

                    ResultSet resultadoAutor = sentencia.executeQuery("SELECT Nombre FROM Autores WHERE DNI = '" + autorDNI + "'");
                    resultadoAutor.next();
                    String nombreAutor = resultadoAutor.getString("Nombre");

                    System.out.println("Título: " + titulo + ", Precio: " + precio + ", Autor: " + nombreAutor);
                } while (resultadoLibros.next());
            } else {
                System.out.println("No se encontraron libros en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al listar los libros.");
            e.printStackTrace();
        }
    }

    private static void listarAutoresConLibros(Statement sentencia) {
        try {
            ResultSet resultadoAutores = sentencia.executeQuery("SELECT * FROM Autores");

            while (resultadoAutores.next()) {
                String dniAutor = resultadoAutores.getString("DNI");
                String nombreAutor = resultadoAutores.getString("Nombre");

                ResultSet resultadoLibros = sentencia.executeQuery("SELECT * FROM Libros WHERE Autor = '" + dniAutor + "'");

                System.out.println("Autor: " + nombreAutor);

                if (resultadoLibros.next()) {
                    System.out.println("Libros:");

                    do {
                        String titulo = resultadoLibros.getString("Titulo");
                        float precio = resultadoLibros.getFloat("Precio");

                        System.out.println("  Título: " + titulo + ", Precio: " + precio);
                    } while (resultadoLibros.next());
                } else {
                    System.out.println("  Este autor no tiene libros asociados.");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al listar los autores con sus libros.");
            e.printStackTrace();
        }
    }

    private static void modificarLibroPorTitulo(Statement sentencia) {
        System.out.println("Introduce el título del libro que deseas modificar:");
        String tituloLibro = sc.next();

        try {
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Libros WHERE Titulo = '" + tituloLibro + "'");

            if (resultado.next()) {
                System.out.println("Introduce el nuevo título del libro:");
                String nuevoTitulo = sc.next();
                System.out.println("Introduce el nuevo precio del libro:");
                float nuevoPrecio = sc.nextFloat();
                sc.nextLine();
                sentencia.executeUpdate("UPDATE Libros SET Titulo = '" + nuevoTitulo + "', Precio = " + nuevoPrecio + " WHERE Titulo = '" + tituloLibro + "'");
                System.out.println("Libro modificado correctamente.");
            } else {
                System.out.println("No se encontró ningún libro con el título '" + tituloLibro + "'.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al modificar el libro por título.");
            e.printStackTrace();
        }
    }

    private static void modificarAutorPorDNI(Statement sentencia) {
        System.out.println("Introduce el DNI del autor que deseas modificar:");
        String dniAutor = sc.next();

        try {
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Autores WHERE DNI = '" + dniAutor + "'");

            if (resultado.next()) {
                System.out.println("Introduce el nuevo nombre del autor:");
                String nuevoNombre = sc.next();
                System.out.println("Introduce la nueva nacionalidad del autor:");
                String nuevaNacionalidad = sc.next();

                sentencia.executeUpdate("UPDATE Autores SET Nombre = '" + nuevoNombre + "', Nacionalidad = '" + nuevaNacionalidad + "' WHERE DNI = '" + dniAutor + "'");
                System.out.println("Autor modificado correctamente.");
            } else {
                System.out.println("No se encontró ningún autor con el DNI '" + dniAutor + "'.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al modificar el autor por DNI.");
            e.printStackTrace();
        }
    }
}