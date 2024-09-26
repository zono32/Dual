<?php

namespace App\Entity;

use App\Repository\PeliculaRepository;
use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Validator as AppValidator;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity(repositoryClass: PeliculaRepository::class)]
#[AppValidator\PeliculaTituloUnico]

class Pelicula
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 40)]
    private ?string $titulo = null;

    #[ORM\Column]
    private ?float $duracion = null;

    #[ORM\Column(type: Types::DATE_MUTABLE)]
    private ?\DateTimeInterface $fechaEstreno = null;

    #[ORM\ManyToOne(inversedBy: 'peliculas')]
    #[ORM\JoinColumn(nullable: false)]
    private ?User $usuario = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTitulo(): ?string
    {
        return $this->titulo;
    }

    public function setTitulo(string $titulo): static
    {
        $this->titulo = $titulo;

        return $this;
    }

    public function getDuracion(): ?float
    {
        return $this->duracion;
    }

    public function setDuracion(float $duracion): static
    {
        $this->duracion = $duracion;

        return $this;
    }

    public function getFechaEstreno(): ?\DateTimeInterface
    {
        return $this->fechaEstreno;
    }

    public function setFechaEstreno(\DateTimeInterface $fechaEstreno): static
    {
        $this->fechaEstreno = $fechaEstreno;

        return $this;
    }

    public function getUsuario(): ?User
    {
        return $this->usuario;
    }

    public function setUsuario(?User $usuario): static
    {
        $this->usuario = $usuario;

        return $this;
    }
}
