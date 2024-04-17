<?php

namespace App\Service;

use App\Entity\Nota;
use App\Repository\NotaRepository;
use DateTime;
use Doctrine\ORM\EntityManagerInterface;

class NotaService
{


    // Constructor promotion
    //https://www.php.net/manual/en/language.oop5.decon.php#language.oop5.decon.constructor.promotion

    //$entityManager es una propiedad privada de la clase
    public function __construct(private EntityManagerInterface $entityManager, private NotaRepository $repo)
    {
    }
    public function create(Nota $nota)
    {
        if($nota->getFechaModificacion()==null){
            $nota->setFechaModificacion(new DateTime());
        }
        $this->entityManager->persist($nota);
        $this->entityManager->flush();
    }

    public function list()
    {
        //return $this->repo->findAll();
        return $this->entityManager->getRepository(Nota::class)->findAll();
    }
}
