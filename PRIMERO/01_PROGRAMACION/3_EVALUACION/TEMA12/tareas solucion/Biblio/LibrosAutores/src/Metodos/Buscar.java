package Metodos;

import java.util.*;

public class Buscar 
{    
    public static int buscarAutor(ArrayList<String> autor, String dniAutor, Scanner sc)
    {
        int bandera = 0;
        
        for (int i = 0; i < autor.size(); i++)
        {
            if (autor.get(i).compareToIgnoreCase(dniAutor) == 0)
            {
                bandera = 1;
            }
        }
                  
        return bandera;
    }
    
    public static int buscarLibro(ArrayList<Integer> libros, int idLibro, Scanner sc)
    {
        int bandera = 0;
        
        for (int i = 0; i < libros.size(); i++)
        {
            if (libros.get(i) == idLibro)
            {
                bandera = 1;
            }
        }
        
        return bandera;
    }
}
