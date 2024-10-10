<?php


class Util
{

    const OPERATION_OK = 0;
    const OPERATION_NOK = 1;
    const NO_OPERATION = 2;


    /* 
     * Transforma un array asociativo en un objeto de la clase $class siempre y cuando el array y la clase tengan claves y nombres de propiedades iguales
     * El  $obj_como_array_asoc es un array asociativo como por ejemplo: 
     * array("id" => 1,
     *  "titulo" => 'Este es el titulo',
     *  "contenido" => "content..."));
     * Los nombres de las propiedades de la clase $class y de las claves del $obj_como_array_asoc deben tener el mismo nombre;
     */

    static function json_decode_array_to_class(
        array $obj_como_array_asoc,
        string $class
    ) {
        //https://www.php.net/manual/en/book.reflection.php
        //Crea una clase reflection (una representación de los datos de la clase) que entra como parámetro
        $reflection = new ReflectionClass($class);

        //Crea un objeto de la clase sin llamar al constructor
        $instance = $reflection->newInstanceWithoutConstructor();

        //Toma las propiedades de la clase:     //https://www.php.net/manual/es/reflectionclass.getproperties.php
        $properties = $reflection->getProperties();


        $claves_obj = array_keys($obj_como_array_asoc);
        //$key es clave numérica, $property es un objeto ReflectionProperty https://www.php.net/manual/es/class.reflectionproperty.php#reflectionproperty.constants.modifiers

        foreach ($properties as $key => $property) {
            //no necesario a partir  php8.1
            $property->setAccessible(true);

            if (in_array($property->getName(), $claves_obj)) {
                //Establecemos en el objeto de $class, la propiedad con el mismo nombre  de la clave de $obj_como_array_asoc

                if (($property->getName() == "updatedAt") || ($property->getName() == "createdAt")) {
                    $fecha = null;
                    if ($obj_como_array_asoc[$property->getName()] != null) {
                        $fecha = DateTimeImmutable::createFromFormat('Y-m-d\TH:i:sO', $obj_como_array_asoc[$property->getName()]);
                    }
                    $property->setValue($instance, $fecha);


                } else {
                    $property->setValue(
                        $instance,
                        $obj_como_array_asoc[$property->getName()]
                    );
                }
            }
        }
        return $instance;
    }

}
