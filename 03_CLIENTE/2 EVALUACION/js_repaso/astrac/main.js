class Astracta {
  constructor() {
    if (this.constructor === Astracta)
      throw new Error("La clase personaA es abstracto");
  }
  habla() {
    throw new Error(
      "Este es un método abstracto y se debe sobreescribir en las subclases"
    );
  }
}

class Persona extends Astracta {
  constructor(nombre, edad) {
    super();
    this.nombre = nombre;
    this.edad = edad;
  }

  habla() {
    console.log("habla");
  }
}

window.onload = () => {
  let fran = new Persona("frank", 30);

  fran.habla();
};
