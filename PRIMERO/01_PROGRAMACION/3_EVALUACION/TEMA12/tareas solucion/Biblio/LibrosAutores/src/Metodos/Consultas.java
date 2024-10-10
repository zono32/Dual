package Metodos;

import java.sql.*;
import java.util.*;

public class Consultas 
{
    
    public static void mainConsultas(Statement sentencia, Scanner sc)
    {
        int op = 0;
        
        do
        {
            
            op = Menu.menuConsultas(sc);
            
            switch(op)
            {
                case 1:
                    datosLibro(sentencia,sc);
                break;
                
                case 2:
                    datosLibrosAutor(sentencia,sc);
                break;
                
                case 3:
                    datosLibros(sentencia);
                break;
                
                case 4:
                    datosAutoresLibros(sentencia);
                break;
            }
            
        }while(op != 5);
        
    }
    
    
    public static void datosLibro(Statement sentencia, Scanner sc)
    {
        String tituloB = null;
                
        try
        {
            
            System.out.println("Dame titulo del libro a buscar: ");
            tituloB = sc.nextLine();
            
            ResultSet result = sentencia.executeQuery("Select * from libros where titulo = '"+tituloB+"';");
            
            while(result.next())
            {
                System.out.println("IDLibro: "+result.getInt("idLibro"));
                System.out.println("TITULO: "+result.getString("titulo"));
                System.out.println("PRECIO: "+result.getFloat("precio"));
                System.out.println("Autor: "+result.getString("autor"));
                System.out.println("-----------------------------------\n");
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public static void datosLibrosAutor(Statement sentencia, Scanner sc)
    {
        String nombreB = null;
        
        try
        {
            
            System.out.println("Dame nombre del autor a buscar: ");
            nombreB = sc.nextLine();
            
            ResultSet result = sentencia.executeQuery("select * from libros where autor=(select dni from autores where nombre='" + nombreB + "');");
            
            while(result.next())
            {
                System.out.println("\n ID Libro: "+result.getInt("idLibro"));
                System.out.println("\n TITULO: "+result.getString("titulo"));
                System.out.println("\n Precio: "+result.getFloat("precio"));
                System.out.println("\n Autor: "+result.getString("autor"));
                System.out.println("-----------------------------------------");
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public static void datosLibros (Statement sentencia)
    {
        int cont = 0;
        
        try
        {
            
            ResultSet result = sentencia.executeQuery("Select * from libros");
            
            while(result.next())
            {
                cont++;
                System.out.println("\nLos datos del libro en la fila "+ cont +" son: ");
                
                System.out.println("\n ID Libro: "+result.getInt("idLibro"));
                System.out.println("\n TITULO: "+result.getString("titulo"));
                System.out.println("\n Precio: "+result.getFloat("precio"));
                System.out.println("\n Autor: "+result.getString("autor"));
                System.out.println("-----------------------------------------");        
                
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public static void datosAutoresLibros(Statement sentencia)
    {
        String dniC = null;
        
        try
        {
            
            ResultSet result = sentencia.executeQuery("Select * from autores left join libros on dni = autor");
            
            while (result.next())
            {
                if (dniC == null)
                {
                    System.out.println("    DNI       NOMBRE        NACIONALIDAD");
                    System.out.printf("%7s %12s %12s",result.getString("dni"),
                                                      result.getString("nombre"),
                                                      result.getString("nacionalidad")+"\n");
                    System.out.println("-------------------------------------------------------");
                }
                else if (result.getString("dni").compareToIgnoreCase(dniC) != 0)
                    {
                        System.out.println("    DNI       NOMBRE        NACIONALIDAD");
                        System.out.printf("%7s %12s %12s",result.getString("dni"),
                                                          result.getString("nombre"),
                                                          result.getString("nacionalidad")+"\n");
                        System.out.println("-------------------------------------------------------");
                    }
                
                if (result.getInt("idLibro") != 0)
                {
                    System.out.println("  IdLibro       Titulo              Precio      Autor");
                    System.out.printf("%9d %18s %14.2f %13s",result.getInt("idLibro"),
                                                             result.getString("titulo"),
                                                             result.getFloat("precio"), 
                                                             result.getString("autor")+"\n");
                    System.out.println("*******************************************************");
                }

                dniC = result.getString("dni");
                
            }
                                    
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    

    public static ArrayList mostrarAutores(Statement sentencia)
    {
        int cont = 0;
        ArrayList<String> autor = new ArrayList<>();
        
        try
        {
            ResultSet result = sentencia.executeQuery("Select * from autores");
            
            while(result.next())
            {
                cont++;
                System.out.println("\nLos datos del autor en la fila "+ cont +" son: ");
                
                System.out.println("\n Dni del autor: "+result.getString("dni"));
                System.out.println("\n Nombre del autor: "+result.getString("nombre"));
                System.out.println("\n Nacionalidad del autor: "+result.getString("nacionalidad"));
                System.out.println("--------------------------------------------------------------");
                autor.add(result.getString("dni"));
                
            }
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return autor;
    }
    
    public static ArrayList mostrarLibros(Statement sentencia)
    {
        int cont = 0;
        ArrayList<Integer> librosID = new ArrayList<>();
        
        try
        {
            
            ResultSet result = sentencia.executeQuery("Select * from libros");
            
            while(result.next())
            {
                cont++;
                System.out.println("\nLos datos del libro en la fila "+ cont +" son: ");
                
                System.out.println("\n ID Libro: "+result.getInt("idLibro"));
                System.out.println("\n TITULO: "+result.getString("titulo"));
                System.out.println("\n Precio: "+result.getFloat("precio"));
                System.out.println("\n Autor: "+result.getString("autor"));
                System.out.println("-----------------------------------------");
                librosID.add(result.getInt("idLibro"));              
                
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return librosID;
    }
    
}
