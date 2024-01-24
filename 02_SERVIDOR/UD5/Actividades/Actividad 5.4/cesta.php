<?php
session_start();
if (!isset($_SESSION['nombre'])) {
    header('Location:login.php');
}
require_once 'conexion.php';
if (isset($_SESSION['cesta'])) {
    foreach ($_SESSION['cesta'] as $k => $v) {
        $producto = consultarProducto($k);
        $listado[$k] = [$producto->nombre, $producto->pvp];
        $producto = null;
    }
    cerrar($conProyecto);
}

?>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- css para usar Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- css Fontawesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Cesta de la compra</title>
</head>
<body style="background: gray">
<?php
require_once('utils.php');
?>
<div class="container mt-3">
    <div class="card text-white bg-success mb-3 m-auto" style="width:40rem">
        <div class="card-body">
            <h5 class="card-title"><i class="fa fa-shopping-cart mr-2"></i>Carrito</h5>
            <?php
            if (!isset($_SESSION['cesta'])) {
                echo "<p class='card-text'>Carrito Vacio</p>";
            } else {
                $total = 0;
                echo "<p class='card-text'>";
                echo "<ul>";
                foreach ($listado as $k => $v) {
                    echo "<li>$v[0], PVP ($v[1]) €.</li>";
                    $total += $v[1];
                }
                echo "</ul></p>";
                echo "<hr style='border:none; height:2px; background-color: white'>";
                echo "<p class='card-text'><b>Total:</b><span class='ml-3'>$total (€)</span></p>";
            }
            ?>
            <a href="listado.php" class="btn btn-primary mr-2">Volver</a>
            <a href="pagar.php" class="btn btn-danger">Pagar</a>
        </div>
    </div>
</div>
</body>
</html>

