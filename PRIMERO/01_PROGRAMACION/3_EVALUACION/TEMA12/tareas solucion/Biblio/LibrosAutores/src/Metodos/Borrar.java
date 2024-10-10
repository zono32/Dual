package Metodos;

import java.sql.*;
import java.util.*;

public class Borrar 
{
    
    public static void mainBorrar(Statement sentencia, Scanner sc)
    {
        int op = 0;
        
        do
        {
            
            op = Menu.menuBorrar(sc);
            
            switch(op)
            {
                case 1:
                    borrarLibros(sentencia,sc);
                break;
                
                case 2:
                    borrarAutores(sentencia,sc);
                break;
                    
            }
            
        }while(op != 3);
    }
    
    public static void borrarLibros(Statement sentencia, Scanner sc)
    {
        int idL = 0;
        int x = 0;
        int respuesta = 0;
        int bandera = 0;
        
        ArrayList<Integer> librosID = null;
        
        librosID = Consultas.mostrarLibros(sentencia);
        
        try
        {
            do
            {
                
                System.out.println("Dame el id del libro a borrar, 0 para salir");
                idL = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < librosID.size(); i++)
                {
                    if (idL == librosID.get(i))
                    {
                        x = i;
                        bandera = 1;
                        
                        System.out.println("Libro encontrado\n");
                        System.out.println("Desea eliminarlo?\n"
                                + "[1] Si\n"
                                + "[2] No\n");
                        respuesta = sc.nextInt();
                        sc.nextLine();

                        if (respuesta == 1)
                        {
                            sentencia.execute("DELETE from libros where "+ idL +" = idLibro");
                            librosID.remove(x);
                            System.out.println("Libro borrado con exito");
                        }
                        else
                        {
                            System.out.println("Libro no eliminado");
                        }

                    }
                }
                
                if (bandera == 0)
                {
                    System.out.println("Libro no encontrado");
                }
                
            }while( idL != 0 && bandera == 0 );
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public static void borrarAutores(Statement sentencia, Scanner sc)
    {
        String dniAutor = null;
        ArrayList<String> autor = null;
        int respuesta = 0;
        int x = 0;
        int bandera = 0;
        
        autor = Consultas.mostrarAutores(sentencia);
        
        try
        {
            do
            {
                System.out.println("Dame dni del autor a borrar, exit para salir, 0 para salir");
                dniAutor = sc.nextLine();

                for (int i = 0; i < autor.size();i++)
                {
                    if (autor.get(i).compareToIgnoreCase(dniAutor) == 0)
                    {
                        x = i;
                        bandera = 1;

                        System.out.println("Autor encontrado\n");
                        System.out.println("Desea eliminarlo?\n"
                                + "[1] Si\n"
                                + "[2] No\n");
                        respuesta = sc.nextInt();
                        sc.nextLine();

                        if (respuesta == 1)
                        {
                            sentencia.execute("DELETE from autores where '"+ dniAutor +"' = dni");
                            autor.remove(x);
                            System.out.println("Autor eliminado y libros eliminados");
                        }
                        else
                        {
                            System.out.println("El autor no se ha eliminado");
                        }

                    }
                }
                
                if (bandera == 0)
                {
                    System.out.println("Autor no encontrado");
                }
                    
            }while(dniAutor.compareToIgnoreCase("0") != 0 && bandera == 0);
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
