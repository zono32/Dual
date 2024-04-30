window.onload = () => {
    
    let img1 = document.getElementById("img1");
    let img2 = document.getElementById("img2");
    let img3 = document.getElementById("img3");

    let flag = true;

    function cambio() {
        
        if (flag) {            
            img1.src = "/Recursos/Ejercicio1/2.JPG";
            img2.src = "/Recursos/Ejercicio1/4.JPG";
            img3.src = "/Recursos/Ejercicio1/6.JPG"; 
            
        } else {
            img1.src = "/Recursos/Ejercicio1/1.JPG";
            img2.src = "/Recursos/Ejercicio1/3.JPG";
            img3.src = "/Recursos/Ejercicio1/5.JPG";            
        }     
        
        flag = !flag; 
    }
        //setTimeout(cambio, 1000);
        setInterval(cambio, 1000);

   
        let img4 = document.getElementById("img4");
        let img5 = document.getElementById("img5");
        let img6 = document.getElementById("img6");
    
    
    document.addEventListener("mouseover", cambio2);

    function cambio2(e) {

        if (e.target.matches("#img4")) {
            console.log("escucho")
            img4.src = "/Recursos/Ejercicio1/8.JPG";
       }
        console.log("escucho")
        img4.src = "/Recursos/Ejercicio1/8.JPG";
        img5.src = "/Recursos/Ejercicio1/10.JPG";
        img6.src = "/Recursos/Ejercicio1/12.JPG"; 
    }
}