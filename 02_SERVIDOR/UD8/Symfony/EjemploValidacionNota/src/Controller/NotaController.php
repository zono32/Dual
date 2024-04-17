<?php

namespace App\Controller;

use App\Entity\Nota;
use App\Service\NotaService;
use DateTime;
use Doctrine\ORM\EntityManagerInterface;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Validator\Validator\ValidatorInterface;

class NotaController extends AbstractController
{
    // #[Route('/nota/new', name: 'app_nota_new')]
    // public function new(EntityManagerInterface $entityManager): Response
    // {
    //     $nota = new Nota();
    //     $nota->setTitulo("Mi primera nota");
    //     $nota->setDescripcion("bla bla");
    //     $nota->setFechaModificacion(new DateTime());

    //     $entityManager->persist($nota);


    //     $entityManager->flush();

    //     return $this->render('nota/index.html.twig', [
    //         'controller_name' => 'NotaController',
    //         'nota' => $nota
    //     ]);
    // }


    // #[Route('/nota/new', name: 'app_nota_new')]
    // public function new(NotaService $notaService): Response
    // {
    //     $nota = new Nota();
    //     $nota->setTitulo("Mi primera nota");
    //     $nota->setDescripcion("bla bla");
    //     $nota->setFechaModificacion(new DateTime());

    //     $notaService->create($nota);

    //     return $this->render('nota/index.html.twig', [
    //         'controller_name' => 'NotaController',
    //         'nota' => $nota
    //     ]);
    // }

     #[Route('/nota/new', name: 'app_nota_new')]
    public function new(Request $request, NotaService $notaService, ValidatorInterface $validator): Response
    {
        $nota = new Nota();
        if($request->getMethod()=="POST"){
            $titulo = $request->request->get('titulo');
            $desc = $request->request->get('desc');         
            $nota->setTitulo($titulo);
            $nota->setDescripcion($desc);

            $errores = $validator->validate($nota);
            if(count($errores)>0){
                foreach ($errores as $error) {
                    $this->addFlash('danger', 'Se ha producido un error: '. $error->getMessage());
                }              
            }
            else{
                $notaService->create($nota);
                $this->addFlash('success', 'Se ha creado la nota con éxito');
                return $this->redirectToRoute('app_nota_list');
            }
        }
        return $this->render('nota/crear.html.twig', [            
            'nota' => $nota
        ]);
    }

    #[Route('/nota', name: 'app_nota_list')]
    public function list(NotaService $notaServicio):Response{
        $notas = $notaServicio->list();
        return $this->render(
            'nota/list.html.twig',
            ['notas' => $notas]
        );


    }

    #[Route('/nota/{id}', name: 'app_nota_show')]
    public function show(Nota $nota): Response
    {
        $this->addFlash('warning', 'Hemos encontrado la nota');

        return $this->render(
            'nota/detail.html.twig',
            ['nota' => $nota]
        );
    }
}
