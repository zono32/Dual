package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Consultas {

    public static void empleadosDep(Statement sentencia, ResultSet res) {
        Scanner scan = new Scanner(System.in);
        String nombre;
        try {
            if (sentencia.executeQuery("select * from departamentos;").next()) {
                res = sentencia.executeQuery("select nombre_dep from departamentos;");
                System.out.println("Nombre:");
                while (res.next()) {
                    System.out.println(res.getString(1));
                }
                System.out.println("Introduce el nombre del departamento a consultar");
                nombre = scan.nextLine();
                if (sentencia.executeQuery("select * from departamentos where nombre_dep='" + nombre + "';").next()) {
                    res = sentencia.executeQuery("select nombre, estudios, direccion, salario, comision  from empleados where clave_dep ="
                            + "(select clave_dep from departamentos where nombre_dep='" + nombre + "');");
                    System.out.println("\nEmpleados del departamento de " + nombre);
                    System.out.println(String.format("%1$-17s %2$-17s %3$-15s %4$-10s %5$-10s",
                            "Nombre: ", "Estudios: ", "Direccion: ", "Salario: ", "Comision: "));
                    while (res.next()) {
                        System.out.println(String.format("%1$-17s %2$-17s %3$-15s %4$-10s %5$-10s",
                                res.getString(1), res.getString(2), res.getString(3), res.getString(4) + "€", res.getString(5) + "%"));
                    }
                    System.out.println();
                } else {
                    System.out.println("No hay departamentos con ese nombre");
                }

            } else {
                System.out.println("No hay ningun departamento");
            }

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public static void consultarEmp(Statement sentencia, ResultSet res) {
        Scanner scan = new Scanner(System.in);
        String dni;
        try {
            if (sentencia.executeQuery("select * from empleados;").next()) {
                res = sentencia.executeQuery("select dni,nombre from empleados;");
                System.out.println(String.format("%1$-11s %2$s", "DNI: ", "Nombre: "));
                while (res.next()) {
                    System.out.println(String.format("%1$-11s %2$s", res.getString(1), res.getString(2)));
                }
                System.out.println("Introduce el DNI del empleado para visualizar su departamento");
                dni = scan.nextLine().toUpperCase();
                if (sentencia.executeQuery("select * from empleados where dni='" + dni + "';").next()) {
                    res = sentencia.executeQuery("select nombre_dep,localidad from departamentos "
                            + "where clave_dep=(select clave_dep from empleados where dni='" + dni + "');");
                    res.next();
                    System.out.println("\nDepartamento:\nNombre: " + res.getString("nombre_dep")
                            + "\t\tLocalidad: " + res.getString("localidad"));
                    
                } else {
                    System.out.println("El DNI introducido no se corresponde con ningún empleado");
                }
            } else {
                System.out.println("No hay empleados");
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }
}
