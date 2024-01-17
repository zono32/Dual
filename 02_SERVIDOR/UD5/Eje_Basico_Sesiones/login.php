<?php ob_start();
  require_once 'util.php';?>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Login page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <?php
        if(isUserLoggedIn()){
            header("Location: welcome.php");
            exit;
        }
        ?>

        <div class="container-fluid">
            <h1>Login</h1>
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-6">
                    <form method="post">
                        <!-- Email input -->
                        <div class="form-group mb-4 ">
                            <label class="form-label" for="email">Email address</label>
                            <input type="email" id="email" class="form-control" name="email"  required/>

                        </div>

                        <!-- Current Password input -->
                        <div class="form-group mb-4">
                            <label class="form-label" for="currentPwd">Contraseña actual</label>
                            <input type="password" id="currentPwd" class="form-control" name="pwd" required/>

                        </div>



                        <!-- Submit button -->
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Iniciar sesión"></button>


                    </form>

                    <?php
                  

                    $usuarios = array("user1@edu.es" => array("pwd" => "abc123.", "pwd-1" => "aBc123.", "pwd-2" => "abC123."),
                        "user2@edu.es" => array("pwd" => "abc123.", "pwd-1" => "123aBc.", "pwd-2" => "123abC."));

                    const USER_DOES_NOT_EXIST = "No existe usuario";
                    const PWD_INCORRECT = "La contraseña no es correcta";

                    $exito = false;

                    $errors = array();
                    $user = "";

                    if (isset($_POST["email"]) && isset($_POST["pwd"])) {
                        $user = $_POST["email"];
                        $pwd = $_POST["pwd"];

                        if (!existeUser($user, $usuarios)) {
                            array_push($errors, PWD_INCORRECT . " o " . USER_DOES_NOT_EXIST);
                        } elseif (!login($user, $pwd, $usuarios)) {
                            array_push($errors, PWD_INCORRECT . " o " . USER_DOES_NOT_EXIST);
                        } else {
                            iniciarSesion();
                            $_SESSION["user"] = $user;
                            $_SESSION["ultimoAcceso"]=time();                                    
                            header('Location: welcome.php');
                            exit;
                        }
                    }
                    ?>


                    <?php if (count($errors) > 0) { ?>
                        <div class="alert alert-danger" role="alert">
                            <?php
                            foreach ($errors as $error) {
                                echo $error . "<br/>";
                            }
                            ?>
                        </div>
                    <?php } ?>

                    <?php if ($exito) { ?>
                        <div class="alert alert-success" role="alert">
                            Se ha actualizado correctamente la contraseña <?php print_r($usuarios[$user]) ?>
                        </div>
                        <?php
                    }
                   
                    ?>
                </div>
            </div>
        </div>


    </body>
</html>
<?php  ob_end_flush();?>

