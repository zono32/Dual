/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nuria16
 */
public class Conexion {

    public static String getUrlConexion(int tipoBD) {
        switch (tipoBD) {
            case 1:
                return "jdbc:mysql://localhost:3307/?user=root&password=usbw";
            case 2:
                return "jdbc:sqlite:C://SQLite/empleadosDepartamentos.db";
            case 3:
                return "jdbc:h2:C://H2/empleadosDepartamentos";
            case 4:
                return "jdbc:hsqldb:file:C://HSQLDB/empleadosDepartamentos";
        }
        return null;
    }

    public static int menuConexion() {
        int tipoBD = 0;

        do {
            try {
                System.out.println("Seleccione el tipo de BD que desea utilizar:\n 1.MySQL\n2.SQLite\n3.H2\n4.HSQLDB");
                tipoBD = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opción incorrecta");
            }
        } while (tipoBD < 1 || tipoBD > 4);
        
        return tipoBD;
    }
}
