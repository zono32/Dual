package ZZ_EXAMEN;

import java.util.Scanner;

public class Operaciones {

    public static Producto2 recogerDatosProducto(){
        double precio = 0;
        String nombre = "";
        String fechaDeCaducidad = "dd/MM/yyy";
        String tipo;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introducir el precio del producto");
        precio = Validar.validarPrecio(sc.nextDouble());

        System.out.println("Introducir el nombre del producto");
        nombre = sc.next();

        System.out.println("Si el tipo de producto introducido es de la clase comestible pulsa 1 si es de la clase bazar pulsa 2");
        tipo = sc.next();

        Producto2 p = null;
        if( tipo == "1"){

            System.out.println("Introducir su fecha de caducidad con el formato dd/MM/yyyy");
            fechaDeCaducidad = Validar.productoCaducado(sc.nextLine());

             p = new Comestible(precio,nombre,fechaDeCaducidad);
        }
        else{
            System.out.println("De que tipo de producto se trata?");
            tipo = sc.next();
             p = new Bazar(precio,nombre,tipo);
        }
        return p;
    }

    public static Comercial recogerDatosEmpleado(){

        String nombre = "";
        String apellidos = "";
        int edad = 0;
        String zonaAsignada = "";
       do{
           try{
               Scanner sc = new Scanner(System.in);
               System.out.println("Introducir el nombre del comercial ");
               nombre  = sc.next();

               System.out.println("Introducir Los apellidos del comercial ");
               apellidos  = sc.next();

               System.out.println("Introducir la edad del comercial ");
               edad  = sc.nextInt();

               System.out.println("Introducir la zona asignada ");
               zonaAsignada  = sc.next();

               Comercial c = new Comercial(nombre, apellidos, edad, zonaAsignada);

               return c;
           }catch (Exception e) {
               // Manejo de la excepción genérica
               System.out.println("Se ha producido una excepción: " + e.getMessage());
           }

       }while (true);


    }

}
