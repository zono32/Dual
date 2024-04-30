import { Cliente } from "./Cliente.js";

document.addEventListener("DOMContentLoaded", e => {



});


document.addEventListener("submit", e => {

    e.preventDefault();
    if (e.target.matches("#form_cliente")) {

        let form = e.target;

        let form_nombre = form["nombre"].value;
        let form_dni = form["dni"].value;
        let form_direccion = form["direccion"].value;

        let cliente = new Cliente(form_nombre, form_dni, form_direccion);

        localStorage.setItem(cliente.dni, JSON.stringify(cliente));

        form.reset();


    }

});


document.addEventListener("click", e => {

    if (e.target.matches("#mostrar_clientes")) {
        mostrar();
    }


    if (e.target.matches("td")) {
        

        let td = e.target;
        let parentTr = td.parentNode;
        let parentTable = parentTr.parentNode;

        parentTable.removeChild(parentTr);
        

    }


});






function mostrar() {

    let table = document.createElement("table");

    let keys = Object.keys(localStorage);

    keys.forEach((key) => {

        let cliente = JSON.parse(localStorage.getItem(key));

        console.log(cliente);

        let { dni, nombre, direccion } = cliente;


        let tr = document.createElement("tr");

        let tdDni = document.createElement("td");
        let tdNombre = document.createElement("td");
        let tdDireccion = document.createElement("td");


        tdDni.innerText = dni;
        tdNombre.innerText = nombre;
        tdDireccion.innerText = direccion;

        tr.appendChild(tdDni);
        tr.appendChild(tdNombre);
        tr.appendChild(tdDireccion);

        table.appendChild(tr);


    });

    document.getElementById("section_clientes").replaceChildren(table);

}