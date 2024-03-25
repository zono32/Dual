package ExamenSegundaEva;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.*;
import java.util.Scanner;

public class Almacen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Comercial> comerciales = new ArrayList<>();


        int opcion = 0;

        do {
            menu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    productos.add(altaProducto());
                    break;
                case 2:
                    comerciales.add(altaComercial());
                case 3:
                    eliminarProductosLimpieza();
                    break;
                case 4:
                    especialidadComerciales();
                    break;
                case 5:
                    costeProductos();
                case 6:
                    productosCaducidadProxima();
                    break;
                default:
                    System.out.println("por favor selecciona una opción correcta");
                    break;
            }

        }while (opcion != 7) ;
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

        double precio;
        String nombre, categoria;
        System.out.println("-------- Alta productos ---------");

        System.out.println("Introduzca nombre");
        nombre = Validacion.validarNombre(sc.next());

        System.out.println("Introduzca precio");
        precio = Validacion.validarPrecio(sc.nextDouble());

        System.out.println("Introduzca categoría (Comestible C /Bazar B)");
        categoria = Validacion.opcionComestibleBazar(sc.next());

        Producto p = new Producto(precio,nombre,categoria);

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

        return new Comercial(nombre, apellidos, edad, zona);//, crearRegistroComercial());
    }

    // En el siguiente método, cambiar tipo de dato de retorno al tipo de colección elegida para el registro de los comerciales
    // Los elementos en el registro pueden introducirse manualmente, sin necesidad de solicitarlos por teclado.

    /*
    private static Collection<> crearRegistroComercial() {
       Collection<> reg ;
        reg.add(.....);
        reg.add(.....);

        return reg;
    }*/

    private static void eliminarProductosLimpieza() {
    }

    private static void especialidadComerciales() {
    }

    private static void costeProductos() {
    }

    private static void productosCaducidadProxima() {
    }
}

