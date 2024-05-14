

class Cliente{

    constructor(nombre, dni, direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    mostrar() {
        return `Nombre: ${this.nombre}, DNI: ${this.dni}, Dirección: ${this.direccion}`;
    }
}

window.onload = () => {
    
    document.addEventListener("submit", e => {
       
        e.preventDefault();

        if (e.target.matches("#form_cliente")) {

            const form = e.target;

            let nombre = form["nombre"].value;
            let dni = form["dni"].value;
            let direccion = form["direccion"].value;

            let cliente = new Cliente(nombre, dni, direccion);
            
            let clienteJson = JSON.stringify(cliente);
            localStorage.setItem(cliente.dni, clienteJson);

            form.reset();
        }

    });

    document.addEventListener("click", e => {
      
        if (e.target.matches("#mostrar_clientes")) {
            
            let keys = Object.keys(localStorage);

            const table = document.createElement("table");

            for (let key of keys) {
                
                let cliente = JSON.parse(localStorage.getItem(key))

                let { dni, nombre, direccion } = cliente;

                let tr = document.createElement("tr");

                let tdNombre = document.createElement("td");
                let tdDni = document.createElement("td");
                let tdDireccion = document.createElement("td");

                tdNombre.innerText = nombre;
                tdDni.innerText = dni;
                tdDireccion.innerText = direccion;

                tr.appendChild(tdNombre);
                tr.appendChild(tdDni);
                tr.appendChild(tdDireccion);

                table.appendChild(tr);                

            }

            document.getElementById("section_clientes").replaceChildren(table);

        }

        if (e.target.matches("td")){

            const td = e.target;
            const tr = td.parentNode;
            const table = tr.parentNode;

            table.removeChild(tr);

        };



    })







}