window.onload = () => {

    let contenedor = document.getElementById("resultado")

    let crear = document.getElementById("crear")
    let fila = document.getElementById("fila").value;
    let columna = document.getElementById("columna").value;

    crear.addEventListener('click', crearTabla);

    function crearTabla() {
         console.log("escucho");
        let tabla = document.createElement("table");
        contenedor.appendChild(tabla);
        for (let i = 0; i < fila; i++) {
            let filaTabla = document.createElement("tr");
            
            for (let j = 0; j < columna; j++) {
                let colTabla = document.createElement("td"); 
                colTabla.innerHTML = i + " - " + j;
                filaTabla.appendChild(colTabla);
            }        
        }

        tabla.style.border = "2px,solid,blue";

        
        
    }
}