<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class TableController extends AbstractController
{
    #[Route('/table/{fil<([1-9]+\d*)>}/{col<([1-9]+\d*)>}', name: 'app_table',)]

    //requirements:['fil' =>'expresion regular',
    //'col' => 'expresion regular' ]
    public function crearTabla(int $fil = 4, int $col =4): Response
    {
        $valuesTable = [];

        for($i= 0 ; $i < $fil; $i++) {
            for ($j = 0; $j < $col; $j++){
                $valuesTable[$i] = random_int(0, 100); 
            }                
        }
            
        return $this->render('table/index.html.twig', [
            'controller_name' => 'TableController',
        ]);
    }
}
