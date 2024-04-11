<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class RamdonControlerController extends AbstractController
{
    #[Route('/ramdon/controler', name: 'app_ramdon_controler')]
    public function index(): Response
    {
        return $this->render('ramdon_controler/index.html.twig', [
            'controller_name' => 'RamdonControlerController',
        ]);
    }
}
