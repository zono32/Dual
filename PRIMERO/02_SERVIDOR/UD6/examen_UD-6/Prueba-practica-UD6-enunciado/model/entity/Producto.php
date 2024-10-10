<?php

class Producto
{

    use ViewData;

    private int $id = null;
    private string $nombre = "";
    private string $nombre_corto  = "";
    private string $descripcion  = "";
    private float $PVP  = 0;
    private int $familia = null;
    



    /**
     * Get the value of id
     */ 
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set the value of id
     *
     * @return  self
     */ 
    public function setId($id)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * Get the value of nombre
     */ 
    public function getNombre()
    {
        return $this->nombre;
    }

    /**
     * Set the value of nombre
     *
     * @return  self
     */ 
    public function setNombre($nombre)
    {
        $this->nombre = $nombre;

        return $this;
    }

    /**
     * Get the value of nombre_corto
     */ 
    public function getNombre_corto()
    {
        return $this->nombre_corto;
    }

    /**
     * Set the value of nombre_corto
     *
     * @return  self
     */ 
    public function setNombre_corto($nombre_corto)
    {
        $this->nombre_corto = $nombre_corto;

        return $this;
    }

    /**
     * Get the value of descripcion
     */ 
    public function getDescripcion()
    {
        return $this->descripcion;
    }

    /**
     * Set the value of descripcion
     *
     * @return  self
     */ 
    public function setDescripcion($descripcion)
    {
        $this->descripcion = $descripcion;

        return $this;
    }

    /**
     * Get the value of PVP
     */ 
    public function getPVP()
    {
        return $this->PVP;
    }

    /**
     * Set the value of PVP
     *
     * @return  self
     */ 
    public function setPVP($PVP)
    {
        $this->PVP = $PVP;

        return $this;
    }

    /**
     * Get the value of familia
     */ 
    public function getFamilia()
    {
        return $this->familia;
    }

    /**
     * Set the value of familia
     *
     * @return  self
     */ 
    public function setFamilia($familia)
    {
        $this->familia = $familia;

        return $this;
    }




}