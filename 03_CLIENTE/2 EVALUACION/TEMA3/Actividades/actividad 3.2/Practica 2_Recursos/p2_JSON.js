//window.addEventListener('DOMContentLoaded', () => { logica
//})


class Alumno{
    constructor(nombre, dni, direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;   
    }
    getNombre() { return this.nombre; }
    setNombre(nombre) { this.nombre = nombre; }

    getDni() { return this.dni; }
    setDni(dni) { this.dni = dni; }

    getDireccion() { return this.direccion; }
    setDireccion(direccion) { this.direccion = direccion; }
}

function crearAlumno(e) {
    e.preventDefault();
    const nombre = document.getElementById("addNombre").value;
    const dni = document.getElementById("addDni").value;
    const direccion = document.getElementById("addDireccion").value;
    
    const alumno = new Alumno(nombre, dni, direccion);
    localStorage.setItem(alumno.getDni(), JSON.stringify(alumno));
}

window.onload = () => {

    
    document.addEventListener("submit", crearAlumno);
    
    const mostrarAlumno = document.getElementById("mostrar");
    mostrarAlumno.addEventListener("click", mostrar);
    
    

    function modificar(nombre, direccion, dni){}
    
    function mostrar() {
        const divAlumno = document.getElementById("alumnos");

        const tableAlumnos = document.createElement("table");
        divAlumno.appendChild(tableAlumnos);
        const titleTable = document.createElement("caption");
        titleTable.innerHTML = "tabla Alumnos";
        tableAlumnos.appendChild(titleTable);
        const cabecera = cocument.createElement("th");
        const datosCabeceraDni = document.createElement("td")
        
        const datosCabeceraNombre = document.createElement("td")


    }
    
    


    
}