package Empresa;

import java.sql.SQLException;
import java.sql.Statement;

public class Creacion {

    public static void crearBase(Statement sentencia) {
        try {
            String bd = "empresatarea";

            sentencia.execute("CREATE DATABASE IF NOT EXISTS " + bd + ";");
            sentencia.execute("USE " + bd + ";");

            sentencia.execute("CREATE TABLE IF NOT EXISTS Departamentos ("
                    + "Nu_dept INT AUTO_INCREMENT PRIMARY KEY,"
                    + "Dnombre VARCHAR(10) UNIQUE,"
                    + "Localidad VARCHAR(10));"
            );

            sentencia.execute("CREATE TABLE IF NOT EXISTS Empleados ("
                    + "Dni VARCHAR(9) PRIMARY KEY,"
                    + "Nombre VARCHAR(10),"
                    + "Estudios VARCHAR(10),"
                    + "Dir VARCHAR(10),"
                    + "Fecha_alt DATE,"
                    + "Salario INT,"
                    + "Comision INT,"
                    + "Nu_dept INT,"
                    + "FOREIGN KEY (Nu_dept) REFERENCES Departamentos(Nu_dept));"
            );

            System.out.println("Base de datos Empresa creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }
    }

}
