package MasEjercicios.n_EmpleadosReparto;

/**
 *
 * @author nccasares
 */

/**
 * Implementar un programa que gestione empleados.
 *
 * Características:
 * Nombre
 * Edad
 * Salario
 * También existirá una constante llamada PLUS, que tendrá un valor de 300€
 *
 * La clase empleado no necesitará ser instanciada.
 * Existen dos tipos de empleados: repartidor y comercial.
 *
 * El comercial, aparte de los atributos anteriores, tiene uno propio llamado comisión (double).
 *
 * El repartidor, aparte de los atributos de empleado, tiene otro propio zona (String).
 *
 * Crea sus constructores, getters and setters y toString.
 *
 * Las clases tendrán un método llamado plus, que según en cada clase tendrá una implementación distinta.
 * En comercial, si tiene más de 30 años y cobra una comisión de más de 200 euros, se le aplicará el plus.
 * En repartidor, si tiene menos de 25 y reparte en la “zona 3”, recibirá el plus.
 *
 * Crea una clase ejecutable donde crees distintos empleados y le apliques el plus para comprobar que funciona.
 * */

public class Principal {

    public static void main(String[] args) {

        Comercial c1 = new Comercial(300, "Francisco", 37, 1000);
        Repartidor r1 = new Repartidor("zona 3", "María", 26, 900);

        c1.plus();
        r1.plus();

        System.out.println(c1);
        System.out.println(r1);
    }
}

