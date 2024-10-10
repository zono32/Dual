

window.onload = () => {
    document.addEventListener("click", e => {
    
        e.preventDefault();
    
        if (e.target.matches("#formulario")) {      
            
    
            let valor = document.getElementById("texto");
            
            let texto =(valor.value);
            console.log(texto);
            if (!isNaN(texto)) {
                alert("Por favor no introduzca numeros")            
            }
    
            else {            
                let lista =document.getElementById("lista")
                let li = document.createElement("li")
                li.innerHTML = texto;
                lista.appendChild(li)  
                //texto.reset();
            }
           
        }    
    
        const lista = document.getElementById("lista")
    
            let li = e.target;
    
            if(e.target.matches("li"))
            lista.removeChild(li)
          
    
       
    })
    document.addEventListener("contextmenu", botonDerecho);
    function botonDerecho(e) {
        e.preventDefault();
        let li = e.target;
        if (e.target.matches("li")) {
            li.style.backgroundColor = "red";
            li.style.color = "white";
        }
    }

}



