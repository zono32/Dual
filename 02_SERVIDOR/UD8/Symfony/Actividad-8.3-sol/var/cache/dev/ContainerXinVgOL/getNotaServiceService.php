<?php

namespace ContainerXinVgOL;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\ContainerInterface;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class getNotaServiceService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private 'App\Service\NotaService' shared autowired service.
     *
     * @return \App\Service\NotaService
     */
    public static function do($container, $lazyLoad = true)
    {
        include_once \dirname(__DIR__, 4).''.\DIRECTORY_SEPARATOR.'src'.\DIRECTORY_SEPARATOR.'Service'.\DIRECTORY_SEPARATOR.'NotaService.php';

        $a = ($container->services['doctrine.orm.default_entity_manager'] ?? self::getDoctrine_Orm_DefaultEntityManagerService($container));

        if (isset($container->privates['App\\Service\\NotaService'])) {
            return $container->privates['App\\Service\\NotaService'];
        }

        return $container->privates['App\\Service\\NotaService'] = new \App\Service\NotaService($a, ($container->privates['App\\Repository\\NotaRepository'] ?? $container->load('getNotaRepositoryService')));
    }
}
