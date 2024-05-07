

import { Cliente } from "./Cliente.js";

const d = document;

d.addEventListener("click", e => {
    // Esta función maneja los eventos de clic en la página web.
    
    if (e.target.matches("#mostrar")) {
        // Si haces clic en un botón con id "mostrar", muestra los clientes en una tabla.
        
        let keys = Object.keys(localStorage);
        // Obtiene todas las claves de Local Storage.
        
        let table = d.createElement("table");
        // Crea una tabla nueva.

        for (const key of keys) {
            // Recorre cada clave en Local Storage.
            
            console.log(key);
            let cliente = JSON.parse(localStorage.getItem(key));
            // Convierte la información JSON del cliente en un objeto.

            let { dni, nombre, direccion } = cliente;
            // Extrae dni, nombre y dirección del cliente.

            let tr = d.createElement("tr");
            // Crea una fila de la tabla.

            let tdNombre = d.createElement("td");
            let tdDni = d.createElement("td");
            let tdDireccion = d.createElement("td");
            // Crea celdas para cada parte de la información del cliente.

            tdNombre.innerText = nombre;
            tdDireccion.innerText = direccion;
            tdDni.innerText = dni;
            // Asigna los valores del cliente a las celdas.

            tr.appendChild(tdNombre);
            tr.appendChild(tdDireccion);
            tr.appendChild(tdDni);
            // Añade las celdas a la fila.

            table.appendChild(tr);
            // Añade la fila a la tabla.
        }

        d.getElementById("section_table").replaceChildren(table);
        // Reemplaza el contenido de la sección "section_table" con la nueva tabla.
    }

    if (e.target.matches("td")) {
        // Si haces clic en una celda (td) de la tabla, elimina la fila correspondiente.
        
        const td = e.target;
        const tr = td.parentNode;
        const table = tr.parentNode;

        table.removeChild(tr);
        // Elimina la fila de la tabla.
    }
});

d.addEventListener("submit", e => {
    // Esta función maneja los eventos de envío de formularios en la página web.

    e.preventDefault();
    // Evita que el formulario se envíe de forma predeterminada.

    if (e.target.matches("#formulario_cliente")) {
        // Si el formulario enviado tiene el id "formulario_cliente", guarda los datos del cliente.

        const form = e.target;

        let nombre = form["nombre"].value;
        let dni = form["dni"].value;
        let direccion = form["direccion"].value;
        // Toma los valores de los campos del formulario: nombre, dni y dirección.

        let cliente = new Cliente(nombre, dni, direccion);
        // Crea un nuevo objeto cliente usando la clase "Cliente".

        let clienteJson = JSON.stringify(cliente);
        // Convierte el objeto cliente en una cadena de texto JSON.

        localStorage.setItem(cliente.dni, clienteJson);
        // Guarda el cliente en Local Storage usando el dni como clave.

        form.reset();
        // Limpia el formulario.
    }
});
