package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inserciones {

    public static void insertarDep(Statement sentencia) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre del departamento");
        String nombre = scan.nextLine();
        System.out.println("Introduce la localidad del departamento");
        String localidad = scan.nextLine();
        try {
            sentencia.executeUpdate("insert into departamentos (nombre_dep,localidad) "
                    + "values('" + nombre + "','" + localidad + "');");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void insertarEmp(Statement sentencia) {
        ResultSet res;
        String dni, nombre, estudios, direccion, fecha;
        int errorDNI, num_dep, error;
        float salario, comision;
        char confirmar = 's';
        Scanner scan = new Scanner(System.in);
        try {
            res = sentencia.executeQuery("select * from departamentos;");
            if (res.next()) {
                do {
                    System.out.println("Introduce el DNI del empleado.");
                    dni = scan.nextLine().toUpperCase();

                    if (sentencia.executeQuery("select * from empleados where dni='" + dni + "';").next()) {
                        System.out.println("El DNI ya existe en la base de datos");
                        errorDNI = 2;
                        System.out.println("Desea introducir un nuevo DNI [s/n]?");
                        confirmar = scan.nextLine().toLowerCase().charAt(0);
                    }
                } while (confirmar == 's');
                if (confirmar != 'n') {
                    System.out.println("Introduce el nombre del empleado.");
                    nombre = scan.nextLine();
                    System.out.println("Introduce los estudios del empleado.");
                    estudios = scan.nextLine();
                    System.out.println("Introduce la direccion del empleado.");
                    direccion = scan.nextLine();
                    System.out.println("Introduce la fecha de alta yyyy-mm-dd.");
                    fecha = scan.nextLine();
                    System.out.println("Introduce el salario del empleado.");
                    salario = scan.nextFloat();
                    scan.nextLine();
                    System.out.println("Introduce la comision.");
                    comision = scan.nextFloat();
                    res = sentencia.executeQuery("select clave_dep,nombre_dep from departamentos;");
                    System.out.println(String.format("%1$-32s %2$s", "Clave: ", "Nombre: "));
                    while (res.next()) {
                        System.out.println(String.format("%1$-32s %2$s", res.getString("clave_dep"), res.getString("nombre_dep")));
                    }
                    do {
                        error = 0;
                        System.out.println("Introduce la clave del departamento.");
                        num_dep = scan.nextInt();
                        res = sentencia.executeQuery("select * from departamentos where clave_dep='" + num_dep + "';");
                        if (!res.next()) {
                            error = 1;
                            System.out.println("El departamento introducido no existe, vuelva a introducirlo");
                        }
                    } while (error != 0);
                    sentencia.executeUpdate("insert into empleados "
                            + "(dni,nombre,estudios,direccion,fecha_alta,salario,comision,clave_dep) "
                            + "values ('" + dni + "','" + nombre + "','" + estudios + "','" + direccion + "','" + fecha + "',"
                            + "'" + salario + "','" + comision + "','" + num_dep + "');");
                }
            } else {
                System.out.println("Todavia no hay departamentos.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
