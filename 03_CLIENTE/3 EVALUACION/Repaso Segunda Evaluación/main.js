//Crear 4 objetos de tipo articulo

let articulo = [    
    {
        nombre: "uvas",
        precio: 1.15
    },
    {
        nombre: "maranja",
        precio: 2.4
    },
    {
        nombre: "fresa",
        precio: 3.1
    },
    {
        nombre: "sandia",
        precio: 2.5
    }
]

class Lineaticket{
    constructor(articulo, cantidad, precio, total) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;            
    }

    mostrarDatos() {
        return `<tr class='comprados'><td> ${this.articulo} </td><td> ${this.precio} €/Kg</td><td>
        ${this.cantidad} kg</td><td class='precioTabla'> ${this.total}</tr> `;         
    }
}

window.onload = () => {   

    let productos = document.getElementById("productos");

    console.log(productos)
    let uvas =productos.getElementById("uvas")
    console.log(uvas);


}
