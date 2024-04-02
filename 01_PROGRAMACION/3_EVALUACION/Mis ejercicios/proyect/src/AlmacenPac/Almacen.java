package AlmacenPac;

import AlmacenPac.AlmacenComercial.Comercial;
import AlmacenPac.AlmacenProductos.Bazar;
import AlmacenPac.AlmacenProductos.Comestible;
import AlmacenPac.AlmacenProductos.Producto;
import AlmacenPac.Excepciones.ExceepcionNumeroNegativo;
import AlmacenPac.Utils.Util;

import java.text.SimpleDateFormat;
import java.util.*;

public class Almacen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Producto>productos=new ArrayList<>();
        ArrayList<Comercial>comerciales =new ArrayList<>();

        int opcion;

        do {

            menu();
            opcion = sc.nextInt();

            switch (opcion){

                case 1:
                    Producto producto = altaProducto();
                    productos.add(producto);
                    break;
                case 2:
                    Comercial comercial  = altaComercial();
                    comerciales.add(comercial);
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
                default:
                    System.out.println("escoge una opción válida");;
                    break;
            }

        }
        while (opcion != 7);
    }

    private static void menu() {
        //Encabezado
        System.out.println("--------------------");
        System.out.println("MenÃº de Almacen");
        System.out.println("--------------------");

        System.out.println("Seleccione lo que desea realizar:");
        System.out.println("1: Alta productos");
        System.out.println("2: Alta comerciales");
        System.out.println("3: Eliminar productos de Limpieza");
        System.out.println("4: Mostrar especialidades de los comerciales");
        System.out.println("5: Coste medio de comestibles");
        System.out.println("6: Productos de caducidad prÃ³xima");
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
        nombre = sc.next();

        System.out.println("Introduzca precio");
        precio = Util.validarPrecio();

        System.out.println("Introduzca categoría (Comestible/Bazar)");
        categoria = sc.next();

        if( categoria.equalsIgnoreCase("C") ){
            System.out.println("por favor indique la caducidad del producto");
            String  fechaCaducidad = Util.validarFecha(sc.next());
            p= new Comestible(precio,nombre,fechaCaducidad);
        }else{
            System.out.println("Por favor indique el tipo de producto");
            String  tipo = sc.next();
            p= new Bazar(precio,nombre,tipo);
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

        return new Comercial(nombre, apellidos, edad, zona);//, crearRegistroComercial());
    }
    /*
        // En el siguiente mÃ©todo, cambiar tipo de dato de retorno al tipo de colecciÃ³n elegida para el registro de los comerciales
        // Los elementos en el registro pueden introducirse manualmente, sin necesidad de solicitarlos por teclado.
        private static Collection<> crearRegistroComercial() {
            Collection<> reg ;
            reg.add(.....);
            reg.add(.....);

            return reg;
        }
    */
    private static void eliminarProductosLimpieza() {}

    private static void especialidadComerciales() {}

    private static void costeProductos() {}

    private static void productosCaducidadProxima() {}
}
