package Metodos;

import java.sql.*;
import java.util.*;

public class Insertar 
{
    public static void mainInsertar(Statement sentencia, Scanner sc)
    {
        int op = 0;
        
        do
        {
            
            op = Menu.menuInsertar(sc);
            
            switch(op)
            {
                case 1:
                    Insertar.autores(sentencia,sc);
                break;
                
                case 2:
                    Insertar.libros(sentencia,sc);
                break;
                
            }
            
        }while(op != 3);
    }
    
    public static void autores(Statement sentencia, Scanner sc)
    {
        String dni, nacionalidad,nombre;
        int respuesta = 0;
        
        try
        {
            
            while(respuesta != 2)
            {
                System.out.println("Dame dni del autor");
                dni = sc.nextLine();
                System.out.println("Dame nombre del autor");
                nombre = sc.nextLine();
                System.out.println("Dame nacionalidad del autor");
                nacionalidad = sc.nextLine();
                
                sentencia.executeUpdate("INSERT INTO AUTORES (dni,nombre,nacionalidad) VALUES('"+ dni +"','"+ nombre +"','"+ nacionalidad +"')");
                
                do
                {
                    System.out.println("Desea añadir libros al autor?\n"
                            + "[1] Si\n"
                            + "[2] No\n");
                    respuesta = sc.nextInt();
                    sc.nextLine();
                    
                    if (respuesta == 1)
                    {
                        librosAutorExistente(sentencia,dni,sc);
                    }
                    
                    
                }while(respuesta != 2);
                
                System.out.println("Desea añadir más autores?\n"
                        + "[1] Si\n"
                        + "[2] No\n");
                respuesta = sc.nextInt();
                sc.nextLine();
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
    
    public static void libros(Statement sentencia, Scanner sc)
    {
        String titulo = null, dni = null;
        float precio = 0f;
        int respuesta = 0;
        ArrayList<String> autor = null;
        int bandera = 0;
        
        try
        {
            
            autor = Consultas.mostrarAutores(sentencia);
            
            System.out.println("Dame dni del autor a añadir libros");
            dni = sc.nextLine();

            // query para encontrar el autor al que añadir los libros, recuperarlo en un resultSet para verificar que exista.
            
            for (int i = 0; i < autor.size();i++)
            {
                if (autor.get(i).compareToIgnoreCase(dni) == 0)
                {
                    bandera = 1;
                    do
                    {                        
                        System.out.println("Dame titulo del libro");
                        titulo = sc.nextLine();
                        System.out.println("Dame precio del libro");
                        precio = sc.nextFloat();
                        sc.nextLine();

                        sentencia.executeUpdate("INSERT INTO LIBROS (idLibro,titulo,precio,autor) VALUES (null,'"+titulo+"','"+precio+"','"+dni+"')");
                        System.out.println("Libro añadido");

                        System.out.println("Desea añadir más libros a este autor?\n"
                                + "[1] Si\n"
                                + "[2] No\n");
                        respuesta = sc.nextInt();
                        sc.nextLine();

                    }while(respuesta != 2);
                }
            }
            
            if (bandera == 0)
            {
                System.out.println("Autor no encontrado");
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }

        
    }
    
    public static void librosAutorExistente(Statement sentencia,String dni, Scanner sc)
    {
        String titulo = null;
        float precio = 0f;
        
        try
        {
            
            System.out.println("Dame titulo del libro");
            titulo = sc.nextLine();
            System.out.println("Dame precio del libro");
            precio = sc.nextFloat();
            sc.nextLine();
            
            sentencia.executeUpdate("INSERT INTO LIBROS (idLibro,titulo,precio,autor) VALUES (null,'"+titulo+"','"+precio+"','"+dni+"')");
            System.out.println("Libro añadido");
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
