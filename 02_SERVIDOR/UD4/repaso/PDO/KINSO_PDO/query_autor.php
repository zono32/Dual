<?php

    require_once('./conexion.php');              

    function datosAutor($id)
    {

        try {
            $conn = getConnection();
            $query = "SELECT * FROM authors WHERE author_id= :id";
            $stmt = $conn->prepare($query);
            $stmt->bindParam("id", $id);
            $stmt->execute();
            
            $resultado = $stmt->fetchAll();
            return $resultado;

        } catch (PDOException $e) {
            echo "ha ocurrido un eror" . $e->getMessage();
        }
    }