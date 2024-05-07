import { Cliente } from "./Cliente.js";


const d = document;


d.addEventListener("click", e => {
    

    if (e.target.matches("#mostrar")) {
        
        let keys = Object.keys(localStorage);

        let table = d.createElement("table");

        for (const key of keys) {
            console.log(key);
            let cliente = JSON.parse(localStorage.getItem(key));

            let { dni, nombre, direccion } = cliente;

            let tr = d.createElement("tr");

            let tdNombre = d.createElement("td");
            let tdDni = d.createElement("td");
            let tdDireccion = d.createElement("td");

            tdNombre.innerText = nombre;
            tdDireccion.innerText = direccion;
            tdDni.innerText = dni;

            tr.appendChild(tdNombre);
            tr.appendChild(tdDireccion);
            tr.appendChild(tdDni);

            table.appendChild(tr);

        }


        d.getElementById("section_table").replaceChildren(table);


    }


    if (e.target.matches("td")) {
        
        const td = e.target;
        const tr = td.parentNode;
        const table = tr.parentNode;

        table.removeChild(tr);


    }

})


d.addEventListener("submit", e => {


    e.preventDefault();

    if (e.target.matches("#formulario_cliente")) {

        const form = e.target;

        let nombre = form["nombre"].value;
        let dni = form["dni"].value;
        let direccion = form["direccion"].value;

        let cliente = new Cliente(nombre, dni, direccion);

        let clienteJson = JSON.stringify(cliente);

        localStorage.setItem(cliente.dni, clienteJson);

        form.reset();

    }


})
