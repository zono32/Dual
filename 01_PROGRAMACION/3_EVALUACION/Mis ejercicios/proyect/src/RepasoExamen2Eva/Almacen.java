package RepasoExamen2Eva;

import RepasoExamen2Eva.Empleados.Comercial;
import RepasoExamen2Eva.Products.Bazar;
import RepasoExamen2Eva.Products.Comestible;
import RepasoExamen2Eva.Products.Producto;
import RepasoExamen2Eva.Utils.Operacion;
import RepasoExamen2Eva.Utils.Validacion;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Almacen {

    static ArrayList<Producto>productos = new ArrayList<>();
    static ArrayList<Comercial>comerciales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto []comestibles = new Producto[3];
        Producto []bazar = new Producto[3];


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
                    System.out.println("hasta pronto");
                    break;
                default:
                    System.out.println("Por favor escoja una opción correcta");
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
        Producto p;
        double precio;
        String nombre, categoria, tipo;
        System.out.println("-------- Alta productos ---------");

        System.out.println("Introduzca nombre");
        nombre = sc.next();

        sc = new Scanner(System.in);
        System.out.println("Introduzca precio");
        precio = Operacion.devuelvePrecioValidado(sc.nextDouble());

        sc = new Scanner(System.in);
        System.out.println("Introduzca categoría (Comestible/Bazar)");
        categoria = sc.next();

        if(categoria.equalsIgnoreCase("Bazar")){
            System.out.println("Introduzca el tipo de producto");
            tipo = sc.next();
            p = new Bazar(precio, nombre, tipo);

        }else{
            System.out.println("Introduzca la fecha de caducidad con el siguiente formato por favor dd-MM-yyyy ");
            String fechaString = sc.next();
            LocalDate fechaCaducidad = Operacion.devuelveFechaCorrecta(fechaString);
            p = new Comestible(precio, nombre, fechaCaducidad);
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

        return new Comercial(nombre, apellidos, edad, zona, crearRegistroComercial( new Producto[6]));
    }

    // En el siguiente método, cambiar tipo de dato de retorno al tipo de colección elegida para el registro de los comerciales
    // Los elementos en el registro pueden introducirse manualmente, sin necesidad de solicitarlos por teclado.
    private static HashMap<Integer, Producto> crearRegistroComercial( Producto[] productos) {
       HashMap<Integer,Producto> productosHashMap = new HashMap<>();
        int cont = 0;
       for (Producto p : productos){
         cont++;
           productosHashMap.put(cont, p);
       }
        return productosHashMap;
    }

    private static void eliminarProductosLimpieza() {

        ArrayList<Producto> eliminarProducto = new ArrayList<>();

        for (int index = 0; index < productos.size() ; index++) {
            if(productos.get(index) instanceof Bazar){
                Bazar productoEliminar = (Bazar) productos.get(index);
                if( productoEliminar.getTipo().equalsIgnoreCase("limpieza") ){
                    eliminarProducto.add(productoEliminar);
                }
            }
        }
        productos.removeAll(eliminarProducto);
    }

    private static void especialidadComerciales() {
    }

    private static void costeProductos() {
    }

    private static void productosCaducidadProxima() {
    }
}