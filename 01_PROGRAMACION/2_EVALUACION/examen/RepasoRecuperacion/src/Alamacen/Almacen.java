package Alamacen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Almacen {

    public static ArrayList<Producto>productos = new ArrayList<>();
    public static  ArrayList<Comercial>comerciales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            menu();
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    productos.add(altaProducto());
                    break;
                case 2:
                    comerciales.add(altaComercial());
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
                    System.out.println("elija la opción adecuada");
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

        Producto p = null;
        double precio ;
        String nombre, categoria;
        System.out.println("-------- Alta productos ---------");

        try{
            System.out.println("Introduzca nombre");
            nombre = sc.nextLine();

            sc = new Scanner(System.in);
            System.out.println("Introduzca precio");
            precio = sc.nextDouble();
            if( precio< 0){
                throw new ExcepNumNeg("ERROR: por favor introduzca un precio valido");
            }

            sc = new Scanner(System.in);
            System.out.println("Introduzca categoría (C - Comestible/ B - Bazar)");
            categoria = sc.nextLine();
            if(categoria.equalsIgnoreCase("c")){
                System.out.println("por favor introduzca la fecha de caducidad con el siguiente formato dd/MM/yyyy ");
                LocalDate fechaCaducidad = fechaCaducidad(sc.next());

                p = new Comestible(nombre,precio,fechaCaducidad);

            } else if (categoria.equalsIgnoreCase("b")) {
                System.out.println("introduzca el tipo de producto");
                String tipo = sc.next();

                p = new Bazar(nombre, precio, tipo);
            }

        }catch (InputMismatchException |ExcepNumNeg e){
            System.out.println(e.getMessage());
            altaProducto();
        }
        return p;
    }

    private static Comercial altaComercial() {
        Scanner sc = new Scanner(System.in);

        int edad =0;
        String nombre ="", apellidos="", zona ="";
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

        }catch ( InputMismatchException e){
            System.out.println("alguno de los datos no es válido");
            altaComercial();
        }
        return new Comercial(nombre, apellidos, edad, zona, crearRegistroComercial());
    }

    // En el siguiente método, cambiar tipo de dato de retorno al tipo de colección elegida para el registro de los comerciales
    // Los elementos en el registro pueden introducirse manualmente, sin necesidad de solicitarlos por teclado.
    private static HashMap<Integer, Producto> crearRegistroComercial() {
        HashMap<Integer, Producto> reg = null;

        reg.put(0, new Bazar("legia" ,2.78, "limpieza"));
        reg.put(1, new Comestible("manzana", 1.5,  LocalDate.of(2024,04,25)));

        return reg;
    }

    private static void eliminarProductosLimpieza() {

        productos.removeIf( p-> p instanceof Bazar && ((Bazar)p).getTipo().equalsIgnoreCase("limpieza"));
    }

    private static void especialidadComerciales() {
    }

    private static void costeProductos() {


    }

    private static void productosCaducidadProxima() {
    }


    public static LocalDate fechaCaducidad(String fecha) {


        LocalDate fechaCaducidad = null;
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaCaducidad = LocalDate.parse(fecha, dtf);

            LocalDate ahora = LocalDate.now();
            if (fechaCaducidad.isBefore(ahora)) {
                throw new EscepProdCaducado("Producto caducado");
            }

        } catch (DateTimeParseException | EscepProdCaducado e) {
            System.out.println(e.getMessage());
            altaProducto();
        }
        return fechaCaducidad;
    }
}
