<?php

namespace App\Controller;

use App\Entity\Mobile;
use App\Service\MobileService;
use DateTime;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Validator\Constraints\Date;

class MobileController extends AbstractController
{


    public function __construct(private MobileService $mobileService)
    {
    }


    #[Route('/mobile', name: 'app_mobile')]
    public function index(): Response
    {

        $this->denyAccessUnlessGranted('IS_AUTHENTICATED_FULLY');

        // returns your User object, or null if the user is not authenticated
        // use inline documentation to tell your editor your exact User class
        /** @var \App\Entity\User $user */
        $user = $this->getUser();

        if ($user == null) {

            $this->addFlash('warning', 'Usuario no logueado');
            return $this->redirectToRoute('app_login');
        };





        return $this->render('mobile/index.html.twig', [
            'controller_name' => 'MobileController',
        ]);
    }

    #[Route('/mobile/form', name: 'mobile_form')]
    public function crearMobile(Request $request): Response
    {

        try {
            $mobile = new Mobile();

            $marca = $request->request->get("marca");
            $precio = $request->request->get("precio");
            $fechaCompra = $request->request->get("fecha");

            $user = $this->getUser();

            $mobile->setMarca($marca);
            $mobile->setPrecio($precio);
            $mobile->setFechaCompra(new DateTime($fechaCompra));
            $mobile->setUsuario($user);

            $this->mobileService->create_mobile($mobile);

            $this->addFlash('success', 'Se guardó correctamente');
            //code...
        } catch (\Throwable $th) {

            $this->addFlash('warning', 'Error durante la creación');
            //throw $th;
        }




        return $this->render('mobile/index.html.twig', [
            'controller_name' => 'MobileController',
        ]);
    }
}
