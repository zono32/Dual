<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Document</title>
</head>
<body>

<table class="table">// si existe
  <thead class="thead-dark">
    <tr>
      <th scope="col">Cookie name</th>
      <th scope="col">Cookie value</th>      
    </tr>
  </thead>
  <tbody>

    
      <?php   
      function mostrarTabla(){
        
            if($_COOKIE > 0){
                foreach ($_COOKIE as $key => $value) {
                    "<tr>";
                        "<td>".$key."</td>";
                        "<td>".$value."</td>";
                    "</tr>";
                }   
            }
        
        }
      ?>
        
     
  </tbody>
</table>

<form action="" method="post">
    <input type="submit" name="borrar" id="borrar" value="borrar Cookies">
</form>

<?php 
if ( isset($_POST["borrar"])){    
    var_dump($_COOKIE);

    foreach ($_COOKIE as $key => $value) {
        setcookie($key, "", -1 );        
    }
    header("location: cookies.php");//aqui recarga la pagina y la muestra si la tabla
    exit;
};
?>
    
</body>
</html>


