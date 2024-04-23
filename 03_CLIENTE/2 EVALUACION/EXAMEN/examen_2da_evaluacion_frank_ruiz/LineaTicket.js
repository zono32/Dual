export class LineaTicket {

    constructor(articulo, cantidad, precio, total) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }
    mostrarDatos() {
        return `<tr class='comprados'><td> ${this.articulo} </td><td> ${this.precio} €/Kg</td><td>${this.cantidad} kg</td><td class='precioTabla'> ${this.total}</tr> `; }

}