<?php

class UsuarioRepository extends BaseRepository implements IUsuarioRepository{


    public function __construct(Usuario $usuario)
    {
        $this->table_name = "usuario";
        $this->pk_name = "id";
        $this->class_name = "Usuario";        
        $this->default_order_column = "nombre";

    }

   
}