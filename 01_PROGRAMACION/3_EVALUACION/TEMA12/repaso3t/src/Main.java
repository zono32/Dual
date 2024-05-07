import java.sql.*;

public class Main {



    public static void main(String[] args) {

        Statement sentencia = null;
        Connection conexion = null;


        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mariadb://localhost:3006/?user=root&password=";

        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            sentencia = conexion.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Creacion.crearbd(sentencia);

    }
}