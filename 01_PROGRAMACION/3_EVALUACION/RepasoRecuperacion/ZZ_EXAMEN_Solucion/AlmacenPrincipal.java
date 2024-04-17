package ZZ_EXAMEN;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.*;

public class AlmacenPrincipal {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Comercial> comerciales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            menu();
            opcion = sc.nextInt();
            switch (opcion) {
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
                default:
                    if (opcion != 7)
                        System.out.println("Opción no válida.");
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
        LocalDate fechaCad = null;
        Producto p = null;
        double precio;
        String nombre, categoria;
        System.out.println("-------- Alta productos ---------");

        try {
            System.out.println("Introduzca nombre");
            nombre = sc.nextLine();

            sc = new Scanner(System.in);
            System.out.println("Introduzca precio");
            precio = sc.nextDouble();
            if (precio < 0)
                throw new PrecioNegativoException();

            sc = new Scanner(System.in);
            System.out.println("Introduzca categoría (Comestible/Bazar)");
            categoria = sc.nextLine();

            if (categoria.equalsIgnoreCase("comestible")) {
                System.out.println("Introduzca una fecha de caducidad (yyyy-MM-dd)");
                fechaCad = validarFecha(sc.nextLine());
                p = new Comestible(fechaCad, nombre, precio);

            } else if (categoria.equalsIgnoreCase("bazar")) {
                System.out.println("Introduzca el tipo de producto:");
                String tipo = sc.nextLine();
                p = new Bazar(tipo, nombre, precio);

            } else {
                System.err.println("Categoría no válida. Empiece de nuevo");
                altaProducto();
            }
        } catch (InputMismatchException | PrecioNegativoException e) {
            System.out.println(e.getMessage());
            altaProducto();
        }
        return p;
    }

    private static Comercial altaComercial() {
        Scanner sc = new Scanner(System.in);
        int edad = 0;
        String nombre = "", apellidos = "", zona = "";
        System.out.println("-------- Alta comerciales ---------");
        try {
            System.out.println("Introduzca nombre");
            nombre = sc.nextLine();

            System.out.println("Introduzca apellidos");
            apellidos = sc.nextLine();

            System.out.println("Introduzca zona");
            zona = sc.nextLine();

            System.out.println("Introduzca edad");
            edad = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Alguno de los datos introducidos no es válido.");
            altaComercial();
        }
        return new Comercial(nombre, apellidos, edad, zona, crearRegistroComercial());
    }

    // En el siguiente método, cambiar tipo de dato de retorno al tipo de colección elegida para el registro de los comerciales
    // Los elementos en el registro pueden introducirse manualmente, sin necesidad de solicitarlos por teclado.
    private static HashMap<Integer, Producto> crearRegistroComercial() {
        HashMap<Integer, Producto> reg = new HashMap<>();
        reg.put(0, new Bazar("Limpieza", "Lejía", 2));
        reg.put(1, new Comestible(LocalDate.of(2024, 04, 10), "Pasta", 1.5));
        reg.put(2, new Comestible(LocalDate.of(2024, Month.APRIL, 15), "Tomates", 3.8));
        reg.put(3, new Bazar("Mascotas", "Pienso gatos", 10));
        reg.put(4, new Bazar("Menaje", "Sartén", 8.9));

        return reg;
    }

    private static void eliminarProductosLimpieza() {
        productos.removeIf(p -> p instanceof Bazar && ((Bazar) p).getTipo().equals("Limpieza"));
    }

    private static void especialidadComerciales() {
        int contComestibles = 0, contBazar = 0;
        for (Comercial comercial : comerciales) {
            contBazar = contComestibles = 0;
            HashMap<Integer, Producto> registro = comercial.getVentas();
            Collection<Producto> reg = registro.values();
            for (Producto p : reg) {
                if (p instanceof Comestible) contComestibles++;
                if (p instanceof Bazar) contBazar++;
            }
            System.out.println("El comercial " + comercial.getNombre() + " " + comercial.getApellidos() + " está especializado en: " + (contComestibles >= contBazar ? "Comestibles" : "Bazar"));
        }
    }

    private static void costeProductos() {
        int sumaComestibles = 0, numComestibles = 0;
        for (Producto p : productos) {
            if (p instanceof Comestible) {
                numComestibles++;
                sumaComestibles += p.getPrecio();
            }
        }
        if (numComestibles > 0)
            System.out.println("El precio medio de los productos comestibles es: " + sumaComestibles / numComestibles);
        else
            System.out.println("No existen productos comestibles registrados");
    }

    private static void productosCaducidadProxima() {
        for (Comercial comercial : comerciales) {
            HashMap<Integer, Producto> ventas = comercial.getVentas();
            for (int i = 0; i < ventas.size(); i++) {
                if (ventas.get(i) instanceof Comestible && ((Comestible) ventas.get(i)).getFechaCaducidad().compareTo(LocalDate.now()) < 5) {
                    System.out.println("El producto " + ventas.get(i).getNombre() + " caduca en menos de 5 días.");
                }
            }
        }
    }

    private static LocalDate validarFecha(String fechaCad) {
        LocalDate date = null;
        try {
            date = LocalDate.parse(fechaCad);
            LocalDate now = LocalDate.now();
            if (date.isBefore(now)) {
                throw new CaducidadAnteriorException("ERROR: El producto está caducado. No se puede registrar");
            }
        } catch (DateTimeParseException | CaducidadAnteriorException e) {
            System.out.println("La fecha introducida es incorrecta. Vuelva a introducir los datos.");
            altaProducto();
        }
        return date;
    }
}
