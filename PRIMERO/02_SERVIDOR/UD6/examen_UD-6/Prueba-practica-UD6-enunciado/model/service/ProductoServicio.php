<?php
class ProductoServicio
{

    private IProductoRepository $productoRepository;

    public function __construct()
    {
        $this->productoRepository = new ProductoRepository();
    }
    public function list()
    {
        return $this->productoRepository->findAll();

    }
    public function delete($id)
    {
        return $this->productoRepository->delete($id);

    }
}