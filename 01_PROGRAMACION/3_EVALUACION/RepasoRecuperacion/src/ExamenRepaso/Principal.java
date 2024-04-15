package ExamenRepaso;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {


    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Comercial>comerciales = new ArrayList<>();

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
                    System.out.println("Hasta pronto!!!");
                    break;
                default:
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Producto p = null;
        double precio;
        String nombre, categoria;
        System.out.println("-------- Alta productos ---------");
        try{
            System.out.println("Introduzca nombre");
            nombre = sc.nextLine();

            sc = new Scanner(System.in);
            System.out.println("Introduzca precio");

            precio = sc.nextDouble();

            if(precio < 0 ){
                throw new ExcepNumNegativo();
            }

            sc = new Scanner(System.in);
            System.out.println("Introduzca categoría (Comestible/Bazar)");
            categoria = sc.nextLine();

            if (categoria.equalsIgnoreCase("comestible")){
                System.out.println("por favor introduzca la fecha de caducidad con el siguiente formato yyyy-MM-dd");
                LocalDate fechaCaducidad = ValidarFechaCaducidad(sc.nextLine());
                p= new Comestible(nombre, precio, fechaCaducidad);
            }
            if (categoria.equalsIgnoreCase("bazar")){
               String tipo = sc.nextLine();

               p= new Bazar(nombre, precio, tipo);

            }
            else{
                System.out.println("Categoría no válida. Empiece de nuevo");
                altaProducto();
            }

        } catch (InputMismatchException | ExcepNumNegativo e) {
            System.out.println(e.getMessage());
            altaProducto();
        }


        return p;
    }

    private static Comercial altaComercial() {
        Scanner sc = new Scanner(System.in);
        Comercial c;
        int edad;
        String nombre, apellidos, zona;
        System.out.println("-------- Alta comerciales ---------");

        System.out.println("Introduzca nombre");
        nombre = sc.nextLine();

        System.out.println("Introduzca apellidos");
        apellidos = sc.nextLine();

        System.out.println("Introduzca zona");
        zona = sc.nextLine();

        System.out.println("Introduzca edad");
        edad = sc.nextInt();

        return new Comercial(nombre, apellidos, edad, zona, crearRegistroComercial());
    }

    // En el siguiente método, cambiar tipo de dato de retorno al tipo de colección elegida para el registro de los comerciales
    // Los elementos en el registro pueden introducirse manualmente, sin necesidad de solicitarlos por teclado.
    private static HashMap<Integer, Producto> crearRegistroComercial() {
        HashMap<Integer, Producto> reg  = new HashMap<>();
        reg.put(0, new Bazar("Limpieza", 2, "Lejía"));
        reg.put(1, new Comestible( "Pasta", 1.5,LocalDate.of(2024, 04, 10)));
        reg.put(2, new Comestible( "Tomates", 3.8, LocalDate.of(2024, 04, 15)));
        reg.put(3, new Bazar("Mascotas", 10 ,"Pienso gatos"));
        reg.put(4, new Bazar("Menaje", 8.9, "Sartén"));

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

    private static LocalDate ValidarFechaCaducidad( String fechaCaducidad){
        LocalDate fecha = null;

        try{
            fecha =LocalDate.parse(fechaCaducidad);
            LocalDate now = LocalDate.now();

            if(fecha.isBefore(now)){
                throw new ExcepFechaCaducidad("ERROR:El producto está caducado");

            }
        } catch (DateTimeException | ExcepFechaCaducidad e) {
            System.out.println("La fecha introducida es incorrecta. Vuelva a introducir los datos.");;
            altaProducto();
        }


        return fecha;
    }

}







