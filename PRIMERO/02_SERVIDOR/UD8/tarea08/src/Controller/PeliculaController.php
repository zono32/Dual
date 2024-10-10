<?php

namespace App\Controller;

use App\Entity\Pelicula;
use App\Service\PeliculaService;
use DateTime;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Validator\Validator\ValidatorInterface;

class PeliculaController extends AbstractController
{

    public function __construct(private PeliculaService $peliculaService){}

    #[Route('/pelicula', name: 'app_pelicula')]
    public function index(): Response
    {
        

        $this->denyAccessUnlessGranted('IS_AUTHENTICATED_FULLY');

        // returns your User object, or null if the user is not authenticated
        // use inline documentation to tell your editor your exact User class
        /** @var \App\Entity\User $user */
        $user = $this->getUser();

        if ($user == null){
            $this->addFlash('warning', 'Usuario no logueado');
            return $this->redirectToRoute('app_login');
        }
        return $this->render('pelicula/index.html.twig',[
            'controler_name'=>'PeliculaControler',
        ]);


    }
    #[Route('/pelicula/form', name: 'pelicula_form')]

    
    public function crearPelicula(Request $request, ValidatorInterface $validator): Response
    {
        $user = $this->getUser();
        try {
            if ($user == null){
                $this->addFlash('warning', 'Usuario no logueado');
                return $this->redirectToRoute('app_login');
            }
            else{
                $pelicula = new Pelicula();
                $titulo = $request->request->get("titulo");
                $duracion = $request->request->get("duracion");
                $fechaEstreno = $request->request->get("fecha"); 

                $user = $this->getUser();
                
                $pelicula->setTitulo($titulo);
                $pelicula->setDuracion($duracion);
                $pelicula->setFechaEstreno(new DateTime($fechaEstreno));
                $pelicula->setUsuario($user);

                $errors= $validator->validate($pelicula);

                if (count($errors)> 0) {

                   foreach ($errors as $error) {
                    # code...
                        $this->addFlash("warning",$error->getMessage());
                   }           
                }
                else{ 
                    $this->peliculaService->create($pelicula);
                    $this->addFlash('success', 'Se ha creado correctamente');
                    //return $this->redirectToRoute('_profiler_home');
                }
            }
        } 
        catch (\Throwable $e) {
            $this->addFlash('warning', 'Error durante la creación');
        }
    
        return $this->render('pelicula/index.html.twig', [
            'controller_name' => 'PeliculaControler',
        ]);
    }
    
}
