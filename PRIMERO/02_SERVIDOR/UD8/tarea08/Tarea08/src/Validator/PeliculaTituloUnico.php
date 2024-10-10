<?php

namespace App\Validator;

use Symfony\Component\Validator\Constraint;

/**
 * @Annotation
 * @Target({"PROPERTY", "METHOD", "ANNOTATION"})
 */
#[\Attribute]
class PeliculaTituloUnico extends Constraint
{
    /*
     * Any public properties become valid options for the annotation.
     * Then, use these in your validator class.
     */
    public $message = 'El título "{{ value }}" ya está en uso.';

    public function getTargets(): string
    {
        return self::CLASS_CONSTRAINT;
    }
}
