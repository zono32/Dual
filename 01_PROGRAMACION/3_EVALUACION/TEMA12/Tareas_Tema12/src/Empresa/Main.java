package Empresa;

import java.sql.*;
import java.util.Scanner;

import static Empresa.Creacion.crearBase;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Statement sentencia = null;
        Connection conexion = null;

        int op = 0;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mariadb://localhost:3306/?user=root&password=";

        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("No hay ningún driver que reconozca la URL especificada");
        } catch (Exception e) {
            System.out.println("Se ha producido algún otro error");
        }

        try {
            sentencia = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error");
        }

        crearBase(sentencia);

        do {
            menu();
            op= sc.nextInt();

            switch (op) {
                case 0:
                    crearBase(sentencia);
                    break;
                case 1:
                    insertarDepartamento(sentencia);
                    break;
                case 2:
                    insertarEmpleado(sentencia);
                    break;
                case 3:
                    borrarEmpleado(sentencia);
                    break;
                case 4:
                   borrarDepartamento(sentencia);
                    break;
                case 5:
                    consultarEmpleadosPorDepartamento(sentencia);
                    break;
                case 6:
                    consultarDepartamentoPorEmpleado(sentencia);
                    break;
                case 7:
                    modificarSalarioEmpleado(sentencia);
                    break;
                case 8:
                    modificarLocalidadDepartamento(sentencia);
                    break;
                case 9:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Por favor elija una de las opciones del menú");
            }

        } while (op != 9);
    }

    private static void menu(){

        System.out.println("**** MENU ****\n");
        System.out.println("[0] Creación de la base de datos");
        System.out.println("[1] Insertar un nuevo departamento");
        System.out.println("[2] Insertar un nuevo empleado");
        System.out.println("[3] Borrar empleado");
        System.out.println("[4] Borrar departamento");
        System.out.println("[5] Consultar empleados de un departamento");
        System.out.println("[6] Consultar nombre de un departamento y localidad con el dni de un empleado");
        System.out.println("[7] Modificar salario o comisión de un empleado con su DNI");
        System.out.println("[8] Modificar nombre departamento a través de su localidad");
        System.out.println("[9] Salir");
    }

    private static void insertarDepartamento(Statement sentencia) {

        System.out.println("dime nombre del departamento");
        String nombre = sc.next();

        System.out.println("Dime la localidad del departamento");
        String loc = sc.next();


        try {
            sentencia.executeUpdate("INSERT INTO DEPARTAMENTOS (Dnombre, Localidad) VALUES('" + nombre + "','" + loc + "')");
            System.out.println("DEPARTAMENTO CREADO CORRECTAMENTE");

        } catch (SQLException e) {
            System.err.println("Se ha producido un error al insertar");
        }

    }

    public static void insertarEmpleado(Statement sentencia) {

        try {

            System.out.println("Inserción de un nuevo empleado:");

            System.out.println("Introduce el DNI:");
            String dni = sc.next();

            System.out.println("Introduce el nombre:");
            String nombre = sc.next();

            System.out.println("Introduce los estudios:");
            String estudios = sc.next();

            System.out.println("Introduce la dirección:");
            String direccion = sc.next();

            System.out.println("Introduce la fecha de alta(YYYY-MM-DD):");
            String fecha_alta = sc.next();

            System.out.println("Introduce su salario:");
            int salario = sc.nextInt();

            System.out.println("Introduce su comisión:");
            int comision = sc.nextInt();

            System.out.println("Introduce su número del departamento:");
            int num_departamento = sc.nextInt();


            ResultSet rs = sentencia.executeQuery("SELECT * FROM Departamentos WHERE Nu_dept = '" + num_departamento + "'");
            if (!rs.next()) {
                System.out.println("El departamento especificado no existe. Por favor, inserta un número de departamento válido.");
                insertarEmpleado(sentencia);
                return;
            }

            String query = "INSERT INTO Empleados (Dni, Nombre, Estudios, Dir, Fecha_alt, Salario, Comision, Nu_dept) VALUES ('" + dni + "', '" + nombre + "', '" + estudios + "', '" + direccion + "', '" + fecha_alta + "', " + salario + ", " + comision + ", '" + num_departamento + "')";
            sentencia.executeUpdate(query);

            System.out.println("Empleado se ha creado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear el empleado: " + e.getMessage());
        }
    }


    public static void borrarEmpleado(Statement sentencia) {
        System.out.println("Dame DNI del empleado a eliminar");
        String dni = sc.next();
        if (dni != null) {
            try {
                sentencia.execute("DELETE from empresatarea.Empleados where Dni='"+ dni +"';");
                System.out.println("Empleado borrado");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El Empleado no se encuentra en la base de datos");
        }

    }
    public static void borrarDepartamento(Statement sentencia) {
        System.out.println("Dame nombre del departamento a eliminar");
        String nom = sc.next();

        if (nom != null)  {
            try {
                sentencia.execute("DELETE from empresatarea.Departamentos where Dnombre='"+ nom+"';");
                System.out.println("El Departamento se ha borrado");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El Departamento no se encuentra en la base de datos");
        }

    }

    public static void consultarEmpleadosPorDepartamento(Statement sentencia) {
        System.out.print("Introduce el nombre del departamento: ");
        String nombreDept = sc.next();

        try {

            String sql = "SELECT e.Dni, e.Nombre, e.Estudios, e.Dir, e.Fecha_alt, e.Salario, e.Comision, d.Dnombre " +
                    "FROM Empleados e " +
                    "JOIN Departamentos d ON e.Nu_dept = d.Nu_dept " +
                    "WHERE d.Dnombre = '" + nombreDept + "'";

            ResultSet rs = sentencia.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Empleados en el departamento '" + nombreDept + "':");
                do {
                    // Muestra los datos de cada empleado encontrado
                    String dni = rs.getString("Dni");
                    String nombre = rs.getString("Nombre");
                    String estudios = rs.getString("Estudios");
                    String direccion = rs.getString("Dir");
                    String fechaAlt = rs.getString("Fecha_alt");
                    int salario = rs.getInt("Salario");
                    int comision = rs.getInt("Comision");

                    System.out.println("DNI: " + dni);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Estudios: " + estudios);
                    System.out.println("Dirección: " + direccion);
                    System.out.println("Fecha de alta: " + fechaAlt);
                    System.out.println("Salario: " + salario);
                    System.out.println("Comisión: " + comision);
                    System.out.println("-------------------");
                } while (rs.next());
            } else {
                System.out.println("No se encontraron empleados en el departamento '" + nombreDept + "'.");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar empleados del departamento: " + e.getMessage());
        }
    }




    public static void consultarDepartamentoPorEmpleado(Statement sentencia) {
        System.out.print("Introduce el DNI del empleado: ");
        String dniEmpleado = sc.next();

        try {
            String sql = "SELECT d.Dnombre, d.Localidad " +
                    "FROM Empleados e " +
                    "JOIN Departamentos d ON e.Nu_dept = d.Nu_dept " +
                    "WHERE e.Dni = '" + dniEmpleado + "'";

            ResultSet rs = sentencia.executeQuery(sql);

            if (rs.next()) {
                String nombreDept = rs.getString("Dnombre");
                String localidadDept = rs.getString("Localidad");

                System.out.println("El empleado con DNI '" + dniEmpleado + "' pertenece al departamento:");
                System.out.println("Nombre del departamento: " + nombreDept);
                System.out.println("Localidad del departamento: " + localidadDept);
            } else {
                System.out.println("No se encontró ningún empleado con el DNI '" + dniEmpleado + "' o el empleado no está asociado a ningún departamento.");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar departamento por empleado: " + e.getMessage());
        }
    }



    public static void modificarSalarioEmpleado(Statement sentencia) {
        System.out.println("Dame DNI del empleado:");
        String dniEmpleado = sc.next();

        try {

            String consulta = "SELECT * FROM Empleados WHERE Dni = '" + dniEmpleado + "'";
            ResultSet res = sentencia.executeQuery(consulta);

            if (res.next()) {
                System.out.println("¿Desea modificar su salario (s) o su comisión (c)?");
                String respuesta = sc.next();

                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.println("Introduzca su nuevo salario:");
                    int nuevoSalario = sc.nextInt();

                    String consultaActualizacion = "UPDATE Empleados SET Salario = " + nuevoSalario +
                            " WHERE Dni = '" + dniEmpleado + "'";
                    sentencia.executeUpdate(consultaActualizacion);
                    System.out.println("Salario del empleado actualizado correctamente.");

                } else if (respuesta.equalsIgnoreCase("c")) {
                    System.out.println("Introduzca su nueva comisión:");
                    int nuevaComision = sc.nextInt();

                    String consultaActualizacion = "UPDATE Empleados SET Comision = " + nuevaComision +
                            " WHERE Dni = '" + dniEmpleado + "'";
                    sentencia.executeUpdate(consultaActualizacion);
                    System.out.println("Comisión del empleado actualizada correctamente.");

                } else {
                    System.out.println("por favor para modificar el salario introduzca una s \n" +
                            "Si lo que desea modificar es la comisión intoduzca una c \nGracias");
                    modificarSalarioEmpleado(sentencia);
                }

                res.close();

            } else {
                System.out.println("El empleado con DNI '" + dniEmpleado + "' no se encuentra en la base de datos.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar salario o comisión del empleado: " + e.getMessage());
        }
    }

    public static void modificarLocalidadDepartamento(Statement sentencia) {
        System.out.println("Dame el nombre del Departamento para modificar su Localidad:");
        String nombreDepartamento = sc.next();

        try {
            String consulta = "SELECT * FROM Departamentos WHERE Dnombre = '" + nombreDepartamento + "'";
            ResultSet res = sentencia.executeQuery(consulta);

            if (res.next()) {
                System.out.println("Introduzca su nueva Localidad:");
                String nuevaLocalidad = sc.next();

                String consultaActualizacion = "UPDATE Departamentos SET Localidad = '" + nuevaLocalidad + "' " +
                        "WHERE Dnombre = '" + nombreDepartamento + "'";
                sentencia.executeUpdate(consultaActualizacion);
                System.out.println("Localidad del departamento actualizada correctamente.");

                res.close();
            } else {
                System.out.println("El departamento con nombre '" + nombreDepartamento + "' no se encuentra en la base de datos.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar localidad del departamento: " + e.getMessage());
        }
    }

}
