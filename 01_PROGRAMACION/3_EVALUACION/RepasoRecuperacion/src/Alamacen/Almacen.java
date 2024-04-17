package Alamacen;

import ExamenRepaso.ExcepFechaCaducidad;

import java.nio.channels.ClosedChannelException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Almacen {

    public static ArrayList<Comercial> comerciales = new ArrayList<>();
    public static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            menu();
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    altaProducto();
                    break;
                case 2:
                    altaComercial();
                    break;
                case 3:
                    eliminarProductosLimpieza();
                    break;
                case 4:
                    especialidadComerciales();
                    break;
                case 5:
                    costeProductos();
                    break;
                case 6:
                    productosCaducidadProxima();
                    break;
                case 7:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Por favor elija una opción correcta");
                    break;
            }

        }
        while (opcion != 7);
    }

    private static void menu() {
        //Encabezado
        System.out.println("--------------------");
        System.out.println("Menú de Almacen");
        System.out.println("--------------------");

        System.out.println("Seleccione lo que desea realizar:");
        System.out.println("1: Alta productos");
        System.out.println("2: Alta comerciales");
        System.out.println("3: Eliminar productos de Limpieza");
        System.out.println("4: Mostrar especialidades de los comerciales");
        System.out.println("5: Coste medio de comestibles");
        System.out.println("6: Productos de caducidad próxima");
        System.out.println("7: Salir");
    }

    private static Producto altaProducto() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Producto p =null;
        double precio;
        String nombre, categoria;
        System.out.println("-------- Alta productos ---------");
        try {
            System.out.println("Introduzca nombre");
            nombre = sc.nextLine();

            sc = new Scanner(System.in);
            System.out.println("Introduzca precio");
            precio = sc.nextDouble();
            if(precio < 0){
                throw new ExcepNumeroNegativo("ERROR: por favor introduzca un precio válido");
            }

            sc = new Scanner(System.in);
            System.out.println("Introduzca categoría (Comestible/Bazar)");
            categoria = sc.nextLine();

            if(categoria.equalsIgnoreCase("comestible")){
                System.out.println("por favor introduzca la fecha de caducidad del producto con el siguiente formato: dd/MM/yyyy");
                LocalDate fechaCaducidad= comprobarFecha(sc.next());
                //LocalDate fechaCaducidad = LocalDate.parse(fechaCad,dtf);

                p = new Comestible(nombre,precio,fechaCaducidad);

            } else if (categoria.equalsIgnoreCase("bazar")) {
                System.out.println("por favor introduzca el tipo de producto ");
                String tipo = sc.next();
                p = new Bazar(nombre,precio,tipo);
            } else {
                System.err.println("Categoría no válida. Empiece de nuevo");
                altaProducto();
            }

        }catch (InputMismatchException | ExcepNumeroNegativo e ) {
            System.out.println( e.getMessage());
        }

        return p;
    }

    private static Comercial altaComercial() {
        Scanner sc = new Scanner(System.in);
        int edad = 0;
        String nombre="", apellidos ="", zona ="";
        System.out.println("-------- Alta comerciales ---------");

        try{
            System.out.println("Introduzca nombre");
            nombre = sc.nextLine();

            System.out.println("Introduzca apellidos");
            apellidos = sc.nextLine();

            System.out.println("Introduzca zona");
            zona = sc.nextLine();

            System.out.println("Introduzca edad");
            edad = sc.nextInt();

        }catch (InputMismatchException e){
            System.out.println("algun dato es incorrecto");
            altaComercial();
        }
        return new Comercial(nombre, apellidos, edad, zona, crearRegistroComercial());
    }

    // En el siguiente método, cambiar tipo de dato de retorno al tipo de colección elegida para el registro de los comerciales
    // Los elementos en el registro pueden introducirse manualmente, sin necesidad de solicitarlos por teclado.
    private static HashMap<Integer, Producto> crearRegistroComercial() {
        HashMap<Integer, Producto> reg = new HashMap<>();
        //reg.put(0,Manzana,);
        //reg.put();

        return reg;
    }

    private static void eliminarProductosLimpieza() {

        productos.removeIf(p -> p instanceof Bazar && ((Bazar)p).getTipo().equalsIgnoreCase("limpieza"));
    }

    private static void especialidadComerciales() {
    }

    private static void costeProductos() {
    }

    private static void productosCaducidadProxima() {
    }

    public static LocalDate comprobarFecha( String fecha){
        LocalDate fechacaducidad = null;
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechacaducidad = LocalDate.parse(fecha,dtf);

            LocalDate ahora = LocalDate.now();
            if(fechacaducidad.isBefore(ahora)){
                throw new ExcepFechaCaducidad("ERROR: el producto está caducado");
            }
            return fechacaducidad;
        } catch (DateTimeParseException | ExcepFechaCaducidad e) {
            System.out.println(e.getMessage());
            altaProducto();
        }
        return fechacaducidad;
    }

}
