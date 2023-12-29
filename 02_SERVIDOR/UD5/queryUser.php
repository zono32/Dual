<?php

require_once "conexion.php" ;

function usuarios()
{
    try{
        $con = getConnection();
        $query = " SELECT `usuario`.`id`,
        `usuario`.`email`,
        `usuario`.`pwdhash`
        FROM `notas`.`usuario`";
        $stmt = $con->prepare($query);
        $stmt->execute();
        $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
        return $result;
    }
    catch(PDOException $e)
    {
        echo "ha ocurrido un erros".$e->getMessage();
    }
   

}
?>