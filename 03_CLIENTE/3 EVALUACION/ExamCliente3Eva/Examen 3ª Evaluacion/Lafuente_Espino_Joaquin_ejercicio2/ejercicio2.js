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

window.onload = () => {
    

    let id = prompt("introduce un identificador de cliente")

    for (let index = 0; index < datosClientes.length; index++) {
        //console.log(datosClientes[index]);
        const element = datosClientes[index].id;
       // console.log(element)
        if (element == id) {

            let cliente = document.getElementById("cliente");

            let nombre = datosClientes[index].first_name;
            let apellido = datosClientes[index].last_name;

            cliente.innerText = nombre +apellido
            //cliente.innerText = apellido;            
        
        } //else alert("Cliente no encontrado")


    }

    function crearTablaPizzas() {

        for (let index = 0; index < datosPizza.length; index++) {
        const element = datosPizza[index];

        
        let nombre = datosPizza[index].nombre;
        let precio = datosPizza[index].precio;

        const table = document.createElement("table");

        let tr = document.createElement("tr");

        let tdNombre = document.createElement("td");
        let tdPrecio = document.createElement("td");

        tdNombre.innerHTML = nombre;
        tdPrecio.innerHTML = precio;

        tr.appendChild(tdNombre);
        tr.appendChild(tdPrecio);

            table.appendChild(tr);
            
        //let ingredientes = document.getElementById("ingredientes");
        let pizzas = document.getElementById("pizzas");
        pizzas.appendChild(table);
        }         
        
    }  

crearTablaPizzas();

    


}