<?php

namespace App\Controller;

use App\Service\PeliculaService;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class ListadoController extends AbstractController
{

    public function __construct(private PeliculaService $peliculaService)
    {
    }


    #[Route('/listado', name: 'app_listado')]

    public function index(Request $request): Response
    {
        $user = $this->getUser();

        if ($user == null) {

            $this->addFlash('warning', 'Usuario no se ha logueado');
            return $this->redirectToRoute('app_login');
        };

        if ($request->getMethod() === 'POST') {

            try {

                $id = $request->request->get("id");
                $this->peliculaService->deletePelicula($id, $user);

                $this->addFlash('success', 'Se ha eliminado correctamente');
            } catch (\Throwable $th) {

                $this->addFlash('warning', $th->getMessage());
            }
        }

        $pelis = $this->getListado();

        return $this->render('listado/index.html.twig', [
            'controller_name' => 'ListadoController',
            'listado' => $pelis
        ]);
    }


    public function getListado()
    {
        try {
            return $this->peliculaService->listPelicula($this->getUser());
        } catch (\Throwable $th) {
            $this->addFlash('warning', $th->getMessage());
        }
    }
}
