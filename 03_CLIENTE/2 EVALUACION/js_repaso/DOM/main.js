window.onload = () => {

    let formProduts = document.getElementById('productos');
    formProduts.addEventListener('submit', listarProductos);

    function listarProductos(e) {
        e.preventDefault();
        let form = e.target
        // console.log(form['nombre'].value);
        
        let id = form['id'].value;
        let nombre = form['nombre'].value;
        let precio = form['precio'].value;

        let producto1 = new Producto(id, nombre, precio);

        localStorage.setItem(producto1.getId(),JSON.stringify(producto1))


    }
   

    function mostrarProducto() {
        getElementById('lista')
    }

    //mostrar producto tiene que crear una ol denro con cada elemento de localstorage
    //va a havcer referencia a un LisIten.
    

    //li.innertext =  objeto.nombre,
//li.setATRIBUTE('id', objeto.id);
/*
    for (let index = 1; index <= 10; index++) {
    
        let mesa = new Producto(index , "mesa" + index, index*2 )
    
    localStorage.setItem(mesa.getId(), JSON.stringify(mesa))
}

    let keys = Object.keys(localStorage);

    
    for (const key of keys) {

        console.log(localStorage.getItem(key));
        
    }

    console.log(localStorage.getItem(keys[2]));
    console.log(localStorage.getItem("8"));  */

    console.log(JSON.parse(localStorage.getItem("5")));
}

class Producto{
    constructor(id, nombre, precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    getNombre() {
        return this.nombre;
    }
    setNombre(nombre) {
        this.nombre = nombre;
    }

    getPrecio() {
        return this.precio;
    }
    setPrecio(precio) {
        this.precio = precio;
    }

    getId() {
        return this.id;
    }
    setId(id) {
        this.id = id;
    }
}