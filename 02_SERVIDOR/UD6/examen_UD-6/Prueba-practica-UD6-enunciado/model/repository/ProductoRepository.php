<?php


/**
 * Description of UsuarioRepository
 *
 * @author wadmin
 */
class ProductoRepository extends BaseRepository implements IProductoRepository{
    public function __construct()
    {
        parent::__construct();

        $this->table_name = "productos";
        $this->pk_name = "id";
        $this->class_name = "producto";
        $this->default_order_column = "nombre";        

    }

    public function create($object)
    {
        return null;
    }
    public function update($object): bool
    {
        return false;
    }

}