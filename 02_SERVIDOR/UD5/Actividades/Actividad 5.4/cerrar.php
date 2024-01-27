<?php
session_start();
unset($_SESSION['nombre']);
unset($_SESSION['cesta']);
header('Location:login.php');

cerrarSesion();
function cerrarSesion() {

    //Tal y como se recomienda en https://www.php.net/manual/es/function.session-destroy.php
    iniciarSesion();

    $_SESSION = array();

    if (ini_get("session.use_cookies")) {
        $params = session_get_cookie_params();
        setcookie(session_name(), false, time() - 42000,
                $params["path"], $params["domain"],
                $params["secure"], $params["httponly"]
        );
    }
    session_destroy();
}

function iniciarSesion(): bool {
    $iniciada = true;
    if (session_status() !== PHP_SESSION_ACTIVE) {
        $iniciada = session_start();
    }
    return $iniciada;
}