package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Modificaciones {

    public static void modificarEmp(Statement sentencia, ResultSet res) {
        Scanner scan = new Scanner(System.in);
        String dni;
        int opcion;
        try {
            if (sentencia.executeQuery("select * from empleados;").next()) {
                res = sentencia.executeQuery("select dni,nombre from empleados;");
                System.out.println(String.format("%1$-11s %2$s", "DNI: ", "Nombre: "));
                while (res.next()) {
                    System.out.println(String.format("%1$-11s %2$s", res.getString(1), res.getString(2)));
                }
                System.out.println("Introduce el DNI del empleado a modificar");
                dni = scan.nextLine().toUpperCase();
                if (sentencia.executeQuery("select * from empleados where dni='" + dni + "';").next()) {
                    do {
                        opcion = Menus.submenuModEmp();
                        switch (opcion) {
                            case 0:
                                break;
                            case 1:
                                modificarSalario(sentencia, res, dni);
                                break;
                            case 2:
                                modificarComision(sentencia, res, dni);
                                break;
                            case -1:
                                System.out.println("Error debe introducir un numero");
                                break;
                            default:
                                System.out.println("Error las opciones van de 0-2");
                                break;

                        }
                    } while (opcion != 0);
                }
            } else {
                System.out.println("No hay empleados");
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public static void modificarSalario(Statement sentencia, ResultSet res, String dni) {
        Scanner scan = new Scanner(System.in);
        float salario;
        char confirmar;
        try {
            res = sentencia.executeQuery("select salario from empleados where dni='" + dni + "';");
            res.next();
            System.out.println("Salario actual: " + res.getString(1) + "€");
            System.out.println("Introduce el nuevo salario");
            salario = scan.nextFloat();
            scan.nextLine();
            System.out.println("Esta seguro de que quiere modificar el salario?[s/n]");
            confirmar = scan.nextLine().toLowerCase().charAt(0);
            if (confirmar == 's') {
                sentencia.executeUpdate("update empleados set salario='" + salario + "' where dni='" + dni + "';");
                System.out.println("Salario modificado");
            } else {
                System.out.println("El salario no ha sido modificado");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public static void modificarComision(Statement sentencia, ResultSet res, String dni) {
        Scanner scan = new Scanner(System.in);
        float comision;
        char confirmar;
        try {
            res = sentencia.executeQuery("select comision from empleados where dni='" + dni + "';");
            res.next();
            System.out.println("Comision actual: " + res.getString(1) + "%");
            System.out.println("Introduce la nueva comision");
            comision = scan.nextFloat();
            scan.nextLine();
            System.out.println("Esta seguro de que quiere modificar la comision?[s/n]");
            confirmar = scan.nextLine().toLowerCase().charAt(0);
            if (confirmar == 's') {
                sentencia.executeUpdate("update empleados set comision='" + comision + "' where dni='" + dni + "';");
                System.out.println("Comision modificada");
            } else {
                System.out.println("La comision no ha sido modificada");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public static void modificarDep(Statement sentencia, ResultSet res) {
        Scanner scan = new Scanner(System.in);
        String nombre;
        String localidad;
        char confirmar;
        try {
            if (sentencia.executeQuery("select * from departamentos;").next()) {
                res = sentencia.executeQuery("select nombre_dep from departamentos;");
                System.out.println("Nombre:");
                while (res.next()) {
                    System.out.println(res.getString(1));
                }
                System.out.println("Introduce el nombre del departamento a modificar");
                nombre = scan.nextLine();
                res = sentencia.executeQuery("select localidad from departamentos where nombre_dep='" + nombre + "';");
                if (res.next()) {
                    System.out.println("Localidad actual: " + res.getString(1));
                    System.out.println("Introduce la nueva localidad.");
                    localidad = scan.nextLine();
                    System.out.println("Esta seguro de que quiere modificar la localidad?[s/n]");
                    confirmar = scan.nextLine().toLowerCase().charAt(0);
                    if (confirmar == 's') {
                        sentencia.executeUpdate("update departamentos set localidad='"
                                + localidad + "' where nombre_dep='" + nombre + "';");
                        System.out.println("Localidad modificada");
                    } else {
                        System.out.println("La localidad no ha sido modificada");
                    }
                } else {
                    System.out.println("No hay departamentos con ese nombre.");
                }
            } else {
                System.out.println("No hay departamentos");
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }
}
