package Metodos;

import java.sql.*;

public class Crear 
{

    public static void crearBase(Statement sentencia)
    {
        try
        {
            String bd = "AutoresLibrosBD";
        
            sentencia.execute("CREATE DATABASE IF NOT EXISTS " + bd + ";");
            sentencia.execute("USE "+ bd +";");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS AUTORES"
                    + "(dni char(9) not null,"
                    + "nombre VARCHAR(30) not null,"
                    + "nacionalidad VARCHAR(30) not null,"
                    + "Primary Key (dni))"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS LIBROS"
                    + "(idLibro INT(5) unsigned zerofill not null auto_increment,"
                    + "titulo VARCHAR(30) not null,"
                    + "precio float not null,"
                    + "autor char(9) not null,"
                    + "Primary Key (idLibro),"
                    + "Foreign key (autor) references AUTORES(dni)"
                    + " on delete cascade "
                    + "on update cascade)"
                    + "ENGINE INNODB;");
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
    
}
