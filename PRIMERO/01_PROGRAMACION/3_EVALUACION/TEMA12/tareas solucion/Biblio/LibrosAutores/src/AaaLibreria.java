

import java.util.*;
import java.sql.*;
import Metodos.*;

public class AaaLibreria 
{

    public static void main(String[] args)
    {
        Statement sentencia = null;
        Connection conexion = null;
        
        Scanner sc = new Scanner (System.in);
        
        int op = 0;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
                
        //String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mariadb://localhost:3306/?user=root&password=1234";
                
        try
        {
            conexion = DriverManager.getConnection(url);
        }
        catch(SQLException e)
        {
            System.out.println("No hay ningún driver que reconozca la URL especificada");
        }
        catch(Exception e)
        {
            System.out.println("Se ha producido algún otro error");
        }
        
        try
        {
            sentencia = conexion.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println("Error");
        }
        
        Crear.crearBase(sentencia);
        
        do
        {
            
            op = Menu.menuMain(sc);
            
            switch(op)
            {
                case 1:
                    Insertar.mainInsertar(sentencia,sc);
                break;
                
                case 2:
                    Borrar.mainBorrar(sentencia,sc);
                break;
                
                case 3:
                    Modificar.mainModificar(sentencia,sc);
                break;
                
                case 4:
                    Consultas.mainConsultas(sentencia,sc);
                break;
            }
            
        }while(op != 5);
        
    }

}
