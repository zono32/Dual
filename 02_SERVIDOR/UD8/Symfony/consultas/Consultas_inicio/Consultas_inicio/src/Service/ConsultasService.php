<?php
namespace App\Service;

use App\Repository\AutorRepository;
use DateTime;

class ConsultasService
{

    public function __construct(private AutorRepository $autorRepository)
    {
    }

    public function getAutoresByFechaNac(DateTime $fecha){
        return $this->autorRepository->findByFechaNac($fecha);
    }

    public function getAutoresByUnidades(int $unidades){
        return $this->autorRepository->findByVentas($unidades);
    }
}
