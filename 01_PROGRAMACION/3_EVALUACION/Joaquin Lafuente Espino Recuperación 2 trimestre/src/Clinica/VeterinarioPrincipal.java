package Clinica;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class VeterinarioPrincipal {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Veterinario> veterinarios = new ArrayList<>();

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            menu();
            opcion = sc.nextInt();
            switch (opcion){
                case 1 :
                    veterinarios.add(altaVeterinario());
                    break;
                case 2 :
                    EliminarVeterinarios();
                    break;
                case 3 :
                    calcularSalarioMedio();
                    break;
                case 4 :
                    mascotasAtendidas();
                    break;
                case 5 :
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Por favor elija bien la opción");
                    break;
            }
        }
        while (opcion != 5);
    }

    private static void menu() {
        //Encabezado
        System.out.println("-----------------------------");
        System.out.println("Menú de Clinica Veterinaria");
        System.out.println("-----------------------------");

        System.out.println("Seleccione lo que desea realizar:");
        System.out.println("1: Alta veterinarios");
        System.out.println("2: Eliminar dermatologos");
        System.out.println("3: Salario medio traumatologia");
        System.out.println("4: Listar mascotas senior");
        System.out.println("5: Salir");
    }

    private static Veterinario altaVeterinario() {
        boolean datosdni = false;
        Veterinario vet = null;
        double sueldoMensual = 0;
        String especialidad = null;
        LocalDate fechaContratacion = null;


        try {
            System.out.println("nombre de veterinario");
            String nom = sc.next();

            System.out.println("dni de veterinario");
            String dni = sc.next();
            if( dni.length() != 9){
                throw new ExcepMalDni("ERROR: el dni tiene 9 caracteres");
            }

            System.out.println("direccion de veterinario");
            String direc = sc.next();
            sc = new Scanner(System.in);

            System.out.println("edad de veterinario");
            int edad = sc.nextInt();
            if( edad < 0){
                throw new ExcepEdadNegativa("ERROR: La edad no puede ser un número negativo");
            }
            vet = new Veterinario(dni, nom, edad, direc, sueldoMensual, especialidad,fechaContratacion,rellenarRegistroMascotas());

        } catch (InputMismatchException | ExcepEdadNegativa e) {
            System.out.println(e.getMessage());
            altaVeterinario();
        } catch (ExcepMalDni e) {
            System.out.println(e.getMessage());
            altaVeterinario();
        }
        return vet;
    }

    private static HashMap<Integer, Mascota> rellenarRegistroMascotas() {
        HashMap<Integer,Mascota> masc = new HashMap<Integer, Mascota>();
        masc.put(0, new Mascota("Mia", "Perro",  LocalDate.of(2024, 02, 26), LocalDate.parse("26/02/2014")));
        masc.put(1, new Mascota("Lia", "Perro", LocalDate.parse("26/02/2010"), LocalDate.parse("26/06/2019")));
        masc.put(2, new Mascota("Oto", "Gato", LocalDate.parse("26/02/2010"), LocalDate.parse("2/04/2016")));
        masc.put(3, new Mascota("Dientes", "Exotico", LocalDate.parse("26/02/2010"), LocalDate.parse("01/08/2020")));
        return masc;
    }

    public static void EliminarVeterinarios() {

        veterinarios.removeIf(v -> v.getEspecialidad().equalsIgnoreCase("dermatologia") );
    }

    public static double calcularSalarioMedio() {

        double salarioMedio = 0;
        int contador = 0;

        for(Veterinario v : veterinarios){

            if(v.getEspecialidad().equalsIgnoreCase("traumatologia") ) {
                contador ++;
                salarioMedio = (v.getSueldoMensual()*14)/contador;
            }
        }
        return salarioMedio;

    }

    public static int mascotasAtendidas() {

        int numeroMascotas =0;

        LocalDate hoy = LocalDate.now();

        for(Veterinario v : veterinarios){
           HashMap<Integer, Mascota> masc = v.getRegistro();
            for (int i = 0; i <masc.size() ; i++) {
                LocalDate reg = masc.get(i).getFechaRegistro();
                if(Period.between(reg,hoy).getYears()> 6){
                    numeroMascotas ++;
                }
            }
        }
        
        return numeroMascotas;
    }
}
