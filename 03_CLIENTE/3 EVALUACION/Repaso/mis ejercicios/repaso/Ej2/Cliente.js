

export class Cliente{

    constructor(nombre, dni, direccion) {
        nombre = this.nombre;
        dni= this.dni;
        direccion = this.direccion;
    }

     mostarDatos() {
         return `El cliente se llama ${this.nombre} su DNI es: ${this.dni} y su dirección ${this.direccion}`; 
    }
}

