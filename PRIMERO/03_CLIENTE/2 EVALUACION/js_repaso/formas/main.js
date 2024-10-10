

window.onload = () => {
    
    let cuadrado = new Cuadrado("cuadrado1");
    let triangulo = new Triangulo("triangulo");

    cuadrado.dibujar();
    triangulo.dibujar();

}

class Forma{

    constructor(nombre, lados ,coordenadas) {
        this.nombre = nombre;
        this.lados = lados;
        this.coordenadas = coordenadas;
        if (this.constructor === Forma) {
            throw new Error("la clase es astracta");
        }
    }
    dibujar() {
        throw new Error("el metodo es astracto y se debe implementar");
    }
}

class Cuadrado extends Forma{
    constructor(nombre,lados ,coordenadas) {
        super(nombre,lados ,coordenadas);       
    }
    dibujar() {
        console.log("has dibujado un "+ this.nombre);
    }
}
class Triangulo extends Forma {
    constructor(nombre,lados ,coordenadas) {
        super(nombre,lados ,coordenadas);
    }
    dibujar() {
        console.log("has dibujado un " + this.nombre);
    }
}