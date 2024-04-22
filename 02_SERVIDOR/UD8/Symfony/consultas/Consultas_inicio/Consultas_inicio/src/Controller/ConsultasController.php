<?php

namespace App\Controller;

use App\Repository\AutorRepository;
use App\Service\ConsultasService;
use DateTime;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class ConsultasController extends AbstractController
{

    public function __construct(private ConsultasService $consultasService) {
        
    }

    #[Route('/consultas/{fecha}', name: 'app_consultas')]
    public function index(DateTime $fecha ):Response
    {

        $autores =$this->consultasService->getAutoresByFechaNac($fecha);

        return $this->render('consultas/index.html.twig', [
            'controller_name' => 'ConsultasController',
            'autores' => $autores
        ]);
    }
    
    #[Route('/consultas/autores/{unidades}', name: 'app_consultas')]
    public function getAutoresByUnidades(int $unidades ):Response
    {

        $autores =$this->consultasService->getAutoresByUnidades($unidades);

        return $this->render('consultas/index.html.twig', [
            'controller_name' => 'ConsultasController',
            'autores' => $autores
        ]);
    }
}
