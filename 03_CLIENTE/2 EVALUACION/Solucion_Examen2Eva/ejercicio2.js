// Comprobar si localStorage está disponible
if (typeof Storage !== 'undefined') {
    // LocalStorage disponible
    console.log('LocalStorage disponible');
} else {
    // LocalStorage no soportado en este navegador
    console.log('LocalStorage no soportado en este navegador');
}

//Crear 4 objetos de tipo articulo
let art = [{
    nombre: "uvas",
    precio: 1.15

},
{
    nombre: "naranja",
    precio: 2.40
},
{
    nombre: "fresa",
    precio: 3.10

},
{

    nombre: "sandia",
    precio: 2.50
}]


//Crear la clase lineaTicket
class lineaTicket {
    constructor(cantidad, articulo, precio, total) {
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.precio = precio;
        this.total = total;
    }

    //metodos
    mostrarDatos() {
        return `<tr class='comprados'><td> ${this.articulo} </td><td> ${this.precio}  €/Kg</td><td>${this.cantidad}  kg</td><td class='precioTabla'> ${this.total}</tr> `;

    }
}


//Función que recorre todos los cuadros de texto y los limpia
let limpiarCampos = () => {

    cuadrosTexto.forEach((cuadro) => {
        cuadro.value = "";
    })

    console.log(cuadrosTexto[0].focus());
}

let actualizarTotal = () => {
    let totalPrecios = 0;
    //Recorre el localStorage para calcular el total
    for (let i = 0; i < localStorage.length; i++) {
        const lineaArt = JSON.parse(localStorage.getItem(localStorage.key(i)));

        totalPrecios = totalPrecios + parseFloat(lineaArt.total);


    }
    //Actualizar el total, para ello accedemos al objeto de id total
    const totalFactura = document.getElementById("total");

    totalFactura.innerHTML = (totalPrecios + " €");


}


//Declarar una variable global cuadros de texto
var cuadrosTexto;
//Método que asegura que cuando se accede a los elementos del DOM, estoy ya
//se encuentran cargados

window.addEventListener('DOMContentLoaded', () => {
    const btnComprar = document.getElementsByClassName('botonComprar');
    const hArticulo = document.getElementsByClassName('artH1');
    const divPrecio = document.getElementsByClassName('precio');
    const divProductos = document.getElementById("productos");
    const btnVaciar = document.getElementById("vaciar");
    const totalFactura = document.getElementById("total");
    const tabla = document.getElementById("tablaCarrito");


    //Obtener todos los cuadros de texto y almacenarlos en un array
    //Obtener la lista de elementos input:text e input:number
    cuadrosTexto = document.querySelectorAll("input[type=text],input[type=number]");

    //Elimina el localStorage
    if (localStorage!=null)
        localStorage.clear();

    //Diseñar la pagina con los datos de los articulos
    for (let i = 0; i < hArticulo.length; i++) {
        hArticulo[i].innerHTML = art[i].nombre;
        divPrecio[i].innerHTML = art[i].precio;
    }

    tabla.addEventListener('click', (evt) => {
        console.log(evt.target.parentNode.childNodes);
        console.log(evt.target.parentNode.childNodes[0]);

        let claveAEliminar=evt.target.parentNode.childNodes[0].innerHTML;
        console.log(claveAEliminar);
        //Eliminar la fila de la tabla
        let nodo=evt.target.parentNode;
        let padre=evt.target.parentNode.parentNode;
        padre.removeChild(nodo);
        
        //Eliminar el articulo del localStorage y actualizar la tabla
        console.log(claveAEliminar);
        localStorage.removeItem(claveAEliminar.trim());
        actualizarTotal();

    });

    //Poner el botón comprar a la escucha del evento con delegacion de eventos
    divProductos.addEventListener('click', (evt) => {

        if (evt.target.value === "Comprar") {
            console.log(evt.target.parentNode.childNodes);
            console.log(evt.target.parentNode.childNodes[3]);

            let cantidad = evt.target.parentNode.childNodes[3].value;


            if (cantidad == "") {
                alert("Debes introducir una cantidad");
            } else {
                //Obtener el precio del articulo. Para ello vamos a buscar el articulo en el localStorage
                //en el caso de que no lo encuentre devuelve null
                let precioKg = 0;
                let nombreArt = "";
                art.forEach(element => {
                    if (element.nombre == evt.target.parentNode.parentNode.childNodes[3].innerHTML) {
                        precioKg = element.precio;
                        nombreArt = evt.target.parentNode.parentNode.childNodes[3].innerHTML;
                    }
                });

                let precio = (cantidad * precioKg).toFixed(2);
                console.log(`${cantidad} *  ${precioKg} = ` + precio);

                //Crear la linea de ticket
                let linea = new lineaTicket(cantidad, nombreArt, precioKg, precio);

                //Almacenar la linea en el localStorage
                localStorage.setItem(nombreArt, JSON.stringify(linea));

                console.log(linea.mostrarDatos())
                let tabla = document.getElementById("tablaCarrito");

                tabla.innerHTML = tabla.innerHTML + linea.mostrarDatos();

                actualizarTotal();
            }
        }



    });

    btnVaciar.addEventListener('click', (evt) => {
        const node = document.getElementById("tablaCarrito");
       
        const listaCarrito = node.childNodes;
        while (listaCarrito.length != 0) {
            node.removeChild(node.firstChild);
        }

        let filaCab = "<tr><th>Producto</th><th>Precio kilo</th><th>Cantidad</th><th>Precio</th><th></th></tr>"
        document.getElementById("tablaCarrito").innerHTML = filaCab;
        totalFactura.innerHTML = (0 + " €");
    });

});



