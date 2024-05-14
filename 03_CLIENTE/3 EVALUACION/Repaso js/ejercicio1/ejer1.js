document.addEventListener("DOMContentLoaded", e => {
    document.addEventListener("click", eventoClick);

    document.addEventListener("contextmenu", eventoClickBotonDerecho)
})

function eventoClick(e) {

    let lista = document.getElementById("lista");

    if (e.target.matches("#btn_crear")) {
        let form = document.getElementById("formulario");
        let texto = form["texto"].value.trim();

        if (isNaN(texto)) {

            let li = document.createElement("li");
            li.innerHTML = texto;
            lista.appendChild(li);
            
        } else if (texto === "") {
            alert(" por favor introduce un dato correcto")
        } else {
            alert("no números")
        }
        form.reset();
       
    } texto.focus();
    

    if (e.target.matches("li")) {
        
        let li = e.target;
        lista.removeChild(li)
    }

    
}

let eventoClickBotonDerecho =(e) => {
    
    e.preventDefault();
    if (e.target.matches("li")) {
        
        let li = e.target;
        li.style.backgroundColor = `rgb(${numeroAleatorio()},${numeroAleatorio()},${numeroAleatorio()})`;
        li.style.color = "white";
        li.style.fontSize = "20px";
        li.style.textDecoration = "line-through";

    }

}

function numeroAleatorio() {
    
    return( Math.round(Math.random() *255))
}