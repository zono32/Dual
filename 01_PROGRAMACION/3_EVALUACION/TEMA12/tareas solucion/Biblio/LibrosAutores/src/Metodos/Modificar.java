package Metodos;

import java.sql.*;
import java.util.*;

public class Modificar {

    public static void mainModificar(Statement sentencia, Scanner sc) 
    {
        int op = 0;

        do 
        {

            op = Menu.menuModificar(sc);

            switch (op) 
            {
                case 1:
                    modificarLibros(sentencia, sc);
                    break;

                case 2:
                    modificarAutores(sentencia, sc);
                    break;
            }

        } while (op != 3);
    }

    public static void modificarLibros(Statement sentencia, Scanner sc) 
    {
        int op = 0;
        int bandera = 0;
        int respuesta = 0;
        int idL = 0;
        String tituloN = null, autorN = null;
        float precioN = 0f;

        ArrayList<Integer> librosID = null;
        ArrayList<String> autor = null;

        librosID = Consultas.mostrarLibros(sentencia);

        try 
        {
            do 
            {
                System.out.println("Dame id del libro a modificar, 0 para salir");
                idL = sc.nextInt();
                sc.nextLine();

                bandera = Buscar.buscarLibro(librosID, idL, sc);
                
                if (bandera == 1)
                {
                    System.out.println("Libro encontrado\n");
                    System.out.println("Desea modificarlo?\n"
                            + "[1] Si\n"
                            + "[2] No\n");
                    respuesta = sc.nextInt();
                    sc.nextLine();

                    if (respuesta == 1) 
                    {
                        do
                        {
                            op = Menu.menuModLibros(sc);

                            switch (op)
                            {
                                case 1:
                                    System.out.println("Dame el nuevo titulo del libro: ");
                                    tituloN = sc.nextLine();

                                    sentencia.executeUpdate("UPDATE libros set titulo='" + tituloN + "' where idLibro = " + idL + ";");
                                    System.out.println("Titulo Modificado");
                                    break;

                                case 2:
                                    System.out.println("Dame el nuevo precio del libro: ");
                                    precioN = sc.nextFloat();
                                    sc.nextLine();

                                    sentencia.executeUpdate("UPDATE libros set precio='" + precioN + "' where idLibro = " + idL + ";");
                                    System.out.println("Precio modificado");
                                    break;

                                case 3:
                                    autor = Consultas.mostrarAutores(sentencia);
                                    
                                    System.out.println("Dame el dni del nuevo autor del libro: ");
                                    autorN = sc.nextLine();

                                    bandera = Buscar.buscarAutor(autor, autorN, sc);

                                    if (bandera == 1) 
                                    {
                                        System.out.println("Desea modificar el autor de este libro?\n"
                                                + "[1] Si\n"
                                                + "[2] No\n");
                                        respuesta = sc.nextInt();
                                        sc.nextLine();

                                        if (respuesta == 1) 
                                        {
                                            sentencia.executeUpdate("UPDATE libros set autor='" + autorN + "' where idLibro = " + idL + ";");
                                            System.out.println("Autor modificado");
                                        }
                                        else
                                        {
                                            System.out.println("Autor no modificado");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Autor no encontrado");
                                    }

                                break;

                            }

                        } while (op != 4);

                    }
                    
                }
                else
                {
                    System.out.println("Libro no encontrado");
                }
                
            } while (idL != 0 && bandera == 0);

        } catch (SQLException e) 
        {
            System.out.println(e);
        }
    }

    public static void modificarAutores(Statement sentencia, Scanner sc)
    {
        int op = 0;
        String nombreN = null, nacionalidadN = null, dniN = null;
        String dniB = null;
        int bandera = 0;
        int respuesta = 0;
        
        ArrayList<String> autor = null;
        
        autor = Consultas.mostrarAutores(sentencia);
        
        try
        {
            do
            {
                System.out.println("Dame dni del autor a modificar, 0 para salir");
                dniB = sc.nextLine();

                bandera = Buscar.buscarAutor(autor, dniB, sc);
                
                if (bandera == 1)
                {
                    System.out.println("Autor Encontrado");
                    System.out.println("Desea modificarlo?\n"
                            + "[1] Si\n"
                            + "[2] No\n");
                    respuesta = sc.nextInt();
                    sc.nextLine();
                    
                    if (respuesta == 1)
                    {
                        do
                        {
                            
                            op = Menu.menuModAutores(sc);
                            
                            switch(op)
                            {
                                case 1:
                                    System.out.println("Dame el nuevo dni del autor");
                                    dniN = sc.nextLine();
                                    
                                    sentencia.executeUpdate("UPDATE autores set dni='" + dniN + "' where dni = '" + dniB + "';");
                                    System.out.println("Dni del Autor Modificado");
                                break;
                                
                                case 2:
                                    System.out.println("Dame nuevo nombre del autor");
                                    nombreN = sc.nextLine();
                                    
                                    sentencia.executeUpdate("UPDATE autores set nombre='" + nombreN + "' where dni = '" + dniB + "';");
                                    System.out.println("Nombre modificado");
                                break;
                                
                                case 3:
                                    System.out.println("Dame nueva nacionalidad del autor");
                                    nacionalidadN = sc.nextLine();
                                    
                                    sentencia.executeUpdate("UPDATE autores set nacionalidad='" + nacionalidadN + "' where dni = '" + dniB + "';");
                                break;
                            }
                            
                        }while(op != 4);
                    }
                    
                } 
                else
                {
                    System.out.println("Autor no encontrado");
                }                   
                
            }while(dniB.compareToIgnoreCase("0") != 0 && bandera == 0);
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
            
    }
}
