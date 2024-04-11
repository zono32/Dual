package ExamenRepaso;

import java.text.SimpleDateFormat;
import java.util.*;

public class AlmacenPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            menu();
            opcion= sc.nextInt();

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
        String nombre, categoria;
        System.out.println("-------- Alta productos ---------");

        System.out.println("Introduzca nombre");
        nombre = sc.nextLine();

        sc = new Scanner(System.in);
        System.out.println("Introduzca precio");
        precio = sc.nextDouble();

        sc = new Scanner(System.in);
        System.out.println("Introduzca categoría (Comestible/Bazar)");
        categoria = sc.nextLine();

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

        Hashmap<Integer,Producto> x = crearRegistroComercial();
        Comercial comercial = new Comercial(nombre, apellidos, edad, zona);
        comercial.setRegistro(x);
        return comercial;
    }

    // En el siguiente método, cambiar tipo de dato de retorno al tipo de colección elegida para el registro de los comerciales
    // Los elementos en el registro pueden introducirse manualmente, sin necesidad de solicitarlos por teclado.
    private static Hashmap<Integer,Producto> crearRegistroComercial() {
        Hashmap<Integer,Producto> reg ;
        reg.put(.....);
        reg.put(.....);

   //     return reg;
    //}

    private static void eliminarProductosLimpieza() {
    }

    private static void especialidadComerciales() {
    }

    private static void costeProductos() {
    }

    private static void productosCaducidadProxima() {
    }
}