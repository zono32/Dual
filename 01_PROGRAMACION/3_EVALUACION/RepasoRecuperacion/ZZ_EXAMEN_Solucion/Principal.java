/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZZ_EXAMEN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nccasares
 */
public class Principal {
/*
    ArrayList<Producto> productos = new ArrayList<>();
    ArrayList<Comercial> comerciales = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        try {
            do {
                menu();
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        altaProducto();
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                }

                }
                while (opcion != 7);
                    p.crearListaProductos();

                System.out.println("CREANDO LISTA DE COMERCIALES");
                p.crearListaComerciales();

                System.out.println("ELIMINAR PRODUCTOS DE LIMPIEZA");
                p.eliminarProductosLimpieza();

            } catch(PrecioNegativoException | CaducidadAnteriorException e){
                System.out.println(e.getMessage());
            }

        }
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

    private static Producto altaProducto() throws PrecioNegativoException, CaducidadAnteriorException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String opcion, nombre, tipo, categoria;
        double precio;
        Date fechaCad = new Date();
        Date fechaActual = new Date();
        Producto p;

        do {
            System.out.println("¿Desea introducir un nuevo producto? (Y/N)");
            opcion = sc.nextLine();

            if (!opcion.equals("N")) {
                System.out.println("Introduzca nombre");
                nombre = sc.nextLine();

                sc = new Scanner(System.in);
                System.out.println("Introduzca precio");
                precio = sc.nextDouble();
                if (precio < 0) {
                    throw new PrecioNegativoException("ERROR: EL PRECIO INTRODUCIDO ES NEGATIVO");
                }

                sc = new Scanner(System.in);
                System.out.println("Introduzca categoría (Comestible/Bazar)");
                categoria = sc.nextLine();

                if (categoria.equals("Comestible")) {
                    sc = new Scanner(System.in);
                    System.out.println("Introduzca fecha de caducidad (dd/MM/YYYY)");
                    try {
                        fechaCad = sdf.parse(sc.nextLine());
                        if (fechaCad.before(fechaActual)) {
                            throw new CaducidadAnteriorException("ERROR: LA FECHA DE CADUCIDAD INTRODUCIDA ES ANTERIOR A LA ACTUAL");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    p = new Comestible(fechaCad, nombre, precio);
                } else {
                    sc = new Scanner(System.in);
                    System.out.println("Introduzca tipo de producto de bazar");
                    tipo = sc.nextLine();
                    p = new Bazar(tipo, nombre, precio);
                }
                return p;
            }
        } while (!opcion.equals("N"));
        return null;
    }

    private void crearListaComerciales() {

        HashMap<Integer, Producto> pAux = new HashMap<>();
        pAux.put(0, productos.get(3));
        pAux.put(1, productos.get(2));
        comerciales.add(new Comercial("Marcos", "Rodríguez", 40, "zona 1", pAux));

        pAux.clear();
        pAux.put(0, productos.get(1));
        pAux.put(1, productos.get(0));
        comerciales.add(new Comercial("Marta", "Pérez", 35, "zona 2", pAux));

        pAux.clear();
        pAux.put(0, productos.get(4));
        pAux.put(1, productos.get(0));
        comerciales.add(new Comercial("Nerea", "García", 32, "zona 3", pAux));

        pAux.clear();
        pAux.put(0, productos.get(2));
        pAux.put(1, productos.get(3));
        comerciales.add(new Comercial("Mario", "López", 38, "zona 3", pAux));
    }

    private void eliminarProductosLimpieza() {
        for (Producto p : productos) {
            if (p instanceof Bazar && ((Bazar) p).getTipo().equals("Limpieza")) {
                productos.remove(p);
            }
        }
    }

    private void especialidadComercial() {
        int contador_comestible = 0;
        int contador_bazar = 0;
        
        for (Comercial c : comerciales) {
            if (mas.get(i).getEspecie().equals("Perro")) {
                contador_perro++;
            }

            if (mas.get(i).getEspecie().equals("Gato")) {
                contador_gato++;
            }
            

        }

        int maximo = contador_gato;
        String animalMaximo = "gato";

        if (contador_perro > maximo) {
            animalMaximo = "perro";
            maximo = contador_perro;
        }

        if (contador_ave > maximo) {
            animalMaximo = "ave";
            maximo = contador_ave;
        }

        if (contador_exotico > maximo) {
            animalMaximo = "exotico";
            maximo = contador_exotico;
        }

        return animalMaximo;

    }*/
}
