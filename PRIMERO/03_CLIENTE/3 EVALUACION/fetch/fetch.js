"use strict";

var div_usuarios = document.querySelector("#usuarios");
// .Ofrece una API para acceder a recursos tipicos como usuarios, mensajes de un foro y fotos

var usuarios = [];
//fetch('https://jsonplaceholder.typicode.com/users')

("use strict");
var div_usuarios = document.querySelector("#usuarios");
// .Ofrece una API para acceder a recursos tipicos como usuarios, mensajes de un foro y fotos
var usuarios = [];

let linea = document.createElement("hr");
//fetch('https://jsonplaceholder.typicode.com/users')
fetch("https://reqres.in/api/users")
  .then((data) => data.json())
  .then((users) => {
    usuarios = users.data;
    console.log(usuarios);
    //Crea un nuevo array con los resultadosde la función
    usuarios.map((user, i) => {

      let nombre = document.createElement("h2");
      
      nombre.innerHTML = i + " " + user.first_name //+ " " + user.avatar;      
      div_usuarios.appendChild(nombre);
      
      let img = document.createElement("img")
    })
    

  

    

   
  });
