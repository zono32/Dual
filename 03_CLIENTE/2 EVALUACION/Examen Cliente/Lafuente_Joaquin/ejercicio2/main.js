window.onload = () => {};

class LineaTicket {
  constructor(articulo, cantidad, precio, total) {
    this.articulo = articulo;
    this.cantidad = cantidad;
    this.precio = precio;
    this.total = total;
  }
  mostrarDatos() {
    return `<tr class='comprados'><td> ${this.articulo} </td><td> ${this.precio}   €/Kg</td><td>$
        {this.cantidad}  kg</td><td class='precioTabla'> ${this.total}</tr> `;
  }
}

let uvas = {
  nombre: "uvas",
  precio: 1.15,
};
let naranja = {
  nombre: "naranja",
  precio: 2.4,
};
let fresa = {
  nombre: "fresa",
  precio: 3.1,
};
let sandia = {
  nombre: "sandia",
  precio: 2.5,
};

let frutas = [uvas, naranja, fresa, sandia];

let productName = document.querySelectorAll("artH1");
let productPrice = document.querySelectorAll("precio");
frutas.forEach(art, (index) => {
  productName[index].innerHTML = art.nombre;
  productPrice[index].innerHTML = art.precio;
});

let comprar = document.querySelector("comprar");

comprar.addEventListener("click", comprarFrutas);

function comprarFrutas() {
  let lineaTicket = new LineaTicket(nombre, precio, cantidad, total);
  localStorage.setItem(lineaTicket.articulo, JSON.stringify(lineaTicket));
}

let vaciar = document.getElementById("vaciar");
vaciar.addEventListener("click", vaciarDatos);


function vaciarDatos(e) {
    e.preventdefaul();
    let datos = e.target
    localStorage.removeItem(datos.id);
}

