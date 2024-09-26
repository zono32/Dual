<?php

namespace App\Service;

use App\Entity\Pelicula;
use App\Repository\PeliculaRepository;
use Doctrine\ORM\EntityManagerInterface;

class PeliculaService
{
    //Constructor Promotion : https://www.php.net/manual/en/language.oop5.decon.php#language.oop5.decon.constructor.promotion
    public function __construct(private EntityManagerInterface $entityManagerInterface, private PeliculaRepository $PeliculaRepository){

    }
    public function create(Pelicula $pelicula){
        if($pelicula->getFechaEstreno()==null){
            $pelicula->setFechaEstreno(new \DateTime());
        }
        $this->entityManagerInterface->persist($pelicula);
        $this->entityManagerInterface->flush();
    }

    public function listPelicula($user): array{
        return $this->PeliculaRepository->listPelicula($user);

    }

    public function findPelicula(int $id): ?Pelicula{
        return $this->PeliculaRepository->find($id);

    }

    public function deletePelicula($id, $user)
    {
        $this->PeliculaRepository->deletePelicula($id, $user);
    }
}