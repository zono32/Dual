package ejempleadosdepartamentos;

import metodos.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjEmpleadosDepartamentos {

    static Statement sentencia;
    static ResultSet res;
    static Connection con;

    public static void main(String[] args) {
        int tipoBD = Conexion.menuConexion();
        try {
            con = DriverManager.getConnection(Conexion.getUrlConexion(tipoBD));
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }
        try {
            sentencia = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(2);
        }
        Creacion.crear(tipoBD, sentencia);
        if (tipoBD == 1) {
            try {
                sentencia.execute("use empleadosdepartamentos;");
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        int opcion, opcionsub;
        do {
            opcion = Menus.menuP();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    do {
                        opcionsub = Menus.submenuIns();
                        switch (opcionsub) {
                            case 0:
                                break;
                            case 1:
                                Inserciones.insertarDep(sentencia);
                                break;
                            case 2:
                                Inserciones.insertarEmp(sentencia);
                                break;
                            case -1:
                                System.out.println("Error debe introducir un numero");
                                break;
                            default:
                                System.out.println("Error las opciones van de 0-2");
                                break;
                        }
                    } while (opcionsub != 0);
                    break;
                case 2:
                    do {
                        opcionsub = Menus.submenuBorrado();
                        switch (opcionsub) {
                            case 0:
                                break;
                            case 1:
                                Borrados.borradoEmp(sentencia, res);
                                break;
                            case 2:
                                Borrados.borradoD(sentencia, res);
                                break;
                            case -1:
                                System.out.println("Error debe introducir un numero");
                                break;
                            default:
                                System.out.println("Error las opciones van de 0-2");
                                break;
                        }
                    } while (opcionsub != 0);
                    break;
                case 3:
                    do {
                        opcionsub = Menus.submenuConsultas();
                        switch (opcionsub) {
                            case 0:
                                break;
                            case 1:
                                Consultas.empleadosDep(sentencia, res);
                                break;
                            case 2:
                                Consultas.consultarEmp(sentencia, res);
                                break;
                            case -1:
                                System.out.println("Error debe introducir un numero");
                                break;
                            default:
                                System.out.println("Error las opciones van de 0-2");
                                break;
                        }
                    } while (opcionsub != 0);

                    break;
                case 4:
                    do {
                        opcionsub = Menus.submenuMod();
                        switch (opcionsub) {
                            case 0:
                                break;
                            case 1:
                                Modificaciones.modificarEmp(sentencia, res);
                                break;
                            case 2:
                                Modificaciones.modificarDep(sentencia, res);
                                break;
                            case -1:
                                System.out.println("Error debe introducir un numero");
                                break;
                            default:
                                System.out.println("Error las opciones van de 0-2");
                                break;
                        }
                    } while (opcionsub != 0);
                    break;
                case -1:
                    System.out.println("Error debe introducir un numero");
                    break;
                default:
                    System.out.println("Error las opciones van de 0-4");
                    break;
            }
        } while (opcion != 0);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(4);
        }
    }

}
