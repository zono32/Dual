package metodos;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {

    public static int menuP() {
        System.out.println("1.-Insertar filas.\n2.-Borrado de filas.\n3.-Consultas\n4.-Modificaciones.\n0.-Salir.");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public static int submenuIns() {
        System.out.println("1.-Insertar Departamento.\n2.-Insertar Empleados.\n0.-Salir.");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public static int submenuBorrado() {
        System.out.println("1.-Borrar Empleado.\n2.-Borrar Departamento.\n0.-Salir.");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public static int submenuConsultas() {
        System.out.println("1.-Consultar empleados de un departamento."
                + "\n2.-Departamento donde trabaja un empleado.\n0.-Salir.");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
    public static int submenuMod() {
        System.out.println("1.-Modificar salario o comision de un empleado."
                + "\n2.-Modificar localidad.\n0.-Salir.");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
    
    public static int submenuModEmp() {
        System.out.println("1.-Modificar salario."
                + "\n2.-Modificar comision.\n0.-Salir.");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}
