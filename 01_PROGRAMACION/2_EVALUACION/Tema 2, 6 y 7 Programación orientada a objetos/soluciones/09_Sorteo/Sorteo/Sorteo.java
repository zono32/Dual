package RAMA.Sorteo;

/**
 *
 * Tenemos la siguiente clase:
 * public abstract class sorteo{
 * protected int posibilidades;
 * public abstract int lanzar();
 * }
 * Se pide:
 *  Crear la clase dado, la cual desciende de la clase sorteo. La clase dado, en la llamada lanzar() mostrará un número aleatorio del 1 al 6.
 *  Crear la clase moneda, la cual desciende de la clase sorteo. Esta clase en la llamada al método lanzar() mostrará las palabras cara o cruz
 *
 *
 * @author nccasares
 */
public abstract class Sorteo {

    protected int posibilidades;

    public abstract int lanzar();
}
