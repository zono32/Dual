
<?php
$password = password_hash("pepito", PASSWORD_BCRYPT);
$exito = password_verify("", $password);
var_dump($exito);
echo $password;
?>