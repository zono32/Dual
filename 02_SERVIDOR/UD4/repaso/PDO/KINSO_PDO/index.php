<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>listado autores</title>
</head>

<body>
    <h1>Autores</h1>

    <p>
        <form action="crearAutor.php">
            <input type="submit" value="crear autor">
        </form>
    </p>


<hr>
<?php
require_once("./conexion.php");
require_once './query_autores.php';

$datosAutores = get_Authors();

foreach ($datosAutores as $key => $value) {
   $nombre = $datosAutores[$key]['first_name'];
   $apellido = $datosAutores[$key]['last_name'];
    echo ($key + 1 .".- ");
    echo ($nombre. ' ' . $apellido. '<br>');
    ?>
    <form action="modificar.php" method="post">
        <input type="hidden" name="id" id="id" value="<?php echo $value["author_id"] ?>">
        <input type="submit" value ="actializar">
    </form>
    <form action="borrar.php" method="post">
        <input type="hidden"name="id" id="id" value="<?php echo $value["author_id"] ?>">
        <input type="submit" value ="eliminar">
    </form>
    <hr>
    
    <?php
 }
/*
foreach ($datosAutores as $keys => $values) {    
    foreach ($values as $key => $value) {
       echo "". $key ." ". $value ."<br>";
    }   echo "<hr>"; 
}
*/
?>
</body>
</html>

