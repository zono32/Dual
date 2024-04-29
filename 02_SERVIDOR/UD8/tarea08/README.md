# Tarea o8

### 1- Crea un nuevo proyecto Symfony tarea08. Apunta el comando que has utilizado. (0,2 puntos)

- composer create-project symfony/skeleton:"7.0.\*" tarea08
- composer require webapp

### Crea la base de datos con los comandos correspondientes

- php bin/console doctrine:database:create


### Redirigir usuario autenticado
https://symfony.com/doc/5.x/security.html#fetching-the-user-object



### Bootstrap
php bin/console importmap:require bootstrap
php bin/console importmap:install
php bin/console importmap:require bootstrap/dist/css/bootstrap.min.css

Para poder usar los estilos de Bootstrap, los añadimos en app.js:
import 'bootstrap/dist/css/bootstrap.min.css';

### Migrar tabla
php bin/console doctrine:migrations:execute 'DoctrineMigrations\Version20240429153816'