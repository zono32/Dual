<script type="text/javascript">
	let obtenerUrlActual=window.location;
	console.log(obtenerUrlActual);

	//Obtener la ruta de los archivos
	var ficheroArray = obtenerUrlActual.toString().split('/');
    let long = ficheroArray.length;

    console.log("Nombre de fichero "+ficheroArray[long - 1]);

    // Obtener el nombre del fichero
    let namefichero = ficheroArray[long - 1]

    var idURL = obtenerUrlActual.toString().split(namefichero);
    console.log(idURL[0]);

    let ruta = idURL[0].toString().concat('articulos.json ');
    console.log("Acceder al fichero json "+ ruta); 
	

</script>