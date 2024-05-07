class Cliente{
    constructor(nombre, direccion, dni){
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }
    mostrarCliente() {
        return ` El cliente ${this.nombre} con DNI ${this.dni}, vive en ${this.direccion}`
    }
}

function agregarCliente(cliente) {
    // Convertir el objeto cliente a JSON
    const clienteJSON = JSON.stringify(cliente);
    // Agregar el objeto al localStorage con una clave única (por ejemplo, el DNI)
    localStorage.setItem(cliente.DNI, clienteJSON);
}


function mostrarClientes() {
    // Obtener la tabla donde se mostrarán los clientes
    const tabla = document.getElementById("tablaClientes");
    
    // Limpiar la tabla antes de agregar nuevos datos
    tabla.innerHTML = "";

    // Recorrer el localStorage
    for (let i = 0; i < localStorage.length; i++) {
        const clave = localStorage.key(i);
        const clienteJSON = localStorage.getItem(clave);
        
        // Convertir JSON a objeto JavaScript
        const cliente = JSON.parse(clienteJSON);
        
        // Crear una nueva fila en la tabla
        const fila = tabla.insertRow();
        
        // Agregar los datos del cliente a la fila
        const celdaNombre = fila.insertCell(0);
        celdaNombre.textContent = cliente.nombre;

        const celdaDNI = fila.insertCell(1);
        celdaDNI.textContent = cliente.DNI;

        const celdaDireccion = fila.insertCell(2);
        celdaDireccion.textContent = cliente.direccion;

        // Agregar un atributo de dato a la fila con el DNI del cliente (clave en localStorage)
        fila.setAttribute("data-dni", cliente.DNI);

        // Añadir un evento de clic a la fila para eliminar al hacer clic
        fila.addEventListener("click", eliminarCliente);
    }
}

function eliminarCliente(evento) {
    // Obtener la fila que se ha hecho clic
    const fila = evento.target.closest("tr");

    // Obtener el DNI del cliente de los atributos de datos de la fila
    const dni = fila.getAttribute("data-dni");

    // Eliminar el cliente del localStorage
    localStorage.removeItem(dni);

    // Eliminar la fila de la tabla
    fila.remove();
}
