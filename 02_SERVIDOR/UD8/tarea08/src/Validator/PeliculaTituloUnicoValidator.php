<?php

namespace App\Validator;

use App\Repository\PeliculaRepository;
use Symfony\Component\Validator\Constraint;
use Symfony\Component\Validator\ConstraintValidator;

class PeliculaTituloUnicoValidator extends ConstraintValidator
{

    public function __construct(private PeliculaRepository $peliculaRepository){

    }
    public function validate($pelicula, Constraint $constraint)
    {
        /* @var PeliculaTituloUnico $constraint */
        $titulo = $pelicula->getTitulo();

        if (null === $titulo || '' === $titulo) {
            return;
        }
        

        // TODO: implement the validation here
        $peliculaConIgualTitulo = $this ->peliculaRepository->findOneBy(["titulo"=> $titulo]);
        if ($peliculaConIgualTitulo != null && $pelicula->getId() != $peliculaConIgualTitulo->getId()) {

            $this->context->buildViolation($constraint->message)
                ->setParameter('{{ value }}', $titulo)
                ->addViolation();
        }
    }
}
