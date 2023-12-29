<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Document</title>
</head>
<body>
<?php
require_once "conexion.php";
require_once "queryUser.php";

$user = usuarios();
//var_dump($user);


?>
<h1>Registrar Usuario</h1>
<br>
<form role="form" method="post">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" name="email" class="form-control" id="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" name="pwd" class="form-control" id="pwd">
  </div>
  <div class="form-group">
    <label for="pwd2">Confirm Password:</label>
    <input type="password" name="pwd2" class="form-control" id="pwd2">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
    
</body>
</html>
<?php
if (isset($_POST["email"]) && isset($_POST["pwd"]) && isset($_POST["pwd2"])){
    $email = $_POST["email"];
    $pwd = password_hash($_POST["pwd"], PASSWORD_BCRYPT);
    $pwd2 = password_hash($_POST["pwd2"],PASSWORD_BCRYPT);
    //var_dump($email, $pwd, $pwd2);
    if ($_POST["pwd"] == $_POST["pwd2"]) {
        try {
            $con = getConnection();
            $query = "INSERT INTO usuario (email, pwdhash )
            VALUES (:email, :pwd')";
            $stmt = $con->prepare($query);
            $stmt->bindValue("email", $email);
            $stmt->bindValue("pwd", $pwd);
            $stmt->execute();
            $userValue = $con->lastInsertId();
            echo "El usuario se ha creado correctamente";


        } catch (PDOException $e) {
            echo "ha ocurrido un error" . $e->getMessage();
        }
    } else
       echo "las contraseñas no coinciden";

}

/*
$password = password_hash("pepito", PASSWORD_BCRYPT);
$exito = password_verify("", $password);
var_dump($exito);
echo $password;
*/
?>