
const d = document;

d.addEventListener("DOMContentLoaded", e => {


    d.addEventListener("click", eventoClick);

    d.addEventListener("contextmenu", eventoClickDerecho);



})


function eventoClick(e) {



    if (e.target.matches("#btn_crear")) {
        const lista = d.getElementById("lista");

        let form = d.getElementById("formulario");
        let texto = form["texto"].value;


        if (/[0-9]+/.test(texto)) {
            alert("No se puede introducir un valor numérico");
        } else {
            let li = d.createElement("li");
            li.innerText = texto;

            lista.appendChild(li);
        }

    }


    if (e.target.matches("li")) {

        const lista = d.getElementById("lista");


        let li = e.target;

        lista.removeChild(li);

    }

}


function eventoClickDerecho(e) {

    e.preventDefault();

    if (e.target.matches("li")) {

        let li = e.target;

        li.style.backgroundColor = `rgb(${valorRandom()}, ${valorRandom()}, ${valorRandom()} )`;
        li.style.fontWeight = "bold";
        li.style.textDecoration = "line - through";

        li.style.color = "white";

        // console.log(li);

    }

}


function valorRandom() {

    // console.log(Math.random() * 255);

    return Math.round(Math.random() * 255);
}