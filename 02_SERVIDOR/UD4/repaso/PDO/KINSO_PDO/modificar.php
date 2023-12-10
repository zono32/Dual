<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>modificar Autor</title>
    </head>
    <body>         

    <?php 
    require_once "./query_autor.php";
    //var_dump($_POST);
    $id_autor = $_POST['id'];

    //echo ($id_autor);

    $autor = datosAutor($id_autor);
   //var_dump($autor);
    ?>

        <form action="modificar_datos_autor.php" method="post">

        <input type="hidden" name="id" id="id" value= "<?php echo $autor[0]['author_id'];?>">

            <p>
                <label for="nombre">Nombre del Autor: </label>
                <input type="text" name="nombre" value= "<?php echo $autor[0]['first_name']?> " >
            </p>
            <p>
                <label for="apellido1">Primer apellido: </label>
                <input type="text" name="apellido1"  value= "<?php echo $autor[0]['middle_name']?> ">
            </p>
            <p>
                <label for="apellido2">Segundo apellido: </label>
                <input type="text" name="apellido2" value= "<?php echo $autor[0]['last_name']?> ">
            </p>
            <p>
                <label for="cumpleaños">cumpleaños del Autor: </label>
                <input type="date" name="cumple" value= "<?php echo $autor[0]['birth_date']?> "> 
            </p>
            <input type="submit" value= "modificar">
            <br> 
        </form>

        <form action="index.php">
            <input type="submit" value= "cancelar"> 
        </form>
        
    </body>
</html>