<?php

namespace ContainerXinVgOL;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\ContainerInterface;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class get_ServiceLocator_X2nWtwrService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.service_locator.x2nWtwr' shared service.
     *
     * @return \Symfony\Component\DependencyInjection\ServiceLocator
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->privates['.service_locator.x2nWtwr'] = new \Symfony\Component\DependencyInjection\Argument\ServiceLocator($container->getService ??= $container->getService(...), [
            'notaServicio' => ['privates', 'App\\Service\\NotaService', 'getNotaServiceService', true],
        ], [
            'notaServicio' => 'App\\Service\\NotaService',
        ]);
    }
}
