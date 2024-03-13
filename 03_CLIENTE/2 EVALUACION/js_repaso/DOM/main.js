window.onload = () => {

    let formProduts = document.getElementById('productos');
    formProduts.addEventListener('submit', listarProductos);

    function listarProductos(e) {
        e.preventDefault();
        let dato = e.target
        // console.log(form['nombre'].value);
        
        let id = dato['id'].value;
        let nombre = dato['nombre'].value;
        let precio = dato['precio'].value;

        let producto1 = new Producto(id, nombre, precio);

        localStorage.setItem(producto1.getId(), JSON.stringify(producto1));

        mostrarProducto();


    }
    let keys = Object.keys(localStorage);
    let objectLocal = JSON.parse(localStorage.getItem('1'))
    //console.log( `es esta ${objectLocal.id}`);
    
    for (const key of keys) {
     //   console.log(JSON.parse(localStorage.getItem(key)));        
    }

    let lista = document.getElementById('lista');

    function mostrarProducto() {

        let keys = Object.keys(localStorage);
        let ul = document.createElement("ul")
            ul.setAttribute("id","lista_productos");
        for (const key of keys) {
            let producto = JSON.parse(localStorage.getItem(key));
            let product_clase = new Producto(producto.id, producto.nombre, producto.precio);
            let li = document.createElement("li");

            li.innerText = product_clase.getNombre();
            li.setAttribute("id", product_clase.getId());
            
            ul.appendChild(li);

        }

        lista.replaceChildren(ul);

    }

    lista.addEventListener('click', borrarElements)
    
    function borrarElements(e) {
        e.preventDefault();
        let datos = e.target
        console.log(datos.id);
        localStorage.removeItem(datos.id);
        mostrarProducto();
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

//console.log(JSON.parse(localStorage.getItem("5")));
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