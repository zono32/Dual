<div class="float float-right d-inline-flex mt-2">
    <i class="fa fa-shopping-cart mr-2 fa-2x"></i>
    <?php
    if ((isset($_SESSION['cesta'])) && (isset($_POST['unidades']))) {

        foreach ($_SESSION['cesta'] as $key => $value) {         
          
        }
        $unid[] = (int)$_POST['unidades'];
        $_SESSION['cesta'][$datos->id] = $unid;


        
        //var_dump($cantidad);          
        //var_dump($unid);
        $cantidad = array_sum($unid);


        //$cantidad = $cantidad * $unid;
        echo "<input type='text' disabled class='form-control mr-2 bg-transparent text-white' value='($cantidad)' size='2px'>";
    } else {
        echo "<input type='text' disabled class='form-control mr-2 bg-transparent text-white' value='0' size='2px'>";
    }

    ?>
    <i class="fas fa-user mr-3 fa-2x"></i>
    <input type="text" size='10px' value="<?php echo $_SESSION['nombre']; ?>" class="form-control
    mr-2 bg-transparent text-white" disabled>
    <a href="cerrar.php" class="btn btn-warning mr-2">Salir</a>
</div>