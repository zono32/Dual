<?php

namespace ContainerBLeurfX;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\ContainerInterface;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class getNotaService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.errored..service_locator.hwuC0IP.App\Entity\Nota' shared service.
     *
     * @return \App\Entity\Nota
     */
    public static function do($container, $lazyLoad = true)
    {
        throw new RuntimeException('Cannot autowire service ".service_locator.hwuC0IP": it needs an instance of "App\\Entity\\Nota" but this type has been excluded in "config/services.yaml".');
    }
}