<?php

namespace ContainerBLeurfX;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\ContainerInterface;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class get_ServiceLocator_2iUWbMvService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.service_locator.2iUWbMv' shared service.
     *
     * @return \Symfony\Component\DependencyInjection\ServiceLocator
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->privates['.service_locator.2iUWbMv'] = new \Symfony\Component\DependencyInjection\Argument\ServiceLocator($container->getService ??= $container->getService(...), [
            'notaService' => ['privates', 'App\\Service\\NotaService', 'getNotaServiceService', true],
            'validator' => ['privates', 'debug.validator', 'getDebug_ValidatorService', false],
        ], [
            'notaService' => 'App\\Service\\NotaService',
            'validator' => '?',
        ]);
    }
}
