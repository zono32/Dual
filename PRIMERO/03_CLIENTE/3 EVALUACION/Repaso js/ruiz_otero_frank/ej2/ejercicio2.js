'use strict'


//Declarar un array de objetos de clientes
var datosClientes = [{
    id: 1,
    email: "michael.lawson@reqres.in",
    first_name: "Michael",
    last_name: "Lawson"
},
{
    id: 2,
    email: "lindsay.ferguson@reqres.in",
    first_name: "Lindsay", "last_name": "Ferguson"
}
    , {
    id: 3,
    email: "tobias.funke@reqres.in",
    first_name: "Tobias",
    last_name: "Funke"
},
{
    id: 4,
    email: "byron.fields@reqres.in",
    first_name: "Byron",
    last_name: "Fields"
}];
//Declara un array de objetos de pizzas
var datosPizza = [
    {
        nombre: "Pizza margarita",
        precio: 20,
        identificador: 1,
        ingredientes: [
            "Champiñones",
            "Jamón Cocido"
        ]
    },
    {
        nombre: "Pizza barbacoa",
        precio: 25,
        identificador: 2,
        ingredientes: [
            "Carne",
            "Salsa barbacoa",
            "Extra de queso"
        ]
    },
    {
        nombre: "Pizza atún",
        precio: 22,
        identificador: 3,
        ingredientes: [
            "Atún",
            "Aceitunas negras",
            "Anchoa"
        ]
    }
];


const d = document;

let pizza = null;

d.addEventListener("DOMContentLoaded", e => {


    let id = prompt("Introduce el identificador del cliente");

    mostrarDatosPizza(datosPizza);

    if (/[0-9]+/.test(id)) {

        id = parseInt(id);

        // cliente
        let cliente = datosClientes.find((cliente) => cliente.id === id);

        mostrarCliente(cliente);

        // pizza
        pizza = datosPizza.find((pizza) => pizza.identificador === id);

        if (!pizza) return;

        let h2_mensaje = d.createElement("h2");
        h2_mensaje.innerText = "Cargando...";

        d.getElementById("ingredientes").appendChild(h2_mensaje);

        setTimeout(() => mostrarIngredientesPizza(pizza), 2000);

    } else {

        alert("El id debe ser sólo números");
    }


    d.addEventListener("click", functionEventoClick);

});



function mostrarCliente(cliente, id) {


    if (cliente) {

        let divCliente = d.getElementById("cliente");

        let { first_name, last_name } = cliente;

        let h1 = d.createElement("h1");

        h1.innerText = `${first_name} ${last_name}`;

        divCliente.appendChild(h1);


    } else {

        alert(`No existe el empleado con el id ${id}`)
    }

}


function mostrarDatosPizza(datosPizza = []) {


    let divPizzas = d.getElementById("pizzas");

    let table = d.createElement("table");

    datosPizza.forEach((datoPizza) => {

        let { nombre, precio } = datoPizza;

        let tr = d.createElement("tr");

        let td_nombre = d.createElement("td");
        let td_precio = d.createElement("td");

        td_nombre.innerText = nombre;
        td_precio.innerText = precio;

        tr.appendChild(td_nombre);
        tr.appendChild(td_precio);

        table.appendChild(tr);


    });

    divPizzas.appendChild(table);


}


function mostrarIngredientesPizza(pizza) {

    let divIngredientes = d.createElement("div");

    let { ingredientes, nombre } = pizza;

    let h1 = d.createElement("h1");

    h1.innerText = `Los ingredientes de la ${nombre} son:`;

    divIngredientes.appendChild(h1);

    ingredientes.forEach((ingrediente) => {

        let h2 = d.createElement("h2");

        h2.innerText = ingrediente;

        divIngredientes.appendChild(h2);
    });

    let button = d.createElement("button");

    button.innerText = "Comprar";

    button.setAttribute("id", "btn_comprar");
    divIngredientes.appendChild(button);

    d.getElementById("ingredientes").replaceChildren(divIngredientes);


}


function functionEventoClick(e) {

    if (e.target.matches("#btn_comprar")) {

        let { identificador } = pizza;
        localStorage.setItem(identificador, JSON.stringify(pizza));
    }

}