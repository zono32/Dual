package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Borrados {

    public static void borradoD(Statement sentencia, ResultSet res) {
        Scanner scan = new Scanner(System.in);
        int dep;
        try {
            res = sentencia.executeQuery("select * from departamentos;");
            if (res.next()) {
                res = sentencia.executeQuery("select clave_dep,nombre_dep from departamentos;");
                System.out.println();
                System.out.println(String.format("%1$-21s %2$s", "Clave: ", "Nombre: "));
                while (res.next()) {
                    System.out.println(String.format("%1$-21s %2$s", res.getString("clave_dep"), res.getString("nombre_dep")));
                }

                System.out.println("\nIntroduce el departamento a borrar.");
                dep = scan.nextInt();
                if (sentencia.executeQuery("select * from departamentos where clave_dep='" + dep + "';").next()) {
                    sentencia.executeUpdate("delete from departamentos where clave_dep='" + dep + "';");
                    System.out.println("Departamento borrado");
                } else {
                    System.out.println("El departamento introducido no existe");
                }
                System.out.println();
            } else {
                System.out.println("No hay departamentos que borrar\n");
            }
        } catch (SQLException e) {

        }
    }

    public static void borradoEmp(Statement sentencia, ResultSet res) {
        Scanner scan = new Scanner(System.in);
        String dni;
        try {
            res = sentencia.executeQuery("select * from empleados;");
            if (res.next()) {
                res = sentencia.executeQuery("select dni, nombre, fecha_alta, salario, clave_dep from empleados;");
                System.out.println();
                System.out.println(String.format("%1$-10s %2$-17s %3$-15s %4$-10s %5$-10s",
                        "DNI: ", "Nombre: ", "Fecha Alta: ", "Salario: ", "Departamento: "));
                while (res.next()) {
                    System.out.println(String.format("%1$-10s %2$-17s %3$-15s %4$-10s %5$-10s",
                            res.getString(1), res.getString(2), res.getString(3), res.getString(4) + "€", res.getString(5)));
                }

                System.out.println("\nIntroduce el DNI del empleado a borrar.");
                dni = scan.nextLine();
                if (sentencia.executeQuery("select * from empleados where dni='" + dni + "';").next()) {
                    sentencia.executeUpdate("delete from empleados where dni='" + dni + "';");
                    System.out.println("Empleado borrado");
                } else {
                    System.out.println("El empleado introducido no existe");
                }
                System.out.println();
            } else {
                System.out.println("No hay empleados que borrar\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
