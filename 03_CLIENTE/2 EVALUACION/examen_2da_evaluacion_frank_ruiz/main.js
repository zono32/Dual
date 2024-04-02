import { LineaTicket } from "./LineaTicket.js";

const d = document;

d.addEventListener("DOMContentLoaded", () => {

    d.addEventListener("click", functionClick);


    let articulo_1 = {
        nombre: "uvas",
        precio: 5.3
    }
    let articulo_2 = {
        nombre: "naranjas",
        precio: 6.2
    }
    let articulo_3 = {
        nombre: "fresa",
        precio: 7
    }
    let articulo_4 = {
        nombre: "sandias",
        precio: 8
    }

    let articulos = [articulo_1, articulo_2, articulo_3, articulo_4];

    let articulosDomNombre = d.querySelectorAll(".artH1");
    let articulosDomPrecio = d.querySelectorAll(".precio");

    articulos.forEach((art, index) => {

        articulosDomNombre[index].innerHTML = art.nombre;
        articulosDomPrecio[index].innerHTML = art.precio;

    })

})


function functionClick(e) {

    if (e.target.matches(".botonComprar")) {

        let btn = e.target;
        let fieldSetParent = btn.parentNode;
        let divParent = fieldSetParent.parentNode;
        let precio = divParent.querySelector(".precio").innerText;
        let cantidad = fieldSetParent.querySelector(".cantidad").value;
        let nombre = divParent.querySelector(".artH1").innerText

        // console.log(nombre);
        let total = parseFloat(precio) * parseInt(cantidad);

        let lineaTicket = new LineaTicket(nombre, precio, cantidad, total);

        localStorage.setItem(lineaTicket.articulo, JSON.stringify(lineaTicket));

        let row = lineaTicket.mostrarDatos();
        let tbody = d.querySelector("tbody");
        tbody.innerHTML += row;
        calcularTotal();


    }

    if (e.target.matches("#vaciar")) {
        vaciar();
    }

    if (e.target.matches("td")) {
        let td = e.target;
        let parent = td.parentNode;

        if (parent.classList.contains("comprados")) {
            eliminarLineaTicket(parent)
        }


    }

}

function calcularTotal() {

    let total = 0;
    let keysLocalStorage = Object.keys(localStorage);
    for (const key of keysLocalStorage) {
        let obj = JSON.parse(localStorage.getItem(key));
        // console.log(obj);
        total += parseFloat(obj.total);
    }

    d.getElementById("total").innerHTML = total.toFixed(2);
}

function vaciar() {

    let tbody = d.querySelector("tbody");
    let comprados = d.querySelectorAll(".comprados");

    comprados.forEach((comprado) => {
        tbody.removeChild(comprado);
    })

    let keysLocalStorage = Object.keys(localStorage);
    for (const key of keysLocalStorage) {
        localStorage.removeItem(key);
    }

    d.getElementById("total").innerHTML = 0;

}

function eliminarLineaTicket(parent) {

    let tbody = d.querySelector("tbody");
    let firstChild = parent.firstChild;
    let firstChildValue = firstChild.innerText.trim();

    localStorage.removeItem(firstChildValue);
    tbody.removeChild(parent);

    calcularTotal();

}

