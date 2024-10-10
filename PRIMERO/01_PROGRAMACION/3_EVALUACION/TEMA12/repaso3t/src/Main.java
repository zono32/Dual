import java.sql.*;
import java.util.Scanner;

public class Main {

static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

      Statement sentencia = null;
      Connection conexion = null;

        try {
            Class.forName("ogr.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jbdc:mariadb://localhodt:3006/?user=root&password=";

        try {
            conexion =DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            sentencia =conexion.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Creacion.crearbd(sentencia);

        int op =0;

        do {
            menu();
            op = sc.nextInt();
            switch (op){

                case 1:
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        }while (op != 2);


    }

    public static void menu(){

    }

    public static  void nuevoitem(Statement sentencia){

        System.out.println("dame el primer dato");
        String dato1 = sc.next();
        System.out.println("dame el segundo dato");
        String dato2 = sc.next();

        try {
            sentencia.executeUpdate("INSERT INTO TABLE1 (DATO1,DATO2)VALUES('"+dato1+"','"+dato2+"')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static  void creaotro(Statement sentencia){
        System.out.println("dame el primer dato");
        String dato1 = sc.next();
        System.out.println("dame el segundo dato");
        String dato2 = sc.next();

       //dato1 es el id del obj de la tabla1 dato2 el nombre

        try {
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM TABLA1 WHERE dato2 = '"+dato2+"' ");
            if(resultado.next()){
                String id = resultado.getString("dato1");
                sentencia.executeUpdate("INSERT INTO TABLE2 VALUES('"+dato1+"','"+dato2+"')");
                System.out.println("se ha creado correctamente");
            }else{
                System.out.println("dato tabla1 no existe");
            }

        } catch (SQLException e) {
            System.out.println("error al intoducir los datos");
            e.printStackTrace();
        }

    }





}