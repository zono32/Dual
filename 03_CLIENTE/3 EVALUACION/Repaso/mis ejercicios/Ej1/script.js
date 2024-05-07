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

        if (e.target.matches("segundaFila")) {
            if (flag) {
                img4.src = "/Recursos/Ejercicio1/8.JPG";
                img5.src = "/Recursos/Ejercicio1/10.JPG";
                img6.src = "/Recursos/Ejercicio1/12.JPG";
            
            } else {
                img4.src = "/Recursos/Ejercicio1/7.JPG";
                img5.src = "/Recursos/Ejercicio1/9.JPG";
                img6.src = "/Recursos/Ejercicio1/11.JPG";               
            }
            flag = !flag;
        }
       
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const topImages = document.querySelectorAll('.top-row img');
    const bottomImages = document.querySelectorAll('.bottom-row img');
    
    let isAltSet = false;

    function switchImages() {
        const topImagePaths = isAltSet
            ? ['/Recursos/Ejercicio1/2.JPG', '/Recursos/Ejercicio1/4.JPG', '/Recursos/Ejercicio1/6.JPG']
            : ['/Recursos/Ejercicio1/1.JPG', '/Recursos/Ejercicio1/3.JPG', '/Recursos/Ejercicio1/5.JPG'];

        const bottomImagePaths = isAltSet
            ? ['/Recursos/Ejercicio1/8.JPG', '/Recursos/Ejercicio1/10.JPG', '/Recursos/Ejercicio1/12.JPG']
            : ['/Recursos/Ejercicio1/7.JPG', '/Recursos/Ejercicio1/9.JPG', '/Recursos/Ejercicio1/11.JPG'];

        topImages.forEach((img, index) => {
            img.src = topImagePaths[index];
        });

        bottomImages.forEach((img, index) => {
            img.src = bottomImagePaths[index];
        });

        isAltSet = !isAltSet;
    }

    // Cambia automáticamente las imágenes en la fila superior
    setInterval(switchImages, 1000);

    // Añade evento de mouseover a la fila superior para cambiar imágenes de la fila inferior
    const topRow = document.querySelector('.top-row');
    topRow.addEventListener('mouseover', event => {
        const target = event.target;
        
        if (topImages.includes(target)) {
            switchImages();
        }
    });
});
