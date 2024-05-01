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
        String url = "jdbc:mariadb://localhost:3306/?user=root&password=1234";

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
            op = sc.nextInt();
            sc.nextLine();

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
                default:
                    System.out.println("Por favor elija una de las opciones del menú");
            }

        } while (op != 9);
    }
    private static void insertarDepartamento(Statement sentencia) {
        System.out.println("Dame nombre del departamento");
        String nombre = sc.nextLine();
        System.out.println("Dime la localidad del departamento");
        String loc = sc.nextLine();
        sc = new Scanner(System.in);

        System.out.println("DEPARTAMENTO CREADO CORRECTAMENTE");

        try {
            sentencia.executeUpdate("INSERT INTO DEPARTAMENTO (Dnombre, Localidad) VALUES('" + nombre + "'," + loc + ")");
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al insertar");
        }
    }

    public static void insertarEmpleado(Statement sentencia) {

        try {

            System.out.println("Inserción de un nuevo empleado:");

            System.out.println("Introduce el DNI:");
            String dni = sc.nextLine();

            System.out.println("Introduce el nombre:");
            String nombre = sc.nextLine();

            System.out.println("Introduce los estudios:");
            String estudios = sc.nextLine();

            System.out.println("Introduce la dirección:");
            String direccion = sc.nextLine();

            System.out.println("Introduce la fecha de alta(YYYY-MM-DD):");
            String fecha_alta = sc.nextLine();

            System.out.println("Introduce su salario:");
            int salario = sc.nextInt();

            System.out.println("Introduce su comisión:");
            int comision = sc.nextInt();

            System.out.println("Introduce su número del departamento:");
            String num_departamento = sc.next();

            ResultSet rs = sentencia.executeQuery("SELECT * FROM Departamentos WHERE Nu_dept = '" + num_departamento + "'");
            if (!rs.next()) {
                System.out.println("El departamento especificado no existe. Por favor, inserta un número de departamento válido.");
                return;
            }

            String query = "INSERT INTO Empleados (Dni, Nombre, Estudios, Dir, Fecha_alt, Salario, Comision, Nu_dept) VALUES ('" + dni + "', '" + nombre + "', '" + estudios + "', '" + direccion + "', '" + fecha_alta + "', " + salario + ", " + comision + ", '" + num_departamento + "')";
            sentencia.executeUpdate(query);

            System.out.println("Empleado se ha creado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear el empleado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }


    public static void borrarEmpleado(Statement sentencia) {
        System.out.println("Dame DNI del empleado a eliminar");
        ResultSet res = buscarEmpleado(sentencia);
        if (res != null) {
            try {
                sentencia.execute("DELETE from Empleados where Dni="+ res.getInt("Dni") +";");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El Empleado no se encuentra en la base de datos");
        }

    }
    public static void borrarDepartamento(Statement sentencia) {
        System.out.println("Dame nombre del departamento a eliminar");

        ResultSet res = buscarDepartamento(sentencia);
        if (res != null) {
            try {
                sentencia.execute("DELETE from Departamento where Nu_dep="+ res.getInt("Nu_dep") +";");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El Departamento no se encuentra en la base de datos");
        }

    }
    public static void consultarEmpleadosPorDepartamento(Statement sentencia) {
        System.out.print("Introduce el nombre del departamento: ");
        String nombreDept = sc.nextLine();

        try {

            String sql = "SELECT * FROM Empleados WHERE Nu_dept = (SELECT Nu_dept FROM Departamentos WHERE Dnombre = '" + nombreDept + "')";
            ResultSet rs = sentencia.executeQuery(sql);

            boolean empleadosEncontrados = false;
            while (rs.next()) {
                empleadosEncontrados = true;
                System.out.println("DNI: " + rs.getString("Dni"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Estudios: " + rs.getString("Estudios"));
                System.out.println("Dirección: " + rs.getString("Dir"));
                System.out.println("Fecha de alta: " + rs.getDate("Fecha_alt"));
                System.out.println("Salario: " + rs.getInt("Salario"));
                System.out.println("Comisión: " + rs.getInt("Comision"));
                System.out.println("-----------------------------------------");
            }

            if (!empleadosEncontrados) {
                System.out.println("No se encontraron empleados en el departamento '" + nombreDept + "'.");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar empleados del departamento: " + e.getMessage());
        }
    }
    public static void consultarDepartamentoPorEmpleado(Statement sentencia) {
        System.out.print("Introduce el DNI del empleado: ");
        String dni = sc.nextLine();

        try {
            String sql = "SELECT d.Dnombre, d.Localidad FROM Empleados e JOIN Departamentos d ON e.Nu_dept = d.Nu_dept WHERE e.Dni = '" + dni + "'";
            ResultSet rs = sentencia.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Nombre del departamento: " + rs.getString("Dnombre"));
                System.out.println("Localidad: " + rs.getString("Localidad"));
            } else {
                System.out.println("No se encontró empleado con el DNI: " + dni);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar departamento por empleado: " + e.getMessage());
        }
    }


    public static void modificarSalarioEmpleado(Statement sentencia) {

        System.out.println("Dame DNI del Empeado");
        ResultSet res = buscarEmpleado(sentencia);
        if (res != null) {

            System.out.println("desea modificar su salario (s) o su comisión (c)?");
            String resp = sc.next();

            if(resp.equalsIgnoreCase("s")){
                System.out.println("Introduzca su nuevo salario:");
                int salario = sc.nextInt();
                sc = new Scanner(System.in);
                try {
                    sentencia.executeUpdate("UPDATE Empleados set Salario='" + salario + "', Salario=" + salario +" where Dni = '" + res.getString("Dni") + "';");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (resp.equalsIgnoreCase("c")) {
                System.out.println("Introduzca su nueva comisión:");
                int com = sc.nextInt();
                sc = new Scanner(System.in);
                try {
                    sentencia.executeUpdate("UPDATE Empleados set Comision='" + com + "', Salario=" + com +" where Dni = '" + res.getString("Dni") + "';");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println("por favor para modificar el salario introduzca una s \nSi lo que desea modificar es la comisión intoduzca una c \nGracias");
            }


        } else {
            System.out.println("El Empleado no se encuentra en la base de datos");
        }
    }
    public static void modificarLocalidadDepartamento(Statement sentencia) {

        System.out.println("Dame el nombre del Departamento para modificar su Localidad");
        ResultSet res = buscarDepartamento(sentencia);
        if (res != null) {
            System.out.println("Introduzca su nueva Localidad:");
           String localidad = sc.nextLine();
            sc = new Scanner(System.in);
            try {
                sentencia.executeUpdate("UPDATE Departamento set Localidad='" + localidad + "', localidad=" + localidad +" where Dnombre = '" + res.getString("Dnombre") + "';");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El Departamentop no se encuentra en la base de datos");
        }
    }

    public static ResultSet buscarEmpleado(Statement sentencia) {
        String dni = null;

        try {
            dni = sc.nextLine();

            ResultSet result = sentencia.executeQuery("Select * from Empleados where Dni = '" + dni + "';");

            if (result.next()) {
                System.out.println("Los datos del empleado buscado son: ");

                System.out.println(" DNI: " + result.getString("Dni"));
                System.out.println(" Nombre: " + result.getString("Nombre"));
                System.out.println(" Estudios: " + result.getString("Estudios"));
                System.out.println(" Dirección: " + result.getString("Dir"));
                System.out.println(" Fecha de alta: " + result.getDate("Fecha_alt"));
                System.out.println(" Salario: " + result.getInt("Salario"));
                System.out.println(" Comisión: " + result.getInt("Comisión"));
                System.out.println(" Numero de departamento: " + result.getInt("Nu_dept"));
                System.out.println("-----------------------------------------");

                return result;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public static ResultSet buscarDepartamento(Statement sentencia) {
        int Nu_dep = 0;

        try {
            Nu_dep = sc.nextInt();

            ResultSet result = sentencia.executeQuery("Select * from Departamento where Dnombre = '" + Nu_dep + "';");

            if (result.next()) {
                System.out.println("Los datos del departamento buscado son: ");

                System.out.println(" Número de departamento: " + result.getInt("Nu_dep"));
                System.out.println(" Nombre: " + result.getString("Dnombre"));
                System.out.println(" Localidad: " + result.getString("Localidad"));
                System.out.println("-----------------------------------------");

                return result;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

}
