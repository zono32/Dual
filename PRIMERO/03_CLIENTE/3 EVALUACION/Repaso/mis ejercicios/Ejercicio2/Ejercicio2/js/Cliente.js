export class Cliente {


    constructor(nombre, dni, direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    mostrar() {
        
        return `Nombre: ${this.nombre} DNI: ${this.dni} Dirección: ${this.direccion}`;
    }

}