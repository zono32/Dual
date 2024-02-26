<?php

class UsuarioRepository extends BaseRepository implements IUsuarioRepository{


    public function __construct(){
        parent::__construct();
        $this->table_name = "usuario";
        $this->pk_name = "id";
        $this->class_name = "Usuario";        
        $this->default_order_column = "nombre";

    }
    public function findUsuarioByEmail($email): Usuario    {
        $stmt = $this->conn->prepare("SELECT id, email, pwdhash FROM usuario WHERE email = ?");
        $stmt->execute([$email]);
        $row = $stmt->fetch(PDO::FETCH_ASSOC);

        if (!$row) {
            return null; // El usuario no fue encontrado
        }

        $usuario = new Usuario();
        $usuario->setId($row['id']);
        $usuario->setEmail($row['email']);
        $usuario->setPwdhash($row['pwdhash']);
        // Puedes cargar los roles del usuario aquí si también los tienes en la base de datos

        return $usuario;
    }

    public function update($object): bool{
       return true;

    }
    public function create($object){        
            return null;
    }

   
}


