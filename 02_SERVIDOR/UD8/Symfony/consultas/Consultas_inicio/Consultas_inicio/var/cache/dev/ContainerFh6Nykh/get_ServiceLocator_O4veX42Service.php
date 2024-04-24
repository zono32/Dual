<?php

namespace ContainerFh6Nykh;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\ContainerInterface;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class get_ServiceLocator_O4veX42Service extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.service_locator.o4veX42' shared service.
     *
     * @return \Symfony\Component\DependencyInjection\ServiceLocator
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->privates['.service_locator.o4veX42'] = new \Symfony\Component\DependencyInjection\Argument\ServiceLocator($container->getService ??= $container->getService(...), [
            'App\\Controller\\ConsultasController::index' => ['privates', '.service_locator.04_6m5a', 'get_ServiceLocator_046m5aService', true],
            'App\\Controller\\LuckyController::getMessage' => ['privates', '.service_locator.qlTmxuJ', 'get_ServiceLocator_QlTmxuJService', true],
            'App\\Controller\\NotaController::find' => ['privates', '.service_locator.hwuC0IP', 'get_ServiceLocator_HwuC0IPService', true],
            'App\\Controller\\NotaController::list' => ['privates', '.service_locator.Faif7QS', 'get_ServiceLocator_Faif7QSService', true],
            'App\\Controller\\NotaController::new' => ['privates', '.service_locator.2iUWbMv', 'get_ServiceLocator_2iUWbMvService', true],
            'App\\Kernel::loadRoutes' => ['privates', '.service_locator.y4_Zrx.', 'get_ServiceLocator_Y4Zrx_Service', true],
            'App\\Kernel::registerContainerConfiguration' => ['privates', '.service_locator.y4_Zrx.', 'get_ServiceLocator_Y4Zrx_Service', true],
            'kernel::loadRoutes' => ['privates', '.service_locator.y4_Zrx.', 'get_ServiceLocator_Y4Zrx_Service', true],
            'kernel::registerContainerConfiguration' => ['privates', '.service_locator.y4_Zrx.', 'get_ServiceLocator_Y4Zrx_Service', true],
            'App\\Controller\\ConsultasController:index' => ['privates', '.service_locator.04_6m5a', 'get_ServiceLocator_046m5aService', true],
            'App\\Controller\\LuckyController:getMessage' => ['privates', '.service_locator.qlTmxuJ', 'get_ServiceLocator_QlTmxuJService', true],
            'App\\Controller\\NotaController:find' => ['privates', '.service_locator.hwuC0IP', 'get_ServiceLocator_HwuC0IPService', true],
            'App\\Controller\\NotaController:list' => ['privates', '.service_locator.Faif7QS', 'get_ServiceLocator_Faif7QSService', true],
            'App\\Controller\\NotaController:new' => ['privates', '.service_locator.2iUWbMv', 'get_ServiceLocator_2iUWbMvService', true],
            'kernel:loadRoutes' => ['privates', '.service_locator.y4_Zrx.', 'get_ServiceLocator_Y4Zrx_Service', true],
            'kernel:registerContainerConfiguration' => ['privates', '.service_locator.y4_Zrx.', 'get_ServiceLocator_Y4Zrx_Service', true],
        ], [
            'App\\Controller\\ConsultasController::index' => '?',
            'App\\Controller\\LuckyController::getMessage' => '?',
            'App\\Controller\\NotaController::find' => '?',
            'App\\Controller\\NotaController::list' => '?',
            'App\\Controller\\NotaController::new' => '?',
            'App\\Kernel::loadRoutes' => '?',
            'App\\Kernel::registerContainerConfiguration' => '?',
            'kernel::loadRoutes' => '?',
            'kernel::registerContainerConfiguration' => '?',
            'App\\Controller\\ConsultasController:index' => '?',
            'App\\Controller\\LuckyController:getMessage' => '?',
            'App\\Controller\\NotaController:find' => '?',
            'App\\Controller\\NotaController:list' => '?',
            'App\\Controller\\NotaController:new' => '?',
            'kernel:loadRoutes' => '?',
            'kernel:registerContainerConfiguration' => '?',
        ]);
    }
}
