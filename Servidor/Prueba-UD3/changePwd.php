<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHPWebPage.php to edit this template
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Change password</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>

        <div class="container-fluid">
            <h1>Cambio de contraseña</h1>
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

                        <!-- New Password input 1-->
                        <div class="form-group mb-4">
                            <label class="form-label" for="newPwd1">Nueva contraseña</label>
                            <input type="password" id="newPwd1" class="form-control" name="newPwd1" required/>

                        </div>

                        <!-- New Password input 2-->
                        <div class="form-group mb-4">
                            <label class="form-label" for="newPwd2">Repita nueva contraseña</label>
                            <input type="password" id="newPwd2" class="form-control" name="newPwd2" required/>

                        </div>

                        <!-- Submit button -->
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Cambiar contraseña"></button>


                    </form>

                    <?php
                    require_once"util.php";
                   
                    const MIN_LENGH = 6;
                    $usuarios = array("user1@edu.es" => array("pwd" => "Abc123.", "pwd-1" => "aBc123.", "pwd-2" => "aBc123."),
                        "user2@edu.es" => array("pwd" => "123Abc.", "pwd-1" => "123aBc.", "pwd-2" => "123abC."),
                        "user3@edu.es" => array("pwd" => "123Abc.", "pwd-1" => "123aBc.", "pwd-2" => "123abC."));
                    $simbolos = [".", "?", "@"];
                  
                    $numeros = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

                    const USER_DOES_NOT_EXIST = "No existe usuario";
                    const PWD_INCORRECT = "La contraseña no es correcta";
                    const PWD_MISMATCH = "Las contraseñas no coinciden";
                    const MIN_LENGTH_ERROR = "La longitud mínima es " . MIN_LENGH;
                    const PWD_USED = "La contraseña es una de las 2 últimas utilizadas";
                    const UPPER_CASE_NEEDED = "La nueva contraseña debe contener al menos una letra mayúscula";
                    const NUMBER_NEEDED = "La nueva contraseña debe contener al menos un número";
                    const SYMBOL_NEEDED = "La nueva contraseña debe contener al menos un símbolo: ";

                  

                    if (isset($_POST["email"])) {
                        $email = $_POST["email"];
                        $pass = $_POST["pwd"];
                        $newpass = $_POST["newPwd1"];
                        $newpass2 = $_POST["newPwd2"];

                        // echo $usuarios[$email]["pwd"];
                        //  echo $_POST["pwd"];
    
                                             
                        if( !comprobar_email($email)){
                            echo '<div class="alert alert-danger" role="alert">';
                            echo USER_DOES_NOT_EXIST;
                            echo '</div>';
                        } elseif (!comprobar_pass($pass)) {
                            echo '<div class="alert alert-danger" role="alert">';
                            echo PWD_INCORRECT;
                            echo '</div>';
                        }elseif( !contraseñas_nuevas_iguales($newpass , $newpass2)){
                                echo '<div class="alert alert-danger" role="alert">';
                                echo PWD_MISMATCH;
                                echo '</div>';
                        } elseif (strlen($newpass)<6) {
                            echo '<div class="alert alert-danger" role="alert">';
                            echo MIN_LENGTH_ERROR;
                            echo '</div>';
                        }elseif (!comparar_nueva_contraseña_con_anteriores($newpass)) {
                            echo '<div class="alert alert-danger" role="alert">';
                            echo PWD_USED;
                            echo '</div>';
                        }elseif (!comprobar_mayuscula($newpass)) {
                            echo '<div class="alert alert-danger" role="alert">';
                            echo UPPER_CASE_NEEDED;
                            echo '</div>';
                        }elseif (!comprobar_numero($newpass)) {
                            echo '<div class="alert alert-danger" role="alert">';
                            echo NUMBER_NEEDED;
                            echo '</div>';
                        }elseif (!comprobar_simbolo($newpass)) {
                            echo '<div class="alert alert-danger" role="alert">';
                            echo SYMBOL_NEEDED;
                            echo '</div>';
                        }

                        else{
                            $usuarios[$email]['pwd-2'] = $usuarios[$email]['pwd-1'];
                            $usuarios[$email]['pwd-1'] = $usuarios[$email]['pwd'];
                            $usuarios[$email]['pwd'] = $_POST["newPwd1"];
                           
                           

                            echo '<div class="alert alert-success" role="alert">';
                            echo " Se ha actualizado correctamente la contraseña";
                            foreach ($usuarios[$email] as $key => $value){
                                print_r ( ' '. $value.' ');
                            };
                            echo '</div>';
                        }
                    }
                    
                    ?> 
                </div>
            </div>
        </div>


    </body>
</html>

